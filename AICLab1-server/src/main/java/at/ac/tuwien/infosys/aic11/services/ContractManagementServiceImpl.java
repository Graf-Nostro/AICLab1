package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;
import org.apache.cxf.interceptor.InInterceptors;

@WebService( serviceName = "contractWS" )
public class ContractManagementServiceImpl implements ContractManagementService, AbstractWebService {
	
	
	@Override
	public String testEncryption(String s) {
		return "This is a test, if you can read this, this is bad, " + s + "!";
	}
}
