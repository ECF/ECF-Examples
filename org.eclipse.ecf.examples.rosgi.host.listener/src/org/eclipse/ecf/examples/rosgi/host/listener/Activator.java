package org.eclipse.ecf.examples.rosgi.host.listener;

import org.eclipse.ecf.osgi.services.discovery.IHostDiscoveryListener;
import org.eclipse.ecf.osgi.services.distribution.IHostDistributionListener;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration _hostDistributionListenerRegistration;

	private ServiceRegistration _hostDiscoveryListenerRegistration;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		_hostDistributionListenerRegistration = context.registerService(IHostDistributionListener.class.getName(),
				new MyHostDistributionListener(), null);

		_hostDiscoveryListenerRegistration = context.registerService(IHostDiscoveryListener.class.getName(),
				new MyHostDiscoveryListener(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		_hostDiscoveryListenerRegistration.unregister();
		_hostDistributionListenerRegistration.unregister();
	}
}
