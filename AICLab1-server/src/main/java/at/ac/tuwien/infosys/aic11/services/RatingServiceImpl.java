package at.ac.tuwien.infosys.aic11.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import at.ac.tuwien.infosys.aic11.dto.Rating;

public class RatingServiceImpl extends AbstractService implements RestService, RatingService {
//	@GET
//	@Path("/ratings/customers/{customer_id}")
//	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Rating getRatingForCustomerId( /*@PathParam("customer_id")*/ long id ) {
		return new Rating();
	}
	
//	@GET
//	@Path("/ratings/hello")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String sayPlainTextHello() {
//		return "Hello Jersey";
//	}

//	// This method is called if XML is request
//	@GET
//	@Path("/ratings/hello")
//	@Produces(MediaType.TEXT_XML)
//	public String sayXMLHello() {
//		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
//	}
//
//	// This method is called if HTML is request
//	@GET
//	@Path("/ratings/hello")
//	@Produces(MediaType.TEXT_HTML)
	@Override
	public String sayHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
	
//	@GET
//	@Path("/*")
//	@Produces(MediaType.TEXT_HTML)
//	public Response catchall() {
//		return Response.status( Status.NOT_FOUND ).build();
//	}
}
