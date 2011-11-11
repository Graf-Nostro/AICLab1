package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum CustomerRating {
	AAA, AAPlus, AA, AAMinus, APlus, A, AMinus, Defaulting;
}
