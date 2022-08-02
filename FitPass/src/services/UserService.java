package services;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.UserDAO;
import dto.user.UserDTO;

@Path("users")
public class UserService {
	@Context
	ServletContext ctx;
	
	public UserService() {}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("userDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("userDAO", new UserDAO(contextPath));
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNonDeletedUsers(@Context HttpServletRequest request) {
		UserDAO userDAO = (UserDAO) ctx.getAttribute("userDAO");
		
		ArrayList<UserDTO> allUsers = new ArrayList<UserDTO>();
		for (UserDTO u: userDAO.getAllUsers().values()) {
			if (!u.isLogicallyDeleted()) {
				allUsers.add(u);
			}
		}
		
		return Response.status(200).entity(allUsers).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@Context HttpServletRequest request, 
			@PathParam("id") String id) {
		UserDAO userDAO = (UserDAO) ctx.getAttribute("userDAO");
		
		UserDTO user = userDAO.findById(Long.parseLong(id));
		if (user == null) {
			return Response.status(404)
					.entity("User with given id does not exist!").build();
		}
		
		return Response.status(200).entity(user).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@Context HttpServletRequest request, 
			@PathParam("id") String id, UserDTO modifiedUser) {
		UserDAO userDAO = (UserDAO) ctx.getAttribute("userDAO");
		
		UserDTO existingUserWithSameUsername = 
				userDAO.findByUsername(modifiedUser.getUsername());
		if (existingUserWithSameUsername != null) {
			if (existingUserWithSameUsername.getId() != modifiedUser.getId()) {
				return Response.status(400)
						.entity("Given username is already taken!").build();
			}
		}
		
		UserDTO updatedUser = userDAO.updateUser(Long.parseLong(id), modifiedUser);
		request.getSession().setAttribute("loggedUser", updatedUser);
		
		return Response.status(200).entity(updatedUser).build();
	}
}
