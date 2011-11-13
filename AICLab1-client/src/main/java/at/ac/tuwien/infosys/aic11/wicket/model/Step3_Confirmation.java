package at.ac.tuwien.infosys.aic11.wicket.model;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.extensions.wizard.dynamic.IDynamicWizardStep;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;

public class Step3_Confirmation extends AICWizardStep<String> {
	public Step3_Confirmation() {
		super(
			null,
			"Credit approved",
			"Thank you for taking a credit at the Goliath National Bank" 
		);

		AjaxLazyLoadPanel sentMail = new AjaxLazyLoadPanel("sentMail") {
			@Override
			public Component getLazyLoadComponent( String markupId ) {
				try {
					Thread.sleep( 1500 );
				} catch ( InterruptedException e ) {
				}

				sendFaxDone = true;
					
				AjaxRequestTarget target = AjaxRequestTarget.get();
				target.add( Step3_Confirmation.this.getParent() );

				return new MultiLineLabel( 
					markupId,
					getLocalizer().getString( "msg.sentMail", Step3_Confirmation.this )
				);
			}
		};
		AjaxLazyLoadPanel disburseMoney = new AjaxLazyLoadPanel("disbursed") {
			@Override
			public Component getLazyLoadComponent( String markupId ) {
				try {
					Thread.sleep( 1500 );
				} catch ( InterruptedException e ) {
				}
					
				disburseDone = true;

				AjaxRequestTarget target = AjaxRequestTarget.get();
				target.add( Step3_Confirmation.this.getParent() );
					
				return new MultiLineLabel( 
					markupId,
					getLocalizer().getString( "msg.disburse", Step3_Confirmation.this )
				 ).setOutputMarkupId( true );
			}
		};		
			
		this.add(
			new Label( "noJs" ).setOutputMarkupId( true ), 
			sentMail, 
			disburseMoney
		);
	}

	@Override
	public boolean isLastStep() {
		return sendFaxDone && disburseDone;
	}

	@Override
	public IDynamicWizardStep next() {
		return null;
	}
	
	private boolean sendFaxDone  = false;
	private boolean disburseDone = false;
}
