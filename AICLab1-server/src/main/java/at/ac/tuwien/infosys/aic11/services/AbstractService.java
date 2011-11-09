package at.ac.tuwien.infosys.aic11.services;

public abstract class AbstractService implements Service {
	@Override
	public final Class<? extends AbstractService> getServiceClass() {
		return getClass();
	}
}
