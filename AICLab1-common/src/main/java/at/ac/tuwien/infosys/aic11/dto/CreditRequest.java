package at.ac.tuwien.infosys.aic11.dto;

import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import at.ac.tuwien.infosys.aic11.dto.Duration;

@XmlType( name = "credit_request" )
public class CreditRequest extends DTO {
	public CreditRequest() {}
	
	public CreditRequest( Money money, Duration duration, Offer offer, 
			Set<Warrantor> warrantors, long requestId, String reason ) {
		super();
		this.money = money;
		this.duration = duration;
		this.offer = offer;
		this.warrantors = warrantors;
		this.requestId = requestId;
		this.reason = reason;
	}

	// members
	@XmlAttribute(name="request_id")
	public long getRequestId() { return requestId; }
	public String getReason()  { return reason;    }

	public void setRequestId( long requestId ) { this.requestId = requestId; }
	public void setReason( String reason )     { this.reason = reason;       }

	// relations
	@XmlElement(required=true)
	public Money          getMoney()      { return money;      }
	@XmlElement(required=true)
	public Duration       getDuration()   { return duration;   }
	@XmlElement(nillable=true)
	public Offer          getOffer()      { return offer;      }
	@XmlElement(nillable=true)
	public Set<Warrantor> getWarrantors() { return warrantors; }
	@XmlElement(required=true)
	public Set<Customer>  getCustomers()  { return customers;  }


	public void setMoney(Money money)                    { this.money = money;           }
	public void setDuration(Duration duration)           { this.duration = duration;     }
	public void setOffer(Offer offer)                    { this.offer = offer;           }
	public void setWarrantors(Set<Warrantor> warrantors) { this.warrantors = warrantors; }
	public void setCustomers( Set<Customer> customers )  { this.customers = customers;   }
	//***** PRIVATE PARTS

	// members
	private long   requestId;
	private String reason;

	// relations
	private Money          money;
	private Duration       duration;
	private Offer          offer;
	private Set<Warrantor> warrantors;
	private Set<Customer>  customers;
}
