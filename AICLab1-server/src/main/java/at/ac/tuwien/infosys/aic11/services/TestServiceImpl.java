package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.dto.Address;
import at.ac.tuwien.infosys.aic11.dto.BankTransfer;
import at.ac.tuwien.infosys.aic11.dto.Cheque;
import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.DisbursementPreference;
import at.ac.tuwien.infosys.aic11.dto.Money;
import at.ac.tuwien.infosys.aic11.dto.Duration;
import at.ac.tuwien.infosys.aic11.dto.InterestRate;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;

@WebService
public class TestServiceImpl extends AbstractService implements AbstractWebService, TestService {
	@Override
	public String foo() {
		return "foo";
	}

	@Override
	public String bar(String foo) {
		return "Hello, " + foo + "!";
	}

	@Override
	public Address getAddresses() {
		return new Address();
	}

	@Override
	public BankTransfer getBankTransfer() {
		return new BankTransfer();
	}

	@Override
	public Cheque getCheque() {
		Cheque c = new Cheque();
		c.setName( "foo" );
		
		return c;
	}

	@Override
	public CreditRequest getCreditRequest() {
		return new CreditRequest();
	}

	@Override
	public Customer getCustomer() {
		Customer c = new Customer();
		c.setAddress( getAddresses() );
		c.setDisbursementPreference( new Cheque() );
		return c;
	}

	@Override
	public CustomerRating getCustomerRating() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementPreference getDisbursementPreference() {
		return getCheque();
	}

	@Override
	public Duration getDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterestRate getInterestRate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Money getMoney() {
		return new Money( "EUR", 5000 );
	}

	@Override
	public Offer getOffer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating getRating() {
		return new Rating( getCustomer(), getCustomerRating() );
	}
	@Override
	public Warrantor getWarrantor() {
		return new Warrantor( new CreditRequest() );
	}
}
