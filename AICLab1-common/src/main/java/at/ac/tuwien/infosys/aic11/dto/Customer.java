package at.ac.tuwien.infosys.aic11.dto;

import java.math.BigDecimal;

public class Customer extends Warrantor {
	Addresses              address;
	DisbursementPreference disbursementPreference;

	long                   customerId;
	String                 firstName;
	String                 middleName;
	String                 lastName;
	BigDecimal             openBalance;
}
