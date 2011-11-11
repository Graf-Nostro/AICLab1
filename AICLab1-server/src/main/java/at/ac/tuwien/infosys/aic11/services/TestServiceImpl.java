package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.dto.Addresses;
import at.ac.tuwien.infosys.aic11.dto.BankTransfer;
import at.ac.tuwien.infosys.aic11.dto.Cheque;
import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.DisbursementPreference;
import at.ac.tuwien.infosys.aic11.dto.Duration;
import at.ac.tuwien.infosys.aic11.dto.InterestRate;
import at.ac.tuwien.infosys.aic11.dto.Money;
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
	public Addresses getAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankTransfer getBankTransfer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cheque getCheque() {
		return new Cheque("test");
	}

	@Override
	public CreditRequest getCreditRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerRating getCustomerRating() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementPreference getDisbursementPreference() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offer getOffer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating getRating() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Warrantor getWarrantor() {
		return new Warrantor( new CreditRequest() );
	}
}
