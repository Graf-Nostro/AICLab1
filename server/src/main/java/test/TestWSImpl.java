package test;

import javax.jws.WebService;

@WebService
public class TestWSImpl implements TestWS {
	@Override
	public String foo() {
		return "foo";
	}
}
