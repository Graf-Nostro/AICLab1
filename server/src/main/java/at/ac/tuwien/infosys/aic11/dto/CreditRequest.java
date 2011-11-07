package at.ac.tuwien.infosys.aic11.dto;

import java.util.Set;

public class CreditRequest {
	Money          money;
	Duration       duration;
	Offer          offer;
	Set<Warrantor> warrantors;
	
	long   requestId;
	String reason;
}
