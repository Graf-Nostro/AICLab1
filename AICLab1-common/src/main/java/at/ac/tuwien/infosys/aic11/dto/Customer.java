package at.ac.tuwien.infosys.aic11.dto;

import java.math.BigDecimal;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;




@XmlType( name="customer" )
public class Customer extends Warrantor {
	public Customer() {/**/}
		
	public Customer( long customerId, String firstName, String middleName,
			String lastName, BigDecimal openBalance, Address address,
			DisbursementPreference disbursementPreference, Rating rating,
			Set<CreditRequest> creditRequests ) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.openBalance = openBalance;
		this.address = address;
		this.disbursementPreference = disbursementPreference;
		this.rating = rating;
		this.creditRequests = creditRequests;
	}


	// members
	@XmlAttribute(name="customer_id")
	public long                             getCustomerId()   { return customerId;             }
	@XmlElement(name="first_name")
	public String                           getFirstName()    { return firstName;              }
	@XmlElement(name="middle_name")
	public String                           getMiddleName()   { return middleName;             }
	@XmlElement(name="last_name")
	public String                           getLastName()     { return lastName;               }
	@XmlElement(name="open_balance")
	public BigDecimal                       getOpenBalance()  { return openBalance;            }

	public void setCustomerId( long customerId )         { this.customerId = customerId;   }
	public void setFirstName( String firstName )         { this.firstName = firstName;     }
	public void setMiddleName( String middleName )       { this.middleName = middleName;   }
	public void setLastName( String lastName )           { this.lastName = lastName;       }
	public void setOpenBalance( BigDecimal openBalance ) { this.openBalance = openBalance; }
	
	// relations
	@XmlElement(required=true)
	public Address                        getAddress()                { return address;                }
	@XmlElement(name="disbursement_preference",required=true)
	public DisbursementPreference           getDisbursementPreference() { return disbursementPreference; }
	@XmlElement(nillable=true)
	public Rating                           getRating()                 { return rating;                 }
	@XmlElement(name="credit_requests", nillable=true)
	public Set<CreditRequest>               getCreditRequests()         { return creditRequests;         }
	
	public void setAddress( Address address )                        { this.address = address;               }
	public void setDisbursementPreference( DisbursementPreference d )  { this.disbursementPreference = d;      }
	public void setRating( Rating rating )                             { this.rating = rating;                 }
	public void setCreditRequests( Set<CreditRequest> creditRequests ) { this.creditRequests = creditRequests; }
	
	//***** PRIVATE PARTS

	// members
	private long                   customerId;
	private String                 firstName;
	private String                 middleName;
	private String                 lastName;
	private BigDecimal             openBalance;
	
	// relations
	private Address              address;
	private DisbursementPreference disbursementPreference;
	private Rating                 rating;
	private Set<CreditRequest>     creditRequests;	
}
