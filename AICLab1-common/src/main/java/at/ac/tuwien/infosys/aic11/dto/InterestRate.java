package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlType;



@XmlType(name="interest_rate")
public class InterestRate extends DTO {
	public InterestRate() {/**/}
	
	public InterestRate( double rate ) {
		super();
		this.rate = rate;
	}


	public double getRate() { return rate; }

	public void setRate( double rate ) { this.rate = rate; }

	private double rate;
}
