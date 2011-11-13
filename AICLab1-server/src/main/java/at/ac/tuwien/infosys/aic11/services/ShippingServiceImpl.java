package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

@WebService
public class ShippingServiceImpl extends AbstractService implements AbstractWebService, ShippingService {

	@Override
	public String shipContract() {
		String msg = "Contract to contractor shipped waiting for signature.";
		return msg;
	}

	@Override
	public String callbackReceiveContract(String contract) {
		return contract;
	}

}
