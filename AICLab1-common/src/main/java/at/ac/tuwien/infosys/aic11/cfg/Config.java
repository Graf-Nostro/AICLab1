package at.ac.tuwien.infosys.aic11.cfg;

import java.io.IOException;
import java.util.Properties;

public final class Config {
	public Config() throws IOException {
		props = new Properties();
		props.load( getClass().getClassLoader().getResourceAsStream("aic11.properties") );
	}
	
	public String get( String property )    { return getProp(property); }
	public int    getInt( String property ) { return Integer.parseInt( getProp(property) ); }
	
	public String get( String property, String defaultValue ) {
		return getProp(property, defaultValue );
	}
	
	//***** PRIVATE PARTS
	
	private final String getProp( String name ) {
		String prop = props.getProperty(name);
		
		if ( prop == null ) 
			throw new PropertyNotFoundException(name);
		else 
			return prop;
	}
	private final String getProp( String name, String defaultVal ) {
		return props.getProperty(name, defaultVal);
	}
	
	private final Properties props;
}
