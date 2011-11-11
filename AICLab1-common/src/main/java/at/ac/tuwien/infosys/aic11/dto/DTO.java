package at.ac.tuwien.infosys.aic11.dto;

import static at.ac.tuwien.infosys.aic11.util.Util.concat;
import static at.ac.tuwien.infosys.aic11.util.Util.filter;
import static at.ac.tuwien.infosys.aic11.util.Util.join;
import static at.ac.tuwien.infosys.aic11.util.Util.map;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import at.ac.tuwien.infosys.aic11.util.Function;

// this class just helps with nice toString methods
abstract class DTO {
	@SuppressWarnings("unchecked")
	public final String toString() {
		return mkStr( concat( getMembers(), getRelations() ) );
	}
	
	/**
	 *  for avoiding cycles when calling toString on a DTO
	 */
	private final String shallowToString() {
		return mkStr( getMembers() );
	}
	
	private final String mkStr( Iterable<Field> members ) {
		return getClass().getSimpleName() + "{" + 
			join(
				", ", 
				membersToString( this, members ) 
			)
		+ "}" ;
	}
	
	private final Iterable<String> membersToString( final Object owner, Iterable<Field> members ) {
		return map(
			new Function<String, Field>() {
				@Override
				public String apply( Field f ) {
					String name = f.getName();
						
					// construct getter name
					char firstLetter = Character.toUpperCase( name.charAt( 0 ) );
					String getterName = "get" + firstLetter + name.substring( 1 );
						
					return name + "=" + DTO.toString( invokeGetter( owner, getterName ) );
				}
			},
			members
		);
	}
	
	@SuppressWarnings("unchecked")
	private static final <E> String toString( Object obj ) {
		if ( obj == null )
			return null;
		if ( obj instanceof DTO ) 
			return ((DTO) obj).shallowToString();
		else if ( obj.getClass().isArray() ) 
			return DTO.toString( (Object[]) obj );
		else if ( obj instanceof Iterable )
			return DTO.toString( (Iterable<E>) obj );
		else 
			return obj.toString();
	}
	
	private static final <E> String toString( Object[] objs ) {
		return objs.getClass().getSimpleName() + "[] {" + 
			join(
				", ", 
				map( 
					new Function<String,Object>() {
						@Override
						public String apply( Object p ) {
							return DTO.toString( p );
						}
					},
					list( objs ) 
				) 
			)
		+ "}" ;
	}
	
	private static final <E> String toString( Iterable<E> i ) {
		return i.getClass().getSimpleName() + "{" +
			join(
				", ", 
				map( 
					new Function<String,E>() {
						@Override
						public String apply( E p ) {
							return DTO.toString( p );
						}
					},
					i
				) 
			)
		+ "}";
	}
	
	private static Object invokeGetter( Object owner, String methodName ) {
		try {
			return owner.getClass().getMethod( methodName ).invoke( owner );
		} catch ( IllegalArgumentException e ) {
			throw new RuntimeException( e );
		} catch ( SecurityException e ) {
			throw new RuntimeException( e );
		} catch ( IllegalAccessException e ) {
			throw new RuntimeException( e );
		} catch ( InvocationTargetException e ) {
			throw new RuntimeException( e );
		} catch ( NoSuchMethodException e ) {
			throw new RuntimeException( e );
		}
	}
	
	// override these to include members in to string
	/**
	 *  members that will always be included in the result string
	 */
	private final Iterable<Field> getMembers() {
		return filter(
			new Function<Boolean,Field>() {
				@Override
				public Boolean apply( Field f ) {
					return !( DTO.class.isAssignableFrom( f.getType() ) );
				}
			},
			list( getClass().getDeclaredFields() )
		);
	}
	/***
	 *  members that will be omitted if necessary to avoid cycles
	 */
	private final Iterable<Field> getRelations() {
		return filter(
			new Function<Boolean,Field>() {
				@Override
				public Boolean apply( Field f ) {
					return ( DTO.class.isAssignableFrom( f.getType() ) );
				}
			},
			list( getClass().getDeclaredFields() )
		);
	}
	
	private static final <E> Iterable<E> list( E...objects ) {
		return Arrays.<E>asList( objects );
	}
}
