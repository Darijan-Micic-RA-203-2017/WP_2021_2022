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

import beans.venue.VenueType;
import dao.VenueTypeDAO;

@Path("venue-types")
public class VenueTypeService {
	@Context
	ServletContext ctx;
	
	public VenueTypeService() {}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("venueTypeDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("venueTypeDAO", new VenueTypeDAO(contextPath));
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNonDeletedVenueTypes(@Context HttpServletRequest request) {
		VenueTypeDAO venueTypeDAO = (VenueTypeDAO) ctx.getAttribute("venueTypeDAO");
		
		ArrayList<VenueType> allVenueTypes = new ArrayList<VenueType>();
		for (VenueType vType: venueTypeDAO.getAllVenueTypes().values()) {
			if (!vType.isLogicallyDeleted()) {
				allVenueTypes.add(vType);
			}
		}
		
		return Response.status(200).entity(allVenueTypes).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVenueType(@Context HttpServletRequest request, @PathParam("id") String id) {
		VenueTypeDAO venueTypeDAO = (VenueTypeDAO) ctx.getAttribute("venueTypeDAO");
		
		VenueType venueType = venueTypeDAO.findById(Long.parseLong(id));
		if (venueType == null) {
			return Response.status(404).entity("Venue type with given id does not exist!").build();
		}
		
		return Response.status(200).entity(venueType).build();
	}
}
