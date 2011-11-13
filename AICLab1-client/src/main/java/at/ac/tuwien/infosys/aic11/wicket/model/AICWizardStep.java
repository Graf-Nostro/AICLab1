package at.ac.tuwien.infosys.aic11.wicket.model;

import org.apache.wicket.extensions.wizard.dynamic.DynamicWizardStep;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public abstract class AICWizardStep<T> extends DynamicWizardStep {
	public AICWizardStep( AICWizardStep<?> previous, String title ) {
		this( previous, Model.of( title ) );
	}
	public AICWizardStep( AICWizardStep<?> previous, IModel<String> title ) {
		this( previous, title, (IModel<T>) null );
	}
	public AICWizardStep( AICWizardStep<?> previous, String title, IModel<T> model ) {
		this( previous, Model.of( title ), null, model );
	}
	public AICWizardStep( AICWizardStep<?> previous, IModel<String> title, IModel<T> model ) {
		this( previous, title, null, model );
	}
	public AICWizardStep( AICWizardStep<?> previous, String title, String summary ) {
		this( previous, Model.of( title ), Model.of( summary ), null );
	}
	public AICWizardStep( AICWizardStep<?> previous, String title, String summary, IModel<T> model ) {
		this( previous, Model.of( title ), Model.of( summary ), model );
	}
	public AICWizardStep( AICWizardStep<?> previous, IModel<String> title, IModel<String> summary, IModel<T> model ) {
		super( previous, title, summary, makeModelIfNull( model ) );
		
		setOutputMarkupId( true );
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> IModel<T> makeModelIfNull( IModel<T> m ) {
		if ( m == null )
			return m;
		else
			return (IModel<T>) new Model();
	}
}
