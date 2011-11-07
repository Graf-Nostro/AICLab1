package at.ac.tuwien.infosys.aic11.cfg;

public class PropertyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -351992620707412985L;

	public PropertyNotFoundException( String propertyName ) {
		super("Property not found: " + propertyName);
		this.propertyName = propertyName;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	private final String propertyName;
}
