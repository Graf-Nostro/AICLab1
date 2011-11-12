package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.dto.Address;
import at.ac.tuwien.infosys.aic11.dto.BankTransfer;
import at.ac.tuwien.infosys.aic11.dto.Cheque;
import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.DisbursementPreference;
import at.ac.tuwien.infosys.aic11.dto.InterestRate;
import at.ac.tuwien.infosys.aic11.dto.Money;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;
import at.ac.tuwien.infosys.aic11.dto.Duration;

@WebService(serviceName="testWS")
public interface TestService {
	String foo();
	String bar( String str );
	
	Address              getAddresses();
	BankTransfer           getBankTransfer();
	Cheque                 getCheque();
	CreditRequest          getCreditRequest();
	Customer               getCustomer();
	CustomerRating         getCustomerRating();
	DisbursementPreference getDisbursementPreference();
	Duration               getDuration();
	InterestRate           getInterestRate();
	Money                  getMoney();
	Offer                  getOffer();
	Rating                 getRating();
	Warrantor              getWarrantor();
}
