package at.ac.tuwien.infosys.aic11.wicket.model;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.FormComponentPanel;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;

public abstract class AICWizardStep extends FormComponentPanel<CreditRequest> {
	public AICWizardStep() {
		this( null );
	}
	public AICWizardStep( AICWizard wizard ) {
		super( AICWizard.STEP_ID );

		setWizard( wizard );
		
		setOutputMarkupId( true );
	}
	
	public final void setWizard( AICWizard w ) {
		wizard = w;
	}
	public final AICWizard getWizard() {
		return wizard;
	}
	
	public abstract String getTitle();
	public abstract String getSummary();
	
	public abstract AICWizardStep next();
	public abstract boolean       isLastStep();
	public abstract boolean       isComplete();
	
	public void applyState() {}
	
	protected void repaintWithNextAjaxRequest() {
		AjaxRequestTarget.get().add( this );
	}
	
	private AICWizard wizard;
}
