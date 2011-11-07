package at.ac.tuwien.infosys.aic11.server;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import at.ac.tuwien.infosys.aic11.cfg.Config;
import at.ac.tuwien.infosys.aic11.services.ShippingServiceImpl;
import at.ac.tuwien.infosys.aic11.services.TestServiceImpl;


public class AIC1Server {
	public static void main( String[] args ) throws Exception {
		Config cfg = new Config();
		
		// create embedded jetty server
		Server httpServer = new Server( cfg.getInt("http.server.port") );
		
		// create HTTP request handler	
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		httpServer.setHandler(contexts);

		// create servlet context 
		ServletContextHandler root = new ServletContextHandler( contexts, "/" );

		// create CXF servlet
		CXFNonSpringServlet cxf = new CXFNonSpringServlet();
		ServletHolder servlet = new ServletHolder(cxf);
		String cxfPath = cfg.get("http.servlet.path");
		servlet.setName(cxfPath);
		servlet.setForcedPath(cxfPath);
		root.addServlet( servlet, "/" + cxfPath + "/*" );
		
		// start jetty server
		httpServer.start();
		
		Bus bus = cxf.getBus();
		BusFactory.setDefaultBus(bus);
	
		Endpoint.publish( "/test", new TestServiceImpl() );
		Endpoint.publish( "/shipping", new ShippingServiceImpl() );
	}
}
