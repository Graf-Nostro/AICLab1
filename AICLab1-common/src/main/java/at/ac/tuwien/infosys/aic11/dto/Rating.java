package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rating")
public class Rating {
	@XmlElement(required=true)
	public Customer       getCustomer() { return customer; }
	@XmlElement(required=true)
	public CustomerRating getRating()   { return rating;   }

	public void setCustomer( Customer customer )   { this.customer = customer; }
	public void setRating( CustomerRating rating ) { this.rating = rating;     }

	//***** PRIVATE PARTS
	
	private Customer       customer;
	private CustomerRating rating;
}
