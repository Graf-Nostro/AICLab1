package at.ac.tuwien.infosys.aic11.wicket.model;

import java.math.BigDecimal;

import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.springframework.beans.factory.annotation.Autowired;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.services.RatingService;

public class Step1_PlaceCreditRequest extends AICWizardStep<Customer> {
	public Step1_PlaceCreditRequest() {
		this( CompoundPropertyModel.of( Model.of( new Customer() ) ) );
	}
	
	public Step1_PlaceCreditRequest( CompoundPropertyModel<Customer> model ) {
		super(
			null, 
			"Place credit request", 
			"Insert the customers data, then press next to get an offer", 
			model
		);
		
		Customer c = model.getObject();
		if ( c == null ) {
			c = new Customer();
			model.setObject( c );
		}
		
		c.setCustomerId( 5 );
		c.setFirstName( "A" );
		c.setLastName( "A" );
		c.setOpenBalance( BigDecimal.valueOf( 5 ) );

		// members
		add(
			makeRequiredTextField( "customerId", c ),
			makeRequiredTextField( "firstName",  c ),
			makeTextField( "middleName", c ),
			makeRequiredTextField( "lastName", c ),
			makeRequiredTextField( "openBalance", c )
		);
		
		// relations
//		private Address                address;
//		private DisbursementPreference disbursementPreference;
//		private Rating                 rating;
//		private Set<CreditRequest>     creditRequests;
	}
	
	public AICWizardStep<Decision> next() {
		return new Step2_DecideOnOffer( this );
	}

	@Override
	public boolean isLastStep() {
		return false;
	}
	
	private static <T> RequiredTextField<T> makeRequiredTextField( String property, Customer c ) {
		return new RequiredTextField<T>( property, PropertyModel.<T>of( c, property ) );
	}
	private static <T> TextField<T> makeTextField( String property, Customer c ) {
		return new TextField<T>( property, PropertyModel.<T>of( c, property ) );
	}
	
	@Autowired
	private RatingService ratings;
}
