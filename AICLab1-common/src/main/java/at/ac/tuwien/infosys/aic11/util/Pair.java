package at.ac.tuwien.infosys.aic11.util;

public class Pair<A,B> {
	public static <A,B> Pair<A,B> make( A a, B b ) {
		return new Pair<A, B>( a, b );
	}
	
	public Pair() {
		this( null, null );
	}
	public Pair( A a, B b ) {
		this._1 = a;
		this._2 = b;
	}
	
	public final A _1;
	public final B _2;
	
	@Override
	public String toString() {
		return "(" + _1 + ", " + _2 + ")";
	}
}
