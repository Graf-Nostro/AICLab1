package at.ac.tuwien.infosys.aic11.cfg;

import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.ac.tuwien.infosys.aic11.services.AbstractWebService;
import at.ac.tuwien.infosys.aic11.services.ContractManagementServiceImpl;
import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl;
import at.ac.tuwien.infosys.aic11.services.RatingServiceImpl;
import at.ac.tuwien.infosys.aic11.services.RestService;
import at.ac.tuwien.infosys.aic11.services.ShippingServiceImpl;
import at.ac.tuwien.infosys.aic11.services.TestServiceImpl;

@Configuration
public class CXFConfig {
	@Bean
	@Qualifier("CXF")
	CXFNonSpringServlet cxfServlet() {
		return new CXFNonSpringServlet();
	}
	
	@Bean
	@Qualifier("CXF")
	Integer restServicePort( Config cfg ) {
		return cfg.getInt( "http.server.port.rs" );
	}
	
	@Bean
	@Qualifier("CXF")
	AbstractWebService contractWS() {
		return new ContractManagementServiceImpl();		
	}
	@Bean
	@Qualifier("CXF")
	AbstractWebService customerWS() {
		return new CustomerRelationsManagementServiceImpl();
	}
	@Bean
	@Qualifier("CXF")
	AbstractWebService shippingWS() {
		return new ShippingServiceImpl();
	}
	@Bean
	@Qualifier("CXF")
	AbstractWebService testWS() {
		return new TestServiceImpl();
	}
	
	@Bean
	@Qualifier("CXF")
	RestService ratingWS() {
		return new RatingServiceImpl();
	}
	
}
