package at.ac.tuwien.infosys.aic11.cfg;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import at.ac.tuwien.infosys.aic11.util.Util;

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
		Signature sig = joinPoint.getSignature();
		logger.info(
			"Web service was called: " +
				sig.getDeclaringTypeName() + "." + sig.getName() + "(" +
					Util.join( ", ", joinPoint.getArgs() ) +
				")"
		);
		
		// call method
		Object retVal = joinPoint.proceed();
		
		// log return value
		logger.info( "Web service call returned: " + retVal.toString() );

		// return return value
		return retVal;
	}
}
