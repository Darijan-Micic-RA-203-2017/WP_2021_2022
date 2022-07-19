package services;

import java.util.ArrayList;
import java.util.Comparator;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.VenueDAO;
import dto.venue.VenueDTO;

@Path("venues")
public class VenueService {
	@Context
	ServletContext ctx;
	
	public VenueService() {}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("venueDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("venueDAO", new VenueDAO(contextPath));
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNonDeletedVenues(@Context HttpServletRequest request) {
		VenueDAO venueDAO = (VenueDAO) ctx.getAttribute("venueDAO");
		
		ArrayList<VenueDTO> allVenues = new ArrayList<VenueDTO>();
		for (VenueDTO v: venueDAO.getAllVenues().values()) {
			if (!v.isLogicallyDeleted()) {
				allVenues.add(v);
			}
		}
		
		Comparator<VenueDTO> byStatusInReverseOrder = 
				Comparator.comparing(VenueDTO::getStatus).reversed()
				.thenComparing(VenueDTO::getId);
		allVenues.sort(byStatusInReverseOrder);
		
		return Response.status(200).entity(allVenues).build();
	}
}
