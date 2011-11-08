package at.ac.tuwien.infosys.aic11.cfg;

import java.util.Arrays;
import java.util.List;

import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.ac.tuwien.infosys.aic11.services.AbstractRestService;
import at.ac.tuwien.infosys.aic11.services.AbstractWebService;
import at.ac.tuwien.infosys.aic11.services.ContractManagementServiceImpl;
import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl;
import at.ac.tuwien.infosys.aic11.services.RatingServiceImpl;
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
	Integer restServicePort( Integer httpPort ) {
		return httpPort + 1;
	}
	
	@Bean
	@Qualifier("CXF")
	List<AbstractWebService> webServices() {
		return Arrays.asList(
			new ContractManagementServiceImpl(),
			new CustomerRelationsManagementServiceImpl(),
			new ShippingServiceImpl(),
			new TestServiceImpl()
		);
	}
	
	@Bean
	@Qualifier("CXF")
	List<AbstractRestService> restServices() {
		return Arrays.<AbstractRestService>asList(
			new RatingServiceImpl()
		);
	}
}
