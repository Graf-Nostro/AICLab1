package at.ac.tuwien.infosys.aic11.util;

import java.util.HashMap;
import java.util.Map;

public class Maps {
	public static <A,B> Map<A,B> make( Pair<A,B>... entries ) {
		Map<A,B> m = new HashMap<A, B>( entries.length );
		
		for ( Pair<A,B> p : entries ) m.put( p._1, p._2 );
		
		return m;
	}
	
	public static <A,B> Pair<A,B> pair( A a, B b ) {
		return Pair.make( a, b );
	}
}
