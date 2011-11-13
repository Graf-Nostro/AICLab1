package at.ac.tuwien.infosys.aic11.wicket.view;

import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.Model;

import at.ac.tuwien.infosys.aic11.dto.BankTransfer;
import at.ac.tuwien.infosys.aic11.dto.Cheque;
import at.ac.tuwien.infosys.aic11.dto.DisbursementPreference;

public class DisbursementPreferenceViewer extends FormComponentPanel<DisbursementPreference> {

	public DisbursementPreferenceViewer( String id, DisbursementPreference pref ) {
		super( id );
		
		type = new RadioGroup<String>( "type" );
			
		Radio<String> cheque       = new Radio<String>( "cheque",       Model.of( "CHEQUE" ),       type );
		Radio<String> bankTransfer = new Radio<String>( "bankTransfer", Model.of( "BANKTRANSFER" ), type );

		if ( pref instanceof Cheque ) {
			type.setDefaultModel( Model.of( "CHEQUE" ) );
		} else {
			type.setDefaultModel( Model.of( "BANKTRANSFER") );
		}
		
		type.add( cheque, bankTransfer );
		this.addOrReplace( type );
	}
	
	private RadioGroup<String> type;

	public DisbursementPreference getData() {
		if ( "CHEQUE".equals( type.getModelObject() ) )
			return new Cheque();
		else if ( "BANKTRANSFER".equals( type.getModelObject() ) )
			return new BankTransfer();
		else
			return null;
	}
	
}
