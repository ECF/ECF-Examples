package org.eclipse.ecf.examples.remoteservices.rosgi.host;


import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerManager;
import org.eclipse.ecf.examples.remoteservices.hello.IHello;
import org.eclipse.ecf.examples.remoteservices.hello.impl.Hello;
import org.eclipse.ecf.remoteservice.IRemoteServiceContainerAdapter;
import org.eclipse.ecf.remoteservice.IRemoteServiceRegistration;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
	private BundleContext _context;
	private ServiceTracker _containerManagerServiceTracker;
	private IContainer _container;
	private IRemoteServiceRegistration _serviceRegistration;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception
	{
		_context = context;

		// Create R-OSGi Container
		IContainerManager containerManager = getContainerManagerService();
		_container = containerManager.getContainerFactory().createContainer("ecf.r_osgi.peer");

		// Get remote service container adapter
		IRemoteServiceContainerAdapter containerAdapter = (IRemoteServiceContainerAdapter) _container
			.getAdapter(IRemoteServiceContainerAdapter.class);

		// Register remote service
		_serviceRegistration = containerAdapter.registerRemoteService(new String[] {IHello.class.getName()},
				new Hello(), null);

		System.out.println("IHello RemoteService registered");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception
	{
		if (_serviceRegistration != null)
			_serviceRegistration.unregister();

		if (_container != null)
			_container.disconnect();

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
