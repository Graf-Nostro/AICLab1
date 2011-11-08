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
public interface TestService {
	String foo();
	String bar( String str );
	
	Addresses              getAddresses();
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
