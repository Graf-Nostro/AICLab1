package at.ac.tuwien.infosys.aic11.services;

import java.util.List;

import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.mock.RatingServiceMock;

public class RatingServiceImpl extends AbstractService implements AbstractRestService, RatingService {
	private RatingServiceMock mock = new RatingServiceMock();
	
	@Override
	public Rating getRatingForCustomerId(long id) {
		//invoke legacy mock
		return mock.getCustomerRating(id);
	}
	
	@Override
	public List<Rating> getWarrontorRatingForCustomerId(long id) {
		//invoke legacy mock
		return mock.getWarrontorRatingForCustomerId(id);
	}
}
