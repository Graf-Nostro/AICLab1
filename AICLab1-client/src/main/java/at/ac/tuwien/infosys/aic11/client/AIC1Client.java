package at.ac.tuwien.infosys.aic11.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientCallback;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.message.Message;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import at.ac.tuwien.infosys.aic11.cfg.Config;
import at.ac.tuwien.infosys.aic11.services.ContractManagementService;
import at.ac.tuwien.infosys.aic11.services.Services;
import at.ac.tuwien.infosys.aic11.util.Exceptions;
import at.ac.tuwien.infosys.aic11.util.ReflectionUtil;
import at.ac.tuwien.infosys.aic11.util.Util;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;

public class AIC1Client {
	public static void main(String[] args) throws Exception {
		/** WS SECURITY */
		/**
		// Configure Spring
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("client-context.xml"));
		ContractManagementService port = (ContractManagementService) factory.getBean("clientkey");
		
		// Configure Interceptors outgoing properties
				
		org.apache.cxf.endpoint.Client clientEndpoint = ClientProxy.getClient(port);
		org.apache.cxf.endpoint.Endpoint cxfEndpoint = clientEndpoint.getEndpoint();
		
		Map<String,Object> inProps= new HashMap<String,Object>();
		// how to configure the properties is outlined below;

		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		cxfEndpoint.getInInterceptors().add(wssIn);

		Map<String,Object> outProps = new HashMap<String,Object>();
	    // how to configure the properties is outlined below;

		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		cxfEndpoint.getOutInterceptors().add(wssOut);
		
		outProps.put(WSHandlerConstants.ACTION, "Signature Encryption");
		outProps.put(WSHandlerConstants.USER, "clientkey");
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, 
		    ClientKeystorePasswordCallback.class.getName());
		outProps.put(WSHandlerConstants.SIG_PROP_FILE, "clientKeystore.properties");
		*/
		
//		TestService               testWS    = getWebService( TestService.class );
//		RatingService             ratings   = getRestService( RatingService.class );
//		IRegistryService          registry  = getWebService( IRegistryService.class, "http://vc.infosys.tuwien.ac.at:8092/registry" );
//		ContractManagementService contracts = getWebService( ContractManagementService.class );
		
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		
//		Client client = dcf.createClient( registry.query( new Cheque() ).getLocation() + "?wsdl" );
		Client client = dcf.createClient( new File( "../disbursement-service-cheque.wsdl" ).toURI().toURL() );
		
//		client.getRequestContext().put("schema-validation-enabled", "true"); 
				
		Object cheque   = ReflectionUtil.makeInstance( "at.ac.tuwien.infosys.aic11.services.Cheque" )
                                        .setProperty( "name", "Fader A. Vader" )
                                        .build();
		Object money    = ReflectionUtil.makeInstance( "at.ac.tuwien.infosys.aic11.services.Money" )
		                                .setProperty( "currencyCode", "EUR" )
		                                .setProperty( "amount", 5000 )
		                                .build();
		Object customer = ReflectionUtil.makeInstance( "at.ac.tuwien.infosys.aic11.services.Customer" )
		                                .setProperty( "address",
		                                	ReflectionUtil.makeInstance( "at.ac.tuwien.infosys.aic11.services.Address" )
		                                	              .build()
		                                )
		                                .build();
		
//		Object[] result = client.invoke(
//			"start_money_transfer_process",
//			cheque,
//			money,
//			customer
//		);
//		printlnArray( result );
		ClientCallback callback = new ClientCallback() {
			public void start( Message msg ) {
				println( msg );

				print( msg.getContent( InputStream.class ) );
				
				started = true;
			}
		};
		
		client.invoke(
			callback,
			"start_money_transfer_process",
			cheque,
			money,
			customer
		);
		
		println( callback.get() );
		
//		Object customerParam = Thread.currentThread().getContextClassLoader().loadClass("com.acme.invoicing.Customer").newInstance();

//		 Method setCustIdMethod = customerParam.getClass().getMethod("setCustomerId", String.class);
//		 setCustIdMethod.invoke(customerParam, "CUST-42");

//		 Object[] result = client.invoke("doInvoicingOnCustomer", customerParam);
		
//		println( contracts.testEncryption( "foo" ) );
//		println( ratings.getRatingForCustomerId( 0 ) );
//		println( testWS.bar("foo") );
//		println( registry.query( new Cheque() ).getLocation() );
	}
	
	public static <E> E getWebService( Class<E> serviceClass ) {
		Config cfg = new Config();
		
		return getWebService( 
			serviceClass, 
			String.format(
				"http://localhost:%d/%s",
				cfg.getInt("http.server.port.ws"),
				Services.getServiceName( serviceClass )
			)
		);
	}
	public static <E> E getWebService( Class<E> serviceClass, String address ) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		
		JAXBDataBinding jaxb = new JAXBDataBinding();
//		jaxb.setExtraClass( new Class[] {Addresses.class, BankTransfer.class, Cheque.class, CreditRequest.class,
//				Customer.class, CustomerRating.class, DisbursementPreference.class, Duration.class, InterestRate.class, Money.class, Offer.class, Query.class,
//				QueryResponse.class, Rating.class, Warrantor.class, WsdlEndpoint.class} );
		
		factory.setDataBinding( jaxb );
		
		factory.getInInterceptors().add( new LoggingInInterceptor() );
		factory.getOutInterceptors().add( new LoggingOutInterceptor() );

		factory.setAddress( address );

		return (E) factory.create( serviceClass );
	}
	public static <E> E getRestService( Class<E> serviceClass ) {
		Config cfg = new Config();
		
		JAXRSClientFactoryBean factory = new JAXRSClientFactoryBean();
		
		factory.setResourceClass( serviceClass );
		factory.setAddress( "http://localhost:" + cfg.getInt("http.server.port.rs") );
	
		return (E) factory.create( serviceClass );
	}
	
	public static void println( Object msg ) {
		System.out.println( msg );
	}
	public static void printlnArray( Object... msg ) {
		System.out.println( Util.join( ", ", msg ) );
	}
	public static void print( InputStream input ) {
		try {
			int in;
			while ( (in = input.read()) != -1 ) {
				System.out.print( (char) in );
			}
		} catch ( IOException e ) {
			Exceptions.rethrow( e );
		}
	}
}
