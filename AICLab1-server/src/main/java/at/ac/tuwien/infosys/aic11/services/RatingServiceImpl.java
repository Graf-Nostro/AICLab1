package at.ac.tuwien.infosys.aic11.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.ac.tuwien.infosys.aic11.dto.Rating;

public class RatingServiceImpl extends AbstractService implements RestService, RatingService {
	@GET
	@Path("/ratings/{customer_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Rating ratings( @PathParam("customer_id") long id ) {
		return new Rating();
	}
	
	@GET
	@Path("/ratings")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	// This method is called if XML is request
	@GET
	@Path("/ratings")
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Path("/ratings")
	@Produces(MediaType.TEXT_HTML)
	public String sayHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
}
