package at.ac.tuwien.infosys.aic11.services;

public interface Service {
	/**
	 * This is a DIRTY DIRTY hack!
	 *
	 * Since all our services are proxied by spring we can't get at their annotations
	 * This method should simply returns the real class of a service, not the class of it's proxy
	 */
	Class<? extends Service> getServiceClass();
}
