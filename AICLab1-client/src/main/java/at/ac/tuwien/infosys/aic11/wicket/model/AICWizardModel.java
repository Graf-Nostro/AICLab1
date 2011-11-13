package at.ac.tuwien.infosys.aic11.wicket.model;

import org.apache.wicket.extensions.wizard.IWizardModelListener;
import org.apache.wicket.extensions.wizard.IWizardStep;
import org.apache.wicket.extensions.wizard.dynamic.DynamicWizardModel;
import org.apache.wicket.extensions.wizard.dynamic.IDynamicWizardStep;

public class AICWizardModel extends DynamicWizardModel {

	public AICWizardModel() {
		super( (IDynamicWizardStep) makeFirstStep() );
		
		addListener( new IWizardModelListener() {			
			@Override
			public void onFinish() {
				AICWizardModel.this.setActiveStep( (IDynamicWizardStep) makeFirstStep() );
			}
			
			@Override
			public void onCancel() {
				AICWizardModel.this.setActiveStep( (IDynamicWizardStep) makeFirstStep() );
			}
			
			@Override
			public void onActiveStepChanged( IWizardStep newStep ) {
			}
		});
	}

	private static Step1_PlaceCreditRequest makeFirstStep() {
		return new Step1_PlaceCreditRequest();
	}
	
}
