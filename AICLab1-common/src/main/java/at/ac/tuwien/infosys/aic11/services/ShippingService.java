package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService( serviceName="shippingWS" )
public interface ShippingService {
	
	public String shipContract();
	
	/**
	* callback after contract was signed by contractor 
	*/
	public String callbackReceiveContract(@WebParam(name="text") String contract);
	
}
