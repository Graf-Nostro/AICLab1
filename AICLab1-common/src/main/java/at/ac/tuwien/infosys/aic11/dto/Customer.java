package at.ac.tuwien.infosys.aic11.dto;

import java.math.BigDecimal;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name="customer" )
public class Customer extends Warrantor {
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
	public Addresses                        getAddress()                { return address;                }
	@XmlElement(name="disbursement_preference",required=true)
	public DisbursementPreference           getDisbursementPreference() { return disbursementPreference; }
	@XmlElement(nillable=true)
	public Rating                           getRating()                 { return rating;                 }
	@XmlElement(name="credit_requests", nillable=true)
	public Set<CreditRequest>               getCreditRequests()         { return creditRequests;         }
	
	public void setAddress( Addresses address )                        { this.address = address;               }
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
	private Addresses              address;
	private DisbursementPreference disbursementPreference;
	private Rating                 rating;
	private Set<CreditRequest>     creditRequests;	
}
