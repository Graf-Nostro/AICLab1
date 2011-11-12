package at.ac.tuwien.infosys.aic11.services;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.Rating;


public class RatingServiceImpl extends AbstractService implements AbstractRestService, RatingService {
	@Override
	public CustomerRating getRatingForCustomerId( long id ) {
		return CustomerRating.AAA;
	}
	
	@Override
	public String sayHello() {
		return "<html> " + 
		         "<title>" + 
		            "Hello World" + 
		         "</title>" +
		         "<body>" +
		           "<h1>" + 
		             "Hello World" + 
		           "</h1>" + 
		         "</body>" +
		       "</html> ";
	}

	@Override
	public Rating getRatingForCustomerId_plainText( long id ) {
		return new Rating( new Customer(), CustomerRating.AAA );
	}
}
