package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

@WebService( serviceName = "contractWS" )

public class ContractManagementServiceImpl extends AbstractService implements ContractManagementService, AbstractWebService {
	
	
	@Override
	public String testEncryption(String s) {
		return "This is a test, if you can read this, this is bad, " + s + "!";
	}

}
