package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

@WebService( serviceName="testWS" )
public class TestServiceImpl implements TestService {
	@Override
	public String foo() {
		return "foo";
	}

	@Override
	public String bar(String foo) {
		return "Hello, " + foo + "!";
	}
}
