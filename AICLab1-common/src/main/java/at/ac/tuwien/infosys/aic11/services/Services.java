package at.ac.tuwien.infosys.aic11.services;

import java.util.Stack;

import javax.jws.WebService;

public abstract class Services {
	public static String getServiceName( Class<?> serviceClass ) {
		// try to get service name from WebService annotation, search whole hierarchy
		Stack<Class<?>> classes = new Stack<Class<?>>();
		
		classes.push( serviceClass );
		
		while ( !classes.isEmpty() ) {
			Class<?> c = classes.pop();
			
			if ( c == null ) break; // we reached the parent of Object.class, end of the line
			
			WebService metaData = c.getAnnotation( WebService.class );
			
			if ( metaData != null ) {
				String serviceName = metaData.serviceName();
				if ( serviceName != null && !serviceName.isEmpty() )
					return metaData.serviceName();
			}
			
			// search supertypes
			classes.push( c.getSuperclass() );
			for ( Class<?> i : c.getInterfaces() ) classes.push( i );
		}
		
		// no WebService annotation was found, use the classes name
		return serviceClass.getSimpleName();
	}
	
	private Services() {/**/}
}
