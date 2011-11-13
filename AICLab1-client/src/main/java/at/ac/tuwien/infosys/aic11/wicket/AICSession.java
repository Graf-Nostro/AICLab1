package at.ac.tuwien.infosys.aic11.wicket;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;

public class AICSession extends WebSession {

	public AICSession( Request request ) {
		super( request );
	}

	public static AICSession get() {
		return (AICSession) Session.get();
	}
	
	public void storeData( CreditRequest c ) {
		data = c;
	}
	public CreditRequest getData() {
		return data;
	}
	
	public CreditRequest data;
	public CreditRequest offer;
	
}
