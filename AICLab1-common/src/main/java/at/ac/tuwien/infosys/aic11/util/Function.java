package at.ac.tuwien.infosys.aic11.util;


public interface Function<Return,Param> {
	Return apply( Param p );
}
