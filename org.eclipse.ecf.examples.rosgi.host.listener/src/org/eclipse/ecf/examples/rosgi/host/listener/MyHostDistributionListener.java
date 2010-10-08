package org.eclipse.ecf.examples.rosgi.host.listener;

import org.eclipse.ecf.osgi.services.distribution.IHostDistributionListener;
import org.eclipse.ecf.remoteservice.IRemoteServiceContainer;
import org.eclipse.ecf.remoteservice.IRemoteServiceRegistration;
import org.osgi.framework.ServiceReference;

public class MyHostDistributionListener implements IHostDistributionListener {

	@Override
	public void registered(ServiceReference serviceReference,
			IRemoteServiceContainer remoteServiceContainer,
			IRemoteServiceRegistration remoteRegistration) {

		System.out.println("hostRegistered\n\tserviceReference = " + serviceReference +
				"\n\tremoteServiceContainer = " + remoteServiceContainer +
				"\n\tremoteRegistration = " + remoteRegistration);
	}

	@Override
	public void unregistered(ServiceReference serviceReference,
			IRemoteServiceRegistration remoteRegistration) {

		System.out.println("hostUnregistered\n\tserviceReference = " + serviceReference +
				"\n\tremoteRegistration = " + remoteRegistration);
	}
}
