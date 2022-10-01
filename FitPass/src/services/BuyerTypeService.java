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

import beans.user.BuyerType;
import dao.BuyerTypeDAO;

@Path("buyer-types")
public class BuyerTypeService {
	@Context
	ServletContext ctx;
	
	public BuyerTypeService() {}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("buyerTypeDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("buyerTypeDAO", new BuyerTypeDAO(contextPath));
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNonDeletedBuyerTypes(@Context HttpServletRequest request) {
		BuyerTypeDAO buyerTypeDAO = (BuyerTypeDAO) ctx.getAttribute("buyerTypeDAO");
		
		ArrayList<BuyerType> allBuyerTypes = new ArrayList<BuyerType>();
		for (BuyerType bType: buyerTypeDAO.getAllBuyerTypes().values()) {
			if (!bType.isLogicallyDeleted()) {
				allBuyerTypes.add(bType);
			}
		}
		
		return Response.status(200).entity(allBuyerTypes).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBuyerType(@Context HttpServletRequest request, 
			@PathParam("id") String id) {
		BuyerTypeDAO buyerTypeDAO = (BuyerTypeDAO) ctx.getAttribute("buyerTypeDAO");
		
		BuyerType buyerType = buyerTypeDAO.findById(Long.parseLong(id));
		if (buyerType == null) {
			return Response.status(404)
					.entity("Buyer type with given id does not exist!").build();
		}
		
		return Response.status(200).entity(buyerType).build();
	}
}
