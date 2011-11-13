package at.ac.tuwien.infosys.aic11.services;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

@WebService( serviceName = "contractWS" )
public class ContractManagementServiceImpl extends AbstractService implements ContractManagementService, 
                                                                              AbstractWebService {
	
	
	@Override
	public String testEncryption(String s) {
		return "This is a test, if you can read this, this is bad, " + s + "!";
	}

	@Override
	public String testEncryption2() {
		return "This is a test, if you can read this, this is bad!";
	}
}
