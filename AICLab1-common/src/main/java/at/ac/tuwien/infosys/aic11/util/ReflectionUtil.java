package at.ac.tuwien.infosys.aic11.util;

import static at.ac.tuwien.infosys.aic11.util.Exceptions.rethrow;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {
	public static ReflectionUtil makeInstance( String className ) {
		return new ReflectionUtil( doMakeInstance( className ) );
	}
	
	/**
	 * @return this
	 */
	public ReflectionUtil setProperty( String propertyName, Object value ) {
		Class<?> c = instance.getClass();
		
		try {
			// try getter method
			Method m = c.getMethod( propertyNameToSetterName( propertyName ) );
			m.setAccessible( true );
			m.invoke( instance, value );
			return this;
		} catch ( NoSuchMethodException e ) {
		} catch ( SecurityException e ) {
		} catch ( IllegalArgumentException e ) {
		} catch ( IllegalAccessException e ) {
		} catch ( InvocationTargetException e ) {
		}
		
		try {
			// try setting a field
			Field f = c.getField( propertyName );
			f.setAccessible( true );
			f.set( instance, value );
			return this;
		} catch ( NoSuchFieldException e ) {
		} catch ( SecurityException e ) {
		} catch ( IllegalArgumentException e ) {
		} catch ( IllegalAccessException e ) {
		}
		
		try {
			// try setting a field
			Field f = c.getDeclaredField( propertyName );
			f.setAccessible( true );
			f.set( instance, value );
			return this;
		} catch ( NoSuchFieldException e ) {
		} catch ( SecurityException e ) {
		} catch ( IllegalArgumentException e ) {
		} catch ( IllegalAccessException e ) {
		}
		
		// no property of that name was found/accessible
		throw new RuntimeException("Property '" + propertyName + "' was not found/accessible");
	}
	
	public Object getProperty( String propertyName ) {
		Class<?> c = instance.getClass();
		
		try {
			// try getter method
			Method m = c.getMethod( propertyNameToGetterName( propertyName ) );
			m.setAccessible( true );
			return m.invoke( instance );
		} catch ( NoSuchMethodException e ) {
		} catch ( SecurityException e ) {
		} catch ( IllegalArgumentException e ) {
		} catch ( IllegalAccessException e ) {
		} catch ( InvocationTargetException e ) {
		}
		
		try {
			// try setting a field
			Field f = c.getField( propertyName );
			f.setAccessible( true );
			f.get( instance );
		} catch ( NoSuchFieldException e ) {
		} catch ( SecurityException e ) {
		} catch ( IllegalArgumentException e ) {
		} catch ( IllegalAccessException e ) {
		}
		
		try {
			// try setting a field
			Field f = c.getDeclaredField( propertyName );
			f.setAccessible( true );
			f.get( instance );
		} catch ( NoSuchFieldException e ) {
		} catch ( SecurityException e ) {
		} catch ( IllegalArgumentException e ) {
		} catch ( IllegalAccessException e ) {
		}
		
		// no property of that name was found/accessible
		throw new RuntimeException("Property '" + propertyName + "' was not found/accessible");
	}

	public Object build() {
		return instance;
	}
	
	//***** PRIVATE PARTS
	
	private static Object doMakeInstance( String className ) {
		try {
			return Thread.currentThread().getContextClassLoader().loadClass( className ).newInstance();
		} catch ( InstantiationException e ) {
			return rethrow( e );
		} catch ( IllegalAccessException e ) {
			return rethrow( e );
		} catch ( ClassNotFoundException e ) {
			return rethrow( e );
		}
	}
	
	private static String propertyNameToSetterName( String propertyName ) {
		return "set" + firstLetterToUpperCase( propertyName );
	}

	private static String propertyNameToGetterName( String propertyName ) {
		return "get" + firstLetterToUpperCase( propertyName );
	}
	
	private static String firstLetterToUpperCase( String str ) {
		return Character.toUpperCase( str.charAt( 0 ) ) + str.substring( 1 );
	}
	
	private ReflectionUtil( Object instance ) {
		this.instance = instance;
	}

	private Object instance;
}
