package at.ac.tuwien.infosys.aic11.client;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.cfg.Config;
import at.ac.tuwien.infosys.aic11.services.RatingService;
import at.ac.tuwien.infosys.aic11.services.Services;
import at.ac.tuwien.infosys.aic11.services.TestService;

public class AIC1Client {
	public static void main(String[] args) throws Exception {
		TestService   testWS  = getWebService( TestService.class );
		RatingService ratings = getRestService( RatingService.class );
		
		println( ratings.getRatingForCustomerId( 0 ) );
//		println( testWS.bar("foo") );
	}
	
	@SuppressWarnings("unchecked")
	public static <E> E getWebService( Class<E> serviceClass ) {
		Config cfg = new Config();
		
		ClientProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.getInInterceptors().add( new LoggingInInterceptor() );
		factory.getOutInterceptors().add( new LoggingOutInterceptor() );
		factory.setServiceClass( serviceClass );
		factory.setAddress(
			String.format(
				"http://localhost:%d/%s",
				cfg.getInt("http.server.port.ws"),
				Services.getServiceName( serviceClass )
			)
		);

		return (E) factory.create();
	}
	@SuppressWarnings("unchecked")
	public static <E> E getRestService( Class<E> serviceClass ) {
		Config cfg = new Config();
		
		JAXRSClientFactoryBean factory = new JAXRSClientFactoryBean();
		
		factory.setResourceClass( serviceClass );
		factory.setAddress( "http://localhost:" + cfg.getInt("http.server.port.rs") );
		
//		BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
//		JAXRSBindingFactory factory = new JAXRSBindingFactory();
//		factory.setBus(sf.getBus());
//		manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
//
//		sf.create();
		
		return (E) factory.create( RatingService.class );
		

//		factory.getInInterceptors().add( new LoggingInInterceptor() );
//		factory.getOutInterceptors().add( new LoggingOutInterceptor() );
//		factory.setServiceClass( serviceClass );
//		factory.setAddress(
//			String.format(
//				"http://localhost:%d/%s",
//				cfg.getInt("http.server.port.ws"),
//				Services.getServiceName( serviceClass )
//			)
//		);
//
//		return (E) factory.create();
	}
	
	public static void println( Object msg ) {
		System.out.println( msg );
	}
}
