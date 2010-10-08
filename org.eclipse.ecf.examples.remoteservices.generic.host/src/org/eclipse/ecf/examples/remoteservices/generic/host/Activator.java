package org.eclipse.ecf.examples.remoteservices.generic.host;


import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerManager;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.examples.remoteservices.hello.IHello;
import org.eclipse.ecf.examples.remoteservices.hello.SimpleHello;
import org.eclipse.ecf.remoteservice.IRemoteServiceContainerAdapter;
import org.eclipse.ecf.remoteservice.IRemoteServiceRegistration;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
	public static final String GENERIC_SERVICE_HOST = "ecftcp://localhost:4280/mygroup";

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
		ID serverId = IDFactory.getDefault().createStringID(GENERIC_SERVICE_HOST);
		IContainerManager containerManager = getContainerManagerService();
		_container = containerManager.getContainerFactory().createContainer("ecf.generic.server", serverId);

		// Get remote service container adapter
		IRemoteServiceContainerAdapter containerAdapter = (IRemoteServiceContainerAdapter) _container
			.getAdapter(IRemoteServiceContainerAdapter.class);

		// Register remote service
		_serviceRegistration = containerAdapter.registerRemoteService(new String[] {IHello.class.getName()},
				new SimpleHello(), null);

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
