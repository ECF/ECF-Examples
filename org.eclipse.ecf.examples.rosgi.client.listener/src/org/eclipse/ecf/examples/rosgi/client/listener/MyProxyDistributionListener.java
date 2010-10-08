package org.eclipse.ecf.examples.rosgi.client.listener;

import org.eclipse.ecf.osgi.services.discovery.IRemoteServiceEndpointDescription;
import org.eclipse.ecf.osgi.services.distribution.IProxyDistributionListener;
import org.eclipse.ecf.remoteservice.IRemoteServiceContainer;
import org.eclipse.ecf.remoteservice.IRemoteServiceReference;
import org.osgi.framework.ServiceRegistration;

public class MyProxyDistributionListener implements IProxyDistributionListener {

	@Override
	public void registered(
			IRemoteServiceEndpointDescription endpointDescription,
			IRemoteServiceContainer remoteServiceContainer,
			IRemoteServiceReference remoteServiceReference,
			ServiceRegistration proxyServiceRegistration) {

		System.out.println("proxyRegistered\n\tendpointDesctription = " + endpointDescription  +
				"\n\tremoteServiceContainer = " + remoteServiceContainer +
				"\n\tremoteServiceReference = " + remoteServiceReference +
				"\n\tproxyServiceRegistration = " + proxyServiceRegistration);
	}

	@Override
	public void registering(
			IRemoteServiceEndpointDescription endpointDescription,
			IRemoteServiceContainer remoteServiceContainer,
			IRemoteServiceReference remoteServiceReference) {

		System.out.println("proxyRegistering\n\tendpointDesctription = " + endpointDescription  +
				"\n\tremoteServiceContainer = " + remoteServiceContainer +
				"\n\tremoteServiceReference = " + remoteServiceReference);
	}

	@Override
	public void retrievingRemoteServiceReferences(
			IRemoteServiceEndpointDescription endpointDescription,
			IRemoteServiceContainer remoteServiceContainer) {

		System.out.println("remoteServiceReferenceRegistering\n\tendpointDesctription = " + endpointDescription  +
				"\n\tremoteServiceContainer = " + remoteServiceContainer);
	}

	@Override
	public void unregistered(
			IRemoteServiceEndpointDescription endpointDescription,
			ServiceRegistration proxyServiceRegistration) {

		System.out.println("remoteServiceReferenceRegistering\n\tendpointDesctription = " + endpointDescription  +
				"\n\tproxyServiceRegistration = " + proxyServiceRegistration);
	}
}
