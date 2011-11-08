package at.ac.tuwien.infosys.aic11.cfg;

import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Qualifier;
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
		return cfg.getInt( "http.server.port" );
	}
	
	@Bean
	@Qualifier("Jetty")
	Handler requestHandler( ServletHolder servlet, String servletPath ) {
		// the main handler
		ContextHandlerCollection contexts = new ContextHandlerCollection();

		// create servlet context 
		ServletContextHandler servlets = new ServletContextHandler( contexts, "/" );		
		servlets.addServlet( servlet, "/" + servletPath + "/*");
		
		return contexts;
	}
	
	@Bean
	@Qualifier("Jetty")
	ServletHolder servlet( CXFNonSpringServlet cxf, String servletPath ) {
		ServletHolder servlet = new ServletHolder(cxf);
		servlet.setName( servletPath );
		servlet.setForcedPath( servletPath );
		
		return servlet;
	}
	
	@Bean
	@Qualifier("Jetty")
	String servletPath( Config cfg ) {
		return cfg.get("http.servlet.path");
	}
	
	// holds config common to all lab1 subprojects
	@Bean
	@Qualifier("Jetty")
	Config cfg() {
		return new Config();
	}
}
