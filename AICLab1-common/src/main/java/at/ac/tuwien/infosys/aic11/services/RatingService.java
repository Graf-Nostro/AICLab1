package at.ac.tuwien.infosys.aic11.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.Rating;


public interface RatingService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ratings/customers/{customer_id}")
	Rating getRatingForCustomerId( @PathParam("customer_id") long id );

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/ratings/customers/{customer_id}")
	Rating getRatingForCustomerId_plainText( @PathParam("customer_id") long id );

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/ratings/hello")
	String sayHello();
}
