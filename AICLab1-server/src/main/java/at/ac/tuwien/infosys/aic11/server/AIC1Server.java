package at.ac.tuwien.infosys.aic11.server;

import java.util.List;
import java.util.logging.LogManager;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.eclipse.jetty.server.Server;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import at.ac.tuwien.infosys.aic11.cfg.CXFConfig;
import at.ac.tuwien.infosys.aic11.cfg.JettyConfig;
import at.ac.tuwien.infosys.aic11.cfg.LoggingAopConfig;
import at.ac.tuwien.infosys.aic11.cfg.XmlConfig;
import at.ac.tuwien.infosys.aic11.services.AbstractWebService;
import at.ac.tuwien.infosys.aic11.services.RestService;
import at.ac.tuwien.infosys.aic11.services.Services;

public class AIC1Server {
	public static void main( String[] args ) throws Exception {
		// set logger config
		LogManager.getLogManager().readConfiguration(
			AIC1Server.class.getClassLoader().getResourceAsStream( "logging.properties" )	
		);
			
		// wire up spring IoC
		BeanFactory ctx = new AnnotationConfigApplicationContext( 
			JettyConfig.class,      // settings for our HTTP server
			CXFConfig.class,        // settings for our web service framework
			XmlConfig.class,        // other settings from spring XML cfg
			LoggingAopConfig.class, // enable method call logging
			AIC1Server.class        // settings for this class
		);

//		print( ctx.getBean( "_bean" ) );
		
		ctx.getBean( AIC1Server.class ).start();
	}
	
	public void start() throws Exception {
		httpServer.start();
		
		publishWebServices();
		publishRestServices();
		
		httpServer.join();
	}	

	private void publishWebServices() {
		Bus bus = cxfServlet.getBus();
		BusFactory.setDefaultBus(bus);
	
		for ( AbstractWebService webService : webServices ) {
			Class<?> serviceClass = webService.getServiceClass();
			
			String serviceName = Services.getServiceName( serviceClass );
			
			Endpoint.publish( "/" + serviceName, webService );			
		}
	}
	
	private void publishRestServices() {
		for ( RestService restService : restServices ) {
			Class<?> serviceClass  = restService.getServiceClass();
			
			JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
			sf.setResourceClasses( serviceClass );
			sf.setResourceProvider( serviceClass, new SingletonResourceProvider( restService ) );
			sf.setAddress( "http://localhost:" + restServicePort );
			
			BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
			JAXRSBindingFactory factory = new JAXRSBindingFactory();
			factory.setBus(sf.getBus());
			manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);

			sf.create();
		}
	}
	
	static void print( Object o ) { System.out.println( o ); }
	
	//***** PRIVATE PARTS
	
	@Autowired
	@Qualifier("Jetty")
	private Server                    httpServer;
	@Autowired
	@Qualifier("CXF")
	private CXFNonSpringServlet       cxfServlet;
	@Autowired
	@Qualifier("CXF")
	private List<AbstractWebService>  webServices;
	@Autowired
	@Qualifier("CXF")
	private List<RestService>         restServices;
	@Autowired
	@Qualifier("CXF")
	private Integer                   restServicePort;
}
