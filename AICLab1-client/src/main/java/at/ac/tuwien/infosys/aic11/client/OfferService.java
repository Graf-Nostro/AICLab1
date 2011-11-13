package at.ac.tuwien.infosys.aic11.client;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.InterestRate;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;
import at.ac.tuwien.infosys.aic11.services.ContractManagementService;
import at.ac.tuwien.infosys.aic11.services.RatingService;

public class OfferService {

	public OfferService() {}
	
	public OfferService( RatingService ratings, ContractManagementService contracts ) {
		this.ratings = ratings;
		this.contracts = contracts;
	}

	public Offer generateOffer( CreditRequest request ) {
//		System.out.println( request );
//		
//		// fill in ratings
//		Customer c = request.getCustomer();
//		
//		Rating rating = getRating( c );
//
//		c.setRating( rating );
//		rating.setCustomer( c );
//		
//		for ( Warrantor w : request.getWarrantors() ) {
//			rating = getRating( w );
//
//			w.setRating( rating );
//			rating.setCustomer( w );
//		}
//		
//		return askForOffer( request );
		
		return askForOffer( null );
	}
	
	private Rating getRating( Customer c ) {
		return ratings.getRatingForCustomerId( c.getCustomerId() );
	}
	
	private Offer askForOffer( CreditRequest request ) {
		return new Offer( 15, "No comments", null, new InterestRate( 5.0 ) );
	}
	
	private RatingService             ratings;
	private ContractManagementService contracts;
}
