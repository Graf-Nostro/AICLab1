package at.ac.tuwien.infosys.aic11.services;

import at.ac.tuwien.infosys.aic11.dto.Rating;

public interface RatingService {
	Rating ratings( long id );

	String sayHello();
}
