package services;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.location.Address;
import dao.AddressDAO;

@Path("addresses")
public class AddressService {
	@Context
	ServletContext ctx;
	
	public AddressService() {}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("addressDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("addressDAO", new AddressDAO(contextPath));
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNonDeletedAddresses(@Context HttpServletRequest request) {
		AddressDAO addressDAO = (AddressDAO) ctx.getAttribute("addressDAO");
		
		ArrayList<Address> allAddresses = new ArrayList<Address>();
		for (Address a: addressDAO.getAllAddresses().values()) {
			if (!a.isLogicallyDeleted()) {
				allAddresses.add(a);
			}
		}
		
		return Response.status(200).entity(allAddresses).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddress(@Context HttpServletRequest request, @PathParam("id") String id) {
		AddressDAO addressDAO = (AddressDAO) ctx.getAttribute("addressDAO");
		
		Address address = addressDAO.findById(Long.parseLong(id));
		if (address == null) {
			return Response.status(404).entity("Address with given id does not exist!").build();
		}
		
		return Response.status(200).entity(address).build();
	}
}
