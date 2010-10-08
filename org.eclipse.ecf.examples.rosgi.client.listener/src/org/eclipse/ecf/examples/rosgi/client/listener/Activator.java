package org.eclipse.ecf.examples.rosgi.client.listener;

import org.eclipse.ecf.osgi.services.discovery.IProxyDiscoveryListener;
import org.eclipse.ecf.osgi.services.distribution.IProxyDistributionListener;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration _proxyDiscoveryRegistration;

	private ServiceRegistration _proxyDistributionRegistration;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		_proxyDiscoveryRegistration = context.registerService(IProxyDiscoveryListener.class.getName(),
				new MyProxyDiscoveryListener(), null);

		_proxyDistributionRegistration = context.registerService(IProxyDistributionListener.class.getName(),
				new MyProxyDistributionListener(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		_proxyDiscoveryRegistration.unregister();
		_proxyDistributionRegistration.unregister();
	}
}
