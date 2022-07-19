package services;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.UserDAO;
import dto.user.UserDTO;
import validators.UserValidator;

@Path("")
public class AuthorizationService {
	@Context
	ServletContext ctx;
	
	public AuthorizationService() {}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("userDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("userDAO", new UserDAO(contextPath));
		}
	}
	
	@POST
	@Path("register-as-a-buyer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerAsABuyer(UserDTO user, @Context HttpServletRequest request) {
		if (!UserValidator.isNewlyRegisteredBuyerDTOValid(user)) {
			return Response.status(400).entity("Invalid data!").build();
		}
		
		UserDAO userDAO = (UserDAO) ctx.getAttribute("userDAO");
		
		UserDTO existingUserWithSameUsername = 
				userDAO.findByUsername(user.getUsername());
		if (existingUserWithSameUsername != null) {
			return Response.status(400)
					.entity("Given username is already taken!").build();
		}
		
		userDAO.registerANewBuyer(user);
		
		return Response.status(201).build();
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(UserDTO user, @Context HttpServletRequest request) {
		UserDAO userDAO = (UserDAO) ctx.getAttribute("userDAO");
		
		UserDTO loggedUser = userDAO.findByUsernameAndPassword(user.getUsername(), 
				user.getPassword());
		if (loggedUser == null) {
			return Response.status(400).entity("Invalid username and/or password!").build();
		}
		
		if (loggedUser.isLogicallyDeleted()) {
			return Response.status(400).entity("User with entered credentials is deleted!").build();
		}
		
		request.getSession().setAttribute("loggedUser", loggedUser);
		
		return Response.status(200).build();
	}
	
	@POST
	@Path("logout")
	public Response logout(@Context HttpServletRequest request) {
		request.getSession().invalidate();
		
		return Response.status(200).entity("User was successfully logged out.").build();
	}
	
	@GET
	@Path("logged-user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLoggedUser(@Context HttpServletRequest request) {
		UserDTO loggedUser = (UserDTO) request.getSession().getAttribute("loggedUser");
		
		return Response.status(200).entity(loggedUser).build();
	}
}
