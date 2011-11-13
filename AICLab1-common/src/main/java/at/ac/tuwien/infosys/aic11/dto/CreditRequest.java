package at.ac.tuwien.infosys.aic11.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import at.ac.tuwien.infosys.aic11.dto.Duration;

@XmlType( name = "credit_request" )
public class CreditRequest extends DTO {
	public CreditRequest() {
		this( null );
	}
	
	public CreditRequest( Customer c ) {
		this.customer = c;
		
		warrantors = new ArrayList<Warrantor>();			
	}

	// members
	@XmlAttribute(name="request_id")
	public long getRequestId() { return requestId; }
	public String getReason()  { return reason;    }

	public void setRequestId( long requestId ) { this.requestId = requestId; }
	public void setReason( String reason )     { this.reason = reason;       }

	// relations
	@XmlElement(required=true)
	public Money          getMoney()       { return money;      }
	@XmlElement(required=true)
	public Duration       getDuration()    { return duration;   }
	@XmlElement(nillable=true)
	public Offer          getOffer()       { return offer;      }
	@XmlElement(nillable=true)
	public List<Warrantor> getWarrantors() { return warrantors; }
	@XmlElement(required=true)
	public Customer        getCustomer()   { return customer;  }


	public void setMoney(Money money)                     { this.money = money;           }
	public void setDuration(Duration duration)            { this.duration = duration;     }
	public void setOffer(Offer offer)                     { this.offer = offer;           }
	public void setWarrantors(List<Warrantor> warrantors) { this.warrantors = warrantors; }
	public void setCustomer( Customer customer )          { this.customer = customer;   }
	//***** PRIVATE PARTS

	// members
	private long   requestId;
	private String reason;

	// relations
	private Customer        customer;
	private List<Warrantor> warrantors;
	private Money           money;
	private Duration        duration;
	private Offer           offer;
}
