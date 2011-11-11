package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="money")
public class Money extends DTO {
	public Money() {}
	
	public Money( String currencyCode, long amount ) {
		this.currencyCode = currencyCode;
		this.amount = amount;
	}

	@XmlElement(name="currency_code")
	public String getCurrencyCode() { return currencyCode; }
	public long getAmount()         { return amount;       }

	public void setCurrencyCode( String currencyCode ) { this.currencyCode = currencyCode; }
	public void setAmount( long amount )               { this.amount = amount;             }

	private String currencyCode;
	private long   amount;
}
