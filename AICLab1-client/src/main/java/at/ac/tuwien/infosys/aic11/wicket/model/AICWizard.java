package at.ac.tuwien.infosys.aic11.wicket.model;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.wizard.Wizard;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponentPanel;

import at.ac.tuwien.infosys.aic11.dto.Address;
import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Offer;

public class AICWizard extends FormComponentPanel<CreditRequest> {

	public static final String STEP_ID = "step";
	
	public AICWizard( String id ) {
		this( id, new Step1_PlaceCreditRequest() );
	}
	public AICWizard( String id, final AICWizardStep firstStep ) {
		super( id );
		setOutputMarkupId( true );
		
		this.firstStep = firstStep;
		
		data = new CreditRequest( new Customer() );
		data.getCustomer().setAddress( new Address() );
		data.getCustomer().setFirstName( "fav" );
						
		add( new NextLink() );
		
		updateStep( firstStep );
	}
	
	public void reset() {
		updateStep( firstStep );
	}
	
	private String getButtonLabel() {
		return currentStep.isLastStep() ? "Finish" : "Next";
	}
	
	private void updateStep( AICWizardStep newStep ) {
		System.out.println( data );
		
		if ( newStep == null ) return;
		
		currentStep = newStep;
		
		currentStep.setWizard( this );
		currentStep.applyState();
		
		addOrReplace( currentStep );
		
		addOrReplace( new Label("title",   currentStep.getTitle()) );
		addOrReplace( new Label("summary", currentStep.getSummary()) );
	}

	private final AICWizardStep firstStep;
	private AICWizardStep currentStep;

	public CreditRequest data;
	public Offer         offer;
	
	private class NextLink extends AjaxLink<Void> {
		public NextLink() {
			super( "next" );
			
			label = new Label( "nextLabel", "Next" );
			label.setOutputMarkupId( true );
			
			add( label );
		}

		@Override
		public void onClick( AjaxRequestTarget target ) {
			if ( !currentStep.isComplete() ) return;
			
			if ( currentStep.isLastStep() ) {
				updateStep( firstStep );
			} else {
				updateStep( currentStep.next() );					
			}
				
			label = new Label( "nextLabel", getButtonLabel() );
			label.setOutputMarkupId( true );
			
			addOrReplace( label );
			
			target.add( AICWizard.this );
			target.add( label );
		}
		
		private Label label;
	}
}
