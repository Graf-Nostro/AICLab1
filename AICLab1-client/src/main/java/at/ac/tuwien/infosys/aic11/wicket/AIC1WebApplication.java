package at.ac.tuwien.infosys.aic11.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import at.ac.tuwien.infosys.aic11.wicket.view.AIC1HomePage;

public class AIC1WebApplication extends WebApplication {
	@Override
	protected void init() {
		getRequestCycleSettings().setGatherExtendedBrowserInfo( true );
//		getRequestCycleListeners().add( new AbstractRequestCycleListener() {
//			public IRequestHandler onException(RequestCycle cycle, Exception ex)
//			{
//				return new ErrorHandler( ex );
//			}
//		} );
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		return AIC1HomePage.class;
	}
	
//	private static class ErrorHandler implements IRequestHandler {
//		public static final String CONTENT_TYPE = "text/html";
//		public static final String ENCODING     = "UTF-8";
//		
//		public ErrorHandler( Exception ex ) {
//			this.ex = ex;
//		}
//
//		@Override
//		public void respond( IRequestCycle requestCycle ) {
//			WebResponse response = (WebResponse) requestCycle.getResponse();
//			
//			response.setContentType( CONTENT_TYPE + "; charset=" + ENCODING );
//
//			String str = "";
//			
//			str += "<html>"    + "\n";
//			str += "	<title>An error occured</title>" + "\n";
//			str += "	<body>" + "\n";
//			str += "	</body>" + "\n";
//			str += "		<table>" + "\n";
//
//			for ( Throwable e = ex; e != null && e != e.getCause(); e = e.getCause() ) {
//				str += "			<tr>" + "\n";
//				str += "				<td colspan='3'>" + "\n";
//				str += "					" + e + "\n";
//				str += "				</td>" + "\n";
//				str += "			</tr>" + "\n";
//				
//				for ( StackTraceElement ste : e.getStackTrace() ) {
//					str += "			<tr>" + "\n";
//					str += "				<td></td>" + "\n";
//					str += "				<td></td>" + "\n";
//					str += "				<td>" + "\n";
//					str += "					" + ste + "\n";
//					str += "				</td>" + "\n";
//					str += "			</tr>" + "\n";
//				}
//				str += "			<tr><td></td><td></td><td></td></tr>" + "\n";
//			}
//			
//			str += "		</table>" + "\n";
//			str += "	</body>" + "\n";
//			str += "</html>"    + "\n";
//			
//			// log stacktrace
//			ex.printStackTrace();
//			
//			// send string to client
//			try {
//				byte[] bytes = str.getBytes( ENCODING );
//				response.setContentLength(bytes.length);
//				response.write(bytes);
//			} catch ( IOException e ) {
//				throw new RuntimeException("Unable to render string: " + e.getMessage(), e);
//			}
//		}
//
//		@Override
//		public void detach( IRequestCycle requestCycle ) {}		
//		
//		private Exception ex;
//	}
}
