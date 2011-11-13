package at.ac.tuwien.infosys.aic11.cfg;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyConfig {
	@Bean
	@Qualifier("Jetty")
	Server httpServer( Integer httpPort, Handler requestHandler ) {
		Server server = new Server( httpPort );
		
		server.setHandler( requestHandler );
		
		return server;
	}
	
	@Bean
	@Qualifier("Jetty")
	Integer httpPort( Config cfg ) {
		return cfg.getInt( "http.server.port.client" );
	}
	
	@Bean
	@Qualifier("Jetty")
	Handler requestHandler( ApplicationContext springCtx ) {
		WebAppContext ctx = new WebAppContext();
		
		ctx.setDescriptor( "target/classes/WEB-INF/web.xml" );
	    ctx.setResourceBase( "target/classes" );
		
		return ctx;
	}
	
	// holds config common to all lab1 subprojects
	@Bean
	@Qualifier("Jetty")
	Config cfg() {
		return new Config();
	}
}
