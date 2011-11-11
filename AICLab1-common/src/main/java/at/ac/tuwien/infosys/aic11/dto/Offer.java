package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="offer")
public class Offer extends DTO {
	// members
	@XmlAttribute(name="offer_id")
	public long getOfferId()    { return offerId;  }
	public String getComments() { return comments; }
	
	public void setOfferId( long offerId )     { this.offerId = offerId;   }
	public void setComments( String comments ) { this.comments = comments; }

	// relations
	@XmlElement(name="credit_request", required=true )
	public CreditRequest getCreditRequest() { return creditRequest; }
	@XmlElement(name="interest_rate", required=true )
	public InterestRate getInterestRate()   { return interestRate;  }
	
	public void setCreditRequest( CreditRequest creditRequest ) { this.creditRequest = creditRequest; }
	public void setInterestRate( InterestRate interestRate )    { this.interestRate = interestRate;   }

	//***** PRIVATE PARTS
	
	private long         offerId;
	private String       comments;
	
	private CreditRequest creditRequest;
	private InterestRate  interestRate;
}
