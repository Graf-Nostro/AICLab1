package at.ac.tuwien.infosys.aic11.wicket.model;

import org.apache.wicket.extensions.wizard.dynamic.IDynamicWizardStep;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.Model;

public class Step2_DecideOnOffer extends AICWizardStep<Decision> {	
	public Step2_DecideOnOffer( Step1_PlaceCreditRequest previous ) {
		super( 
			previous, 
			"Decide on offer", 
			"Let the customer decide wether he wants to accept or decline the offer"
		);

		RadioGroup<Decision> decision = new RadioGroup<Decision>( "decision" );
		
		Radio<Decision> accept  = new Radio<Decision>( "accept",  Model.of( Decision.ACCEPT ),  decision );
		Radio<Decision> decline = new Radio<Decision>( "decline", Model.of( Decision.DECLINE ), decision );
		Radio<Decision> update  = new Radio<Decision>( "update",  Model.of( Decision.UPDATE ),  decision );
		
		decision.setDefaultModel( Model.of( Decision.UPDATE ) );
		
		decision.add( accept, decline, update );

		this.add( decision );
	}

	@Override
	public IDynamicWizardStep next() {
		return new Step3_Confirmation();
	}
	
	@Override
	public boolean isLastStep() {
		return false;
	}
}
