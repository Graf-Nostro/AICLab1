package at.ac.tuwien.infosys.aic11.wicket.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import at.ac.tuwien.infosys.aic11.dto.Address;
import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;
import at.ac.tuwien.infosys.aic11.wicket.AICSession;
import at.ac.tuwien.infosys.aic11.wicket.view.CustomerEditor;

public class Step1_PlaceCreditRequest extends AICWizardStep {
	public Step1_PlaceCreditRequest() {
		Customer c = new Customer();
		c.setAddress( new Address() );
		
		applyState( c, new ArrayList<Warrantor>() );
	}

	@Override
	public void applyState() {
		CreditRequest cr = getWizard().data;

		applyState( cr.getCustomer(), cr.getWarrantors() );
	}		
	private void applyState( Customer c, List<Warrantor> ws ) {		
		this.warrantors = new ArrayList<CustomerEditor<Warrantor>>( ws.size() );
		
		for ( Warrantor w : ws ) warrantors.add( new CustomerEditor<Warrantor>( "warrantor", w ) );
		
		addOrReplace( customer = new CustomerEditor<Customer>( "customer", c ) );
		
		addOrReplace( new ListView<CustomerEditor<Warrantor>>( "warrantors", warrantors ) {
			@Override
			protected void populateItem( final ListItem<CustomerEditor<Warrantor>> item ) {
				item.add( new Label( "warrantorNr", "Warrantor nr.: " + item.getIndex() ) );
				item.add( item.getModelObject() );
				
				item.add( new AjaxLink<Void>("removeWarrantor") {
					@Override
					public void onClick( AjaxRequestTarget target ) {
						warrantors.remove( item.getIndex() );
						target.add( Step1_PlaceCreditRequest.this );
					}					
				});
			}
		});
		
		addOrReplace( new AjaxLink<Void>("addWarrantor") {
			@Override
			public void onClick( AjaxRequestTarget target ) {
				warrantors.add( CustomerEditor.makeW( "warrantor" ) );				
				target.add( Step1_PlaceCreditRequest.this );
			}
		} );
	}
	
	@Override
	public AICWizardStep next() {
		CreditRequest cr = getWizard().data;
		
		cr.setCustomer( customer.getData() );
		
		List<Warrantor> ws = new ArrayList<Warrantor>( warrantors.size() );
		
		for ( CustomerEditor<Warrantor> w : warrantors ) ws.add( w.getData() );
		
		cr.setWarrantors( ws );
		
		return new Step2_DecideOnOffer( getWizard() );
	}

	@Override
	public boolean isLastStep() {
		return false;
	}
	@Override
	public boolean isComplete() {
		return true;
	}
	
	@Override
	public String getTitle() {
		return "Place credit request";
	}
	@Override
	public String getSummary() {
		return "Insert the customers data, then press next to get an offer";
	}
	
	private CustomerEditor<Customer>        customer;
	private List<CustomerEditor<Warrantor>> warrantors;
	
}
