package at.ac.tuwien.infosys.aic11.wicket;

import org.apache.wicket.model.IModel;

import at.ac.tuwien.infosys.aic11.util.Function;

public abstract class WicketUtils {
	public static <A,B> IModel<B> transformedModel( final IModel<A> model, 
	                                                final Function<B,A> getter, 
	                                                final Function<A,B> setter ) {
		return new IModel<B>() {
			@Override
			public B getObject() {
				return getter.apply( model.getObject() );
			}
			@Override
			public void setObject( B object ) {
				model.setObject( setter.apply( object ) );
			}
			@Override
			public void detach() {
			}
		};
	}
	
	private WicketUtils() {/**/}
}
