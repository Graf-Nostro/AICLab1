package at.ac.tuwien.infosys.aic11.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlType( name="warrantor" )
public class Warrantor extends Customer {
	public Warrantor() {
		this( new HashSet<CreditRequest>() );
	}
	public Warrantor( CreditRequest... requests ) {
		this( new HashSet<CreditRequest>() );
		
		for ( CreditRequest request : requests ) creditRequests.add( request );
	}
	public Warrantor( Set<CreditRequest> requests ) {
		this.creditRequests = requests;
	}
	
	@XmlElement( name="credit_requests" )
	public Set<CreditRequest> getCreditRequests() { return creditRequests; }

	public void setCreditRequests(Set<CreditRequest> creditRequests) { this.creditRequests = creditRequests; }

	//***** PRIVATE PARTS
	
	private Set<CreditRequest> creditRequests;	
}
