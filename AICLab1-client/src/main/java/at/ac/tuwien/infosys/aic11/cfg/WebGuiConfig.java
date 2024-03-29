package at.ac.tuwien.infosys.aic11.cfg;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.ac.tuwien.infosys.aic11.client.OfferService;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.services.ContractManagementService;
import at.ac.tuwien.infosys.aic11.services.RatingService;

@Configuration
public class WebGuiConfig {
	@Bean
	RatingService ratings() {
		return new RatingService() {
			
			@Override
			public Rating getRatingForCustomerId( long id ) {
				return new Rating( null, CustomerRating.AAA );
			}
			@Override
			public List<at.ac.tuwien.infosys.aic11.dto.Rating> getWarrontorRatingForCustomerId( long id ) {
				return null;
			}
		};
	}
	@Bean
	ContractManagementService contracts() {
		return new ContractManagementService() {
			
			@Override
			public String testEncryption2() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String testEncryption( String s ) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
	@Bean
	OfferService offers( RatingService ratings, ContractManagementService contracts ) {
		return new OfferService( ratings, contracts );
	}
}
