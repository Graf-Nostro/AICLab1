package at.ac.tuwien.infosys.aic11.wicket.view;

import org.apache.wicket.extensions.wizard.Wizard;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.protocol.http.request.WebClientInfo;

import at.ac.tuwien.infosys.aic11.wicket.model.AICWizardModel;

public class AIC1HomePage extends WebPage {
	public AIC1HomePage() {
		WebClientInfo clientInfo = WebSession.get().getClientInfo();

		if ( clientInfo.getProperties().isJavaEnabled() ) {
			AICWizardModel model = new AICWizardModel();
			
			Wizard w = new Wizard("wizard", model );
			w.setOutputMarkupId( true );
			
			this.add( w );			
		} else {
			add(new Label("wizard","You must enable JavaScript to use this client"));
		}
	}
}
