package at.ac.tuwien.infosys.aic11.cfg;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
		Logger logger = Logger.getLogger( joinPoint.getTarget().getClass().getName() );

		// log method invocation
		String invocation = "Web service was called: " + joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		if ( args.length != 0 ) {
			invocation += "\n  Parameters:\n";
			for ( int i = 0; i < args.length; i++ ) 
				invocation += "    1: " + args[i] + "\n";
		}
		
		logger.info( invocation );
		
		// call method
		Object retVal = joinPoint.proceed();
		
		// log return value
		logger.info( "Web service call returned: " + retVal.toString() );

		// return return value
		return retVal;
		
//		return joinPoint.proceed();
	}
}
