package at.ac.tuwien.infosys.aic11.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import at.ac.tuwien.infosys.aic11.cfg.WebGuiConfig;
import at.ac.tuwien.infosys.aic11.wicket.view.AIC1HomePage;

public class AIC1WebApplication extends WebApplication {
	@Override
	protected void init() {
		getComponentInstantiationListeners().add(
			new SpringComponentInjector(
				this,
				new GenericWebApplicationContext(
					new AnnotationConfigApplicationContext(
						WebGuiConfig.class
					).getDefaultListableBeanFactory()
				)
			)
		);
		
		getRequestCycleSettings().setGatherExtendedBrowserInfo( true );
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		return new AICSession(request);
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		return AIC1HomePage.class;
	}
}
