package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bank_transfer")
public class BankTransfer extends DisbursementPreference {
	@XmlElement(name="bank_name")
	public String getBankName() { return bankName; }
	public String getBic()      { return bic;      }
	public String getIban()     { return iban;     }
	
	public void setBankName( String bankName ) { this.bankName = bankName; }
	public void setBic( String bic )           { this.bic = bic;           }
	public void setIban( String iban )         { this.iban = iban;         }

	private	String bankName;
	private String bic;
	private String iban;
}
