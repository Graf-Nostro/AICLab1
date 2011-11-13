package at.ac.tuwien.infosys.aic11.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;

public class RatingServiceMock {
	
	private final Customer cr1 = new Customer();
	private final Customer cr2 = new Warrantor();
	private final Customer cr3 = new Warrantor();
	private final Set<Customer> customers = new HashSet<Customer>();

	public RatingServiceMock(){
		customers.add(cr1);
		customers.add(cr2);
		customers.add(cr3);
		
		cr1.setFirstName("A");
		cr1.setMiddleName("");
		cr1.setLastName("A");
		cr1.setOpenBalance(new BigDecimal(10000));
		
		cr2.setFirstName("B");
		cr2.setMiddleName("");
		cr2.setLastName("B");
		cr2.setOpenBalance(new BigDecimal(5000));
		
		cr1.setFirstName("C");
		cr1.setMiddleName("");
		cr1.setLastName("C");
		cr1.setOpenBalance(new BigDecimal(2000));
		
		cr1.setCustomerId(0);
		cr2.setCustomerId(1);
		cr1.setRating(new Rating(cr1, CustomerRating.AAA));
		cr2.setRating(new Rating(cr2, CustomerRating.AAPlus));
		cr3.setRating(new Rating(cr3, CustomerRating.APlus));
		Set<CreditRequest> creditRequests = new HashSet<CreditRequest>();
		List<Warrantor> warrantors = new ArrayList<Warrantor>();
		warrantors.add((Warrantor) cr2);
		warrantors.add((Warrantor) cr3);
		
		CreditRequest creditRequest1 = new CreditRequest();
		creditRequest1.setRequestId(0);
		creditRequest1.setWarrantors(warrantors);
		creditRequests.add(creditRequest1);
		cr1.setCreditRequests(creditRequests);
	}
	
	/**
	 * mock legacy service provides data
	 * 
	 * @param id
	 * @return Customers CustomerRating and Defaulting for customer not found
	 * 
	 */
	public Rating getCustomerRating(long id){
		if(id == 0){
			return cr1.getRating();
		} else if (id == 1){
			return cr2.getRating();
		} else {
			return new Rating(null, CustomerRating.Defaulting);
		}
	}
	
	/**
	 * mock legacy service provides data
	 * 
	 * @param id
	 * @return List<Rating> with two entries each a Warrantor
	 */
	public List<Rating> getWarrontorRatingForCustomerId(long id){
		List<Rating> ratings = new ArrayList<Rating>();
		
		Iterator<Customer> iter = customers.iterator();
			while(iter.hasNext()){
				Customer customer = iter.next();
			if(customer.getCustomerId() == id){
				for(CreditRequest credits: customer.getCreditRequests()){
					Iterator<Warrantor> iterWarrantor = credits.getWarrantors().iterator();
					while(iterWarrantor.hasNext()){
						Warrantor war = iterWarrantor.next();
						ratings.add(war.getRating());
					}
				}
			}
		}
		return ratings;
	}
}
