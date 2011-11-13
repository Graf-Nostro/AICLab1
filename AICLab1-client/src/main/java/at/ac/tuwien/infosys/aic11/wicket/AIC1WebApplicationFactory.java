package at.ac.tuwien.infosys.aic11.wicket;

import org.apache.wicket.protocol.http.IWebApplicationFactory;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;

public class AIC1WebApplicationFactory implements IWebApplicationFactory {
	@Override
	public WebApplication createApplication( WicketFilter filter ) {
		return new AIC1WebApplication();
	}

	@Override
	public void destroy( WicketFilter filter ) {
	}
}
