package at.ac.tuwien.infosys.aic11.cfg;

import java.util.logging.Level;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.istack.logging.Logger;

@Aspect
@Component
public class LoggingAopConfig {
	@Pointcut("execution(public * *(..))")
    void anyPublicOperation() {}
    
    @Pointcut("within(at.ac.tuwien.infosys.aic11.services..*)")
    void inServices() {}
    
    @Pointcut("anyPublicOperation() && inServices()")
    void serviceInvocation() {}
	
	@Around("execution(public * *(..)) && within(at.ac.tuwien.infosys.aic11.services..*)")
	public Object logServiceInvocation( ProceedingJoinPoint joinPoint ) throws Throwable {
		Logger logger = Logger.getLogger( joinPoint.getTarget().getClass() );
		
		// log method invocation
		String invocation = "Web service was called: " + joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		if ( args.length != 0 ) {
			invocation += "\n  Parameters:\n";
			for ( int i = 0; i < args.length; i++ ) 
				invocation += "    1: " + args[i] + "\n";
		}
		
		logger.log( Level.INFO, invocation );
		
		// call method
		Object retVal = joinPoint.proceed();
		
		// log return value
		logger.log( Level.INFO, "Web service call returned: " + retVal.toString() );

		// return return value
		return retVal;
		
//		return joinPoint.proceed();
	}
}
