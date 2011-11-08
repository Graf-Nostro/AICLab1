package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name="addresses" )
public class Addresses extends DTO {
	@XmlAttribute
	public String getId()      { return id;      }
	public String getStreet()  { return street;  }
	public String getCity()    { return city;    }
	public String getHouse()   { return house;   }
	public String getDoor()    { return door;    }
	@XmlElement(name="zip_code")
	public String getZipCode() { return zipCode; }
	
	public void setId( String id )           { this.id = id;           }
	public void setStreet( String street )   { this.street = street;   }
	public void setCity( String city )       { this.city = city;       }
	public void setHouse( String house )     { this.house = house;     }
	public void setDoor( String door )       { this.door = door;       }
	public void setZipCode( String zipCode ) { this.zipCode = zipCode; }
	
	private String id;
	private String street;
	private String city;
	private String house;
	private String door;
	private String zipCode;
}
