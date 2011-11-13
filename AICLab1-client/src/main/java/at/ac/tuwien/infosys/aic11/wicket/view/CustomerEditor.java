package at.ac.tuwien.infosys.aic11.wicket.view;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import at.ac.tuwien.infosys.aic11.dto.Address;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.DisbursementPreference;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;

public class CustomerEditor<C extends Customer> extends FormComponentPanel<C> {

	public static CustomerEditor<Customer> makeC( String id) {
		return new CustomerEditor<Customer>( id, new Customer() );
	}
	public static CustomerEditor<Warrantor> makeW( String id) {
		return new CustomerEditor<Warrantor>( id, new Warrantor() );
	}

	public CustomerEditor( String id, C c ) {
		super( id );

		this.data = c;
		
		CompoundPropertyModel<C> model = new CompoundPropertyModel<C>( data );
		setModel( model );
		
		// members
		add(
			customerId  = makeRequiredTextField( "customerId",  c.getCustomerId() ),
			firstName   = makeRequiredTextField( "firstName",   c.getFirstName() ),
			middleName  = makeTextField( "middleName",          c.getMiddleName() ),
			lastName    = makeRequiredTextField( "lastName",    c.getLastName() ),
			openBalance = makeRequiredTextField( "openBalance", c.getOpenBalance() )
		);
		
		Address a = c.getAddress();
		
		// relations
		add(
			street  = makeRequiredTextField( "street",  a.getStreet() ),
			city    = makeRequiredTextField( "city",    a.getCity() ),
			house   = makeRequiredTextField( "house",   a.getHouse() ),
			door    = makeRequiredTextField( "door",    a.getDoor() ),
			zipCode = makeRequiredTextField( "zipCode", a.getZipCode() )
		);
		
		DisbursementPreference pref = c.getDisbursementPreference();
		
		prefs = new DisbursementPreferenceViewer("pref", pref );
		
		if ( c.getClass() == Customer.class ) {
			add( prefs );
		} else {
			add( new Label("pref","") );
		}
		
		//		private Address                address;
//		private DisbursementPreference disbursementPreference;
//		private Rating                 rating;
//		private Set<CreditRequest>     creditRequests;
	}

	private static <T extends Serializable> RequiredTextField<T> makeRequiredTextField( String property, T t ) {
		return new RequiredTextField<T>( property, Model.of( t ) );
	}
	private static <T extends Serializable> TextField<T> makeTextField( String property, T t ) {
		return new TextField<T>( property, Model.of( t ) );
	}

	RequiredTextField<Long>       customerId;
	RequiredTextField<String>     firstName;
	TextField<String>             middleName;
	RequiredTextField<String>     lastName;
	RequiredTextField<BigDecimal> openBalance;

	RequiredTextField<String>     street;
	RequiredTextField<String>     city;
	RequiredTextField<String>     house;
	RequiredTextField<String>     door;
	RequiredTextField<String>     zipCode;
	
	DisbursementPreferenceViewer prefs;
	
	public C getData() {
		data.setCustomerId( customerId.getModelObject() );
		data.setFirstName( firstName.getModelObject() );
		data.setMiddleName( middleName.getModelObject() );
		data.setLastName( lastName.getModelObject() );
		data.setOpenBalance( openBalance.getModelObject() );

		data.setAddress(
			new Address(
				street.getModelObject(),
				city.getModelObject(),
				house.getModelObject(),
				door.getModelObject(),
				zipCode.getModelObject()
			)
		);
		data.setDisbursementPreference( prefs.getData() );
		
		return data;
	}

	private C data;
}
