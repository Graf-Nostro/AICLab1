package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

@WebService( serviceName = "contractWS" )
public interface ContractManagementService {

	String testEncryption(String s);

	String testEncryption2();

}
