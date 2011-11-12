package at.ac.tuwien.infosys.aic11.util;

public class Exceptions {
	/**
	 * Retrow an exception as {@link RuntimeException}
	 * @return never returns
	 */
	public static <E> E rethrow( Exception e ) throws RuntimeException {
		throw new RuntimeException( e );
	}
	
	public static <E> E unsupportedOperation()             throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	public static <E> E unsupportedOperation( String msg ) throws UnsupportedOperationException {
		throw new UnsupportedOperationException( msg );		
	}
}
