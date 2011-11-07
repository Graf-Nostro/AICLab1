package test.server;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import test.TestWSImpl;

public class MyServer {
	public static void main( String[] args ) throws Exception {
		// create embedded jetty server
		Server httpServer = new Server( 8080 );
		
		// create HTTP request handler	
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		httpServer.setHandler(contexts);

		// create servlet context
		ServletContextHandler root = new ServletContextHandler( contexts, "/" );

		// create CXF servlet
		CXFNonSpringServlet cxf = new CXFNonSpringServlet();
		ServletHolder servlet = new ServletHolder(cxf);
		servlet.setName("cxf");
		servlet.setForcedPath("cxf");
		root.addServlet(servlet, "/cxf/*");
		
		// start jetty server
		httpServer.start();
		
		Bus bus = cxf.getBus();
		BusFactory.setDefaultBus(bus);
	
		Endpoint.publish( "/test", new TestWSImpl() );

//		Server server = new Server( 6666 );
//
//		ServletContextHandler handler = new ServletContextHandler();
//		handler.addServlet( CXFServlet.class, "/cxf" );
//		
//		server.setHandler( handler );
//		
//		server.start();
//		server.join();
	}
}
