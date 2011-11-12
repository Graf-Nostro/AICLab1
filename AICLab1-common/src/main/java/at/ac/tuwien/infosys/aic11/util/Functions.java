package at.ac.tuwien.infosys.aic11.util;

import java.util.Map;

public abstract class Functions {
	public static <A,B> Function<A,B> asFunction( final Map<B,A> m ) {
		return new Function<A, B>() {
			@Override
			public A apply( B p ) {
				return m.get( p );
			}
		};
	}
	
	public Functions() {/**/}
}
