package at.ac.tuwien.infosys.aic11.wicket.model;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import at.ac.tuwien.infosys.aic11.client.OfferService;
import at.ac.tuwien.infosys.aic11.dto.Offer;

public class Step2_DecideOnOffer extends AICWizardStep {	
	public Step2_DecideOnOffer( AICWizard wizard ) {
		super( wizard );
		
		applyState();
	}

	@Override
	public void applyState() {
		Offer offer = offers.generateOffer( getWizard().data );
		
		getWizard().offer = offer;
		
		addOrReplace( new Label( "offer.interestRate", String.valueOf( offer.getInterestRate().getRate() ) ) );
		addOrReplace( new MultiLineLabel( "offer.comments", offer.getComments() ) );
		
		RadioGroup<Decision> decision = new RadioGroup<Decision>( "decision" );
		
		Radio<Decision> accept  = new Radio<Decision>( "accept",  Model.of( Decision.ACCEPT ),  decision );
		Radio<Decision> decline = new Radio<Decision>( "decline", Model.of( Decision.DECLINE ), decision );
		Radio<Decision> update  = new Radio<Decision>( "update",  Model.of( Decision.UPDATE ),  decision );
		
		decision.setDefaultModel( Model.of( Decision.UPDATE ) );
		
		decision.add( accept, decline, update );

		this.addOrReplace( decision );
	}

	@Override
	public AICWizardStep next() {
		
		return new Step3_Confirmation( getWizard() );
	}
	
	@Override
	public boolean isLastStep() {
		return false;
	}
	@Override
	public boolean isComplete() {
		return true;
	}

	@SpringBean
	private OfferService offers;

	@Override
	public String getTitle() {
		return "Decide on offer";
	}

	@Override
	public String getSummary() {
		return "Let the customer decide wether he wants to accept or decline the offer";
	}
}
