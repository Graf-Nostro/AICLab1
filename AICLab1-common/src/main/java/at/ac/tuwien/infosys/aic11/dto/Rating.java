package at.ac.tuwien.infosys.aic11.dto;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rating")
public class Rating extends DTO {
	public Rating() {/**/}
	
	public Rating( Customer customer, CustomerRating rating ) {
		this.customer = customer;
		this.rating   = rating;
	}

	public Customer       getCustomer() { return customer; }
	public CustomerRating getRating()   { return rating;   }

	public void setCustomer( Customer customer )   { this.customer = customer; }
	public void setRating( CustomerRating rating ) { this.rating   = rating;   }

	//***** PRIVATE PARTS
	@XmlTransient
	private Customer       customer;
	private CustomerRating rating;
}
