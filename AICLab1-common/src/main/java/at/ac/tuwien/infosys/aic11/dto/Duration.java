package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlType;

import at.ac.tuwien.infosys.aic11.dto.DTO;

@XmlType(name="duration")
public class Duration extends DTO {
	public int getYears() { return years; }

	public void setYears( int years ) { this.years = years; }

	private int years;
}
