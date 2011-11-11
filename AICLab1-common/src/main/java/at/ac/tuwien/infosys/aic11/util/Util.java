package at.ac.tuwien.infosys.aic11.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Util {
	public static <E> Iterable<E> concat( final Iterable<E>... its ) {
		class Concat implements Iterable<E> {
			@Override
			public Iterator<E> iterator() {
				return new Iterator<E>() {
					Iterator<Iterable<E>> it = Arrays.asList( its ).iterator();
					Iterator<E> current;
					
					@Override
					public boolean hasNext() {
						if ( current == null ) 
							if ( it.hasNext() ) 
								current = it.next().iterator();
							else
								return false;
						if ( current.hasNext() ) 
							return true;
						else {
							current = null;
							return hasNext();
						}
					}

					@Override
					public E next() {
						if ( current.hasNext() )
							return current.next();
						else
							throw new NoSuchElementException();
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
		
		return new Concat();
	}
	
	public static <A,B> Iterable<B> map( final Function<B, A> f, final Iterable<A> in ) {
		class Mapping implements Iterable<B> {
			@Override
			public Iterator<B> iterator() {				
				return new Iterator<B>() {
					@Override
					public boolean hasNext() {
						return it.hasNext();
					}

					@Override
					public B next() {
						return f.apply( it.next() );
					}

					@Override
					public void remove() {
						it.remove();
					}

					final Iterator<A> it = in.iterator();		
				};
			}
			
			@Override 
			public String toString() {
				return "{" + join( ", ", this ) + "}";
			}
		}
		
		return new Mapping();
	}
	
	public static <A> Iterable<A> filter( final Function<Boolean,A> f, final Iterable<A> in ) {
		class Filter implements Iterable<A> {
			@Override
			public Iterator<A> iterator() {		
				return new Iterator<A>() {
					@Override
					public boolean hasNext() {
						fetch();
						
						return next != null;
					}

					@Override
					public A next() {
						fetch();
						
						if ( next == null ) 
							throw new NoSuchElementException();
						
						A out = next;
						next = null;
						return out;
					}

					@Override
					public void remove() {
						it.remove();
					}
					
					private void fetch() {
						if ( next != null ) return;
						
						while ( it.hasNext() ) {
							A a = it.next();
							if ( f.apply( a ) ) {
								next = a;
								break;								
							}
						}						
					}

					A next;
					final Iterator<A> it = in.iterator();		
				};
			}
			
			@Override 
			public String toString() {
				return "{" + join( ", ", this ) + "}";
			}
		};
		
		return new Filter();
	}
	
	public static <E> String join( String separator, E... src ) {
		return join( separator, asIterable( src ) );
	}
	public static <E> String join( String separator, Iterable<E> src ) {
		Iterator<E> it = src.iterator();
		
		StringBuilder dst = new StringBuilder();
		
		if ( it.hasNext() ) {
			dst.append( it.next() );
		}
		
		while ( it.hasNext() ) {
			dst.append( separator );
			dst.append( it.next() );
		}
		
		return dst.toString();
	}
	
	public static <E> Iterable<E> asIterable( final E... es ) {
		return new Iterable<E>() {
			@Override
			public Iterator<E> iterator() {
				return asIterator( es );
			}
		};
	}
	public static <E> Iterator<E> asIterator( final E... es ) {
		return new Iterator<E>() {
			int pos = 0;
			
			@Override
			public boolean hasNext() {
				return pos < es.length;
			}

			@Override
			public E next() {
				try {
					return es[pos++];
				} catch ( ArrayIndexOutOfBoundsException e ) {
					throw new NoSuchElementException( e.getLocalizedMessage() );
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	private Util() {}
}
