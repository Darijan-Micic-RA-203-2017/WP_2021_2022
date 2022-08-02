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

import dao.LocationDAO;
import dto.location.LocationDTO;

@Path("locations")
public class LocationService {
	@Context
	ServletContext ctx;
	
	public LocationService() {}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("locationDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("locationDAO", new LocationDAO(contextPath));
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNonDeletedLocations(@Context HttpServletRequest request) {
		LocationDAO locationDAO = (LocationDAO) ctx.getAttribute("locationDAO");
		
		ArrayList<LocationDTO> allLocations = new ArrayList<LocationDTO>();
		for (LocationDTO l: locationDAO.getAllLocations().values()) {
			if (!l.isLogicallyDeleted()) {
				allLocations.add(l);
			}
		}
		
		return Response.status(200).entity(allLocations).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocation(@Context HttpServletRequest request, 
			@PathParam("id") String id) {
		LocationDAO locationDAO = (LocationDAO) ctx.getAttribute("locationDAO");
		
		LocationDTO location = locationDAO.findById(Long.parseLong(id));
		if (location == null) {
			return Response.status(404)
					.entity("Location with given id does not exist!").build();
		}
		
		return Response.status(200).entity(location).build();
	}
}
