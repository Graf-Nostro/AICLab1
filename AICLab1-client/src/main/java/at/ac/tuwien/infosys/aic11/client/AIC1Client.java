package at.ac.tuwien.infosys.aic11.client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.cfg.Config;
import at.ac.tuwien.infosys.aic11.services.TestService;

public class AIC1Client {
	public static void main(String[] args) throws Exception {
		Config cfg = new Config();
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.getInInterceptors().add( new LoggingInInterceptor() );
		factory.getOutInterceptors().add( new LoggingOutInterceptor() );
		factory.setServiceClass( TestService.class );
		factory.setAddress(
			String.format(
				"http://localhost:%d/%s/testWS", 
				cfg.getInt("http.server.port"),
				cfg.get("http.servlet.path")
			)
		);

		TestService testWS = (TestService) factory.create();
		
		System.out.print( testWS.getWarrantor() );
		
	}
}
