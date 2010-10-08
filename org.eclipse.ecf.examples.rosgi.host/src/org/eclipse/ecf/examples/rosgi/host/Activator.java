package org.eclipse.ecf.examples.rosgi.host;

import java.util.Properties;


import org.eclipse.ecf.core.IContainerManager;
import org.eclipse.ecf.examples.remoteservices.hello.IHello;
import org.eclipse.ecf.examples.remoteservices.hello.SimpleHello;
import org.eclipse.ecf.osgi.services.distribution.IDistributionConstants;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator, IDistributionConstants
{
	private static final String R_OSGI_CONTAINER_TYPE = "ecf.r_osgi.peer";
	
	private BundleContext _context;
	private ServiceTracker _containerManagerServiceTracker;
	private ServiceRegistration _helloRegistration;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception
	{
		_context = context;

		IContainerManager containerManager = getContainerManagerService();
		containerManager.getContainerFactory().createContainer(R_OSGI_CONTAINER_TYPE);

		Properties props = new Properties();
		// add OSGi service property indicated export of all interfaces exposed
		// by service (wildcard)
		props.put(IDistributionConstants.SERVICE_EXPORTED_INTERFACES,
				IDistributionConstants.SERVICE_EXPORTED_INTERFACES_WILDCARD);
		// add OSGi service property specifying config
		props.put(IDistributionConstants.SERVICE_EXPORTED_CONFIGS,
				R_OSGI_CONTAINER_TYPE);
		
		_helloRegistration = context.registerService(IHello.class.getName(), new SimpleHello(), props);
		System.out.println("Hello Service has been registered");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception
	{
		if (_helloRegistration != null)
			_helloRegistration.unregister();

		if (_containerManagerServiceTracker != null)
			_containerManagerServiceTracker.close();
	}

	private IContainerManager getContainerManagerService()
	{
		if (_containerManagerServiceTracker == null)
		{
			_containerManagerServiceTracker = new ServiceTracker(_context, IContainerManager.class.getName(), null);
			_containerManagerServiceTracker.open();
		}

		return (IContainerManager) _containerManagerServiceTracker.getService();
	}
}
