package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="interest_rate")
public class InterestRate extends DTO {
	public double getRate() { return rate; }

	public void setRate( double rate ) { this.rate = rate; }

	private double rate;
}
