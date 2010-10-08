package org.eclipse.ecf.examples.remoteservices.generic.client;

import java.util.Date;


import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerManager;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.examples.remoteservices.hello.IHello;
import org.eclipse.ecf.remoteservice.IRemoteCall;
import org.eclipse.ecf.remoteservice.IRemoteCallListener;
import org.eclipse.ecf.remoteservice.IRemoteService;
import org.eclipse.ecf.remoteservice.IRemoteServiceContainerAdapter;
import org.eclipse.ecf.remoteservice.IRemoteServiceReference;
import org.eclipse.ecf.remoteservice.events.IRemoteCallCompleteEvent;
import org.eclipse.ecf.remoteservice.events.IRemoteCallEvent;
import org.eclipse.equinox.concurrent.future.IFuture;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
	public static final String GENERIC_SERVICE_HOST = "ecftcp://localhost:4280/mygroup";

	private BundleContext _context;
	private ServiceTracker _containerManagerServiceTracker;
	private IContainer _container;

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
		_container = containerManager.getContainerFactory().createContainer("ecf.generic.client");

		// Get remote service container adapter
		IRemoteServiceContainerAdapter containerAdapter = (IRemoteServiceContainerAdapter) _container
				.getAdapter(IRemoteServiceContainerAdapter.class);

		// Lookup IRemoteServiceReference
		IRemoteServiceReference[] helloReferences = containerAdapter.getRemoteServiceReferences(IDFactory.getDefault()
				.createID(_container.getConnectNamespace(), GENERIC_SERVICE_HOST), IHello.class.getName(), null);

		// Get remote service for reference
		IRemoteService remoteService = containerAdapter.getRemoteService(helloReferences[0]);

		// Get the proxy
		IHello proxy = (IHello) remoteService.getProxy();

		// Call the proxy
		proxy.hello("RemoteService Client via Proxy");
		System.out.println((new Date()) + " RemoteService Called via Proxy");

		// Call Sync
		remoteService.callSync(createRemoteCall("RemoteService Client Sync"));
		System.out.println((new Date()) + " RemoteService Called Sync");

		// Call Async
		remoteService.callAsync(createRemoteCall("RemoteService Client Async"), createRemoteCallListener());
		System.out.println((new Date()) + " RemoteService Called Async");

		// Call Async via IFuture
		IFuture future = remoteService.callAsync(createRemoteCall("RemoteService Client Async via Future"));
		System.out.println((new Date()) + " Create IFuture");
		// ...
		future.get();
		System.out.println((new Date()) + " RemoteService Called via IFuture");
	}

	private IRemoteCall createRemoteCall(final String message)
	{
		return new IRemoteCall()
		{
			@Override
			public String getMethod()
			{
				return "hello";
			}

			@Override
			public Object[] getParameters()
			{
				return new Object[] {message};
			}

			@Override
			public long getTimeout()
			{
				return 0;
			}
		};
	}

	private IRemoteCallListener createRemoteCallListener()
	{
		return new IRemoteCallListener()
		{
			@Override
			public void handleEvent(IRemoteCallEvent event)
			{
				if (event instanceof IRemoteCallCompleteEvent)
				{
					IRemoteCallCompleteEvent cce = (IRemoteCallCompleteEvent) event;
					if (!cce.hadException())
						System.out.println("Remote call completed successfully!");
					else
						System.out.println("Remote call completed with exception: " + cce.getException());
				}
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception
	{
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
