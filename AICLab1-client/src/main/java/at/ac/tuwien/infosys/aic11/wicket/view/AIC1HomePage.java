package at.ac.tuwien.infosys.aic11.wicket.view;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.protocol.http.request.WebClientInfo;

import at.ac.tuwien.infosys.aic11.wicket.model.AICWizard;

public class AIC1HomePage extends WebPage {
	public AIC1HomePage() {
		WebClientInfo clientInfo = WebSession.get().getClientInfo();

		if ( clientInfo.getProperties().isJavaEnabled() ) {
//			AICWizardModel model = new AICWizardModel();
			
			AICWizard w = new AICWizard( "wizard" );
			
			this.add( w );			
		} else {
			add(new Label("wizard","You must enable JavaScript to use this client"));
		}
	}
}
