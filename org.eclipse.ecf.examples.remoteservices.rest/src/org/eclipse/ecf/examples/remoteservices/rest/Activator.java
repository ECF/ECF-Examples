package org.eclipse.ecf.examples.remoteservices.rest;

import java.util.Dictionary;


import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerManager;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.core.util.ECFException;
import org.eclipse.ecf.examples.remoteservices.rest.processor.XStreamResponseDeserializer;
import org.eclipse.ecf.examples.remoteservices.rest.twitter.entity.User;
import org.eclipse.ecf.remoteservice.IRemoteCallListener;
import org.eclipse.ecf.remoteservice.IRemoteService;
import org.eclipse.ecf.remoteservice.IRemoteServiceRegistration;
import org.eclipse.ecf.remoteservice.client.IRemoteCallParameter;
import org.eclipse.ecf.remoteservice.client.IRemoteCallable;
import org.eclipse.ecf.remoteservice.client.IRemoteServiceClientContainerAdapter;
import org.eclipse.ecf.remoteservice.client.RemoteCallParameterFactory;
import org.eclipse.ecf.remoteservice.events.IRemoteCallCompleteEvent;
import org.eclipse.ecf.remoteservice.events.IRemoteCallEvent;
import org.eclipse.ecf.remoteservice.rest.IRestCall;
import org.eclipse.ecf.remoteservice.rest.RestCallFactory;
import org.eclipse.ecf.remoteservice.rest.RestCallableFactory;
import org.eclipse.ecf.remoteservice.rest.client.HttpGetRequestType;
import org.eclipse.ecf.remoteservice.rest.identity.RestNamespace;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
	private static final String COUNT = "count";

	private static final String REST_CONTAINER_TYPE = "ecf.rest.client";

	private static final String TWITTER_TARGET = "http://twitter.com";

	private static final String TWITTER_RESOURCEPATH = "users/show/samolisov.xml";

	private static final RestNamespace REST_NAMESPACE = new RestNamespace(RestNamespace.NAME, null);

	private BundleContext _context;

	private IContainer _container;

	private ServiceTracker _containerManagerServiceTracker;

	private IRemoteServiceRegistration _registration;

	private IRemoteServiceClientContainerAdapter _adapter;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception
	{
		_context = context;

		IContainerManager containerManager = getContainerManagerService();
		_container = containerManager.getContainerFactory().createContainer(REST_CONTAINER_TYPE,
				getRestID(TWITTER_TARGET));

		_adapter = getRestClientContainerAdapter();

		_adapter.setResponseDeserializer(new XStreamResponseDeserializer());

		System.out.println("Container ID = " + _container.getID().getName());

		registerCall();

		IRemoteService restClientService = _adapter.getRemoteService(_registration.getReference());
		syncCallDemo(restClientService);
		asyncCallDemo(restClientService);
	}

	private void syncCallDemo(IRemoteService restClientService)
	{
		try
		{
			System.out.println("sync calling...");
			User result = (User) restClientService.callSync(getRestXMLCall());
			System.out.println("sync called...");
			System.out.println(result.getDescription());
			System.out.println(result.getStatus().getText());
		}
		catch (ECFException e)
		{
			e.printStackTrace();
		}
	}

	private void asyncCallDemo(IRemoteService restClientService)
	{
		System.out.println("async calling...");
		restClientService.callAsync(getRestXMLCall(), createRemoteCallListener());
		System.out.println("async called...");
	}

	private void registerCall()
	{
		IRemoteCallParameter[] parameters = RemoteCallParameterFactory.createParameters(COUNT, null);
		IRemoteCallable callable = RestCallableFactory.createCallable(TWITTER_RESOURCEPATH, TWITTER_RESOURCEPATH, 
				parameters, new HttpGetRequestType());
		
		_registration = registerCallable(callable, null);
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
	    			{
	                    System.out.println("Remote call completed successfully!");

	                    User result = (User) cce.getResponse();
		            	System.out.println(result.getDescription());
		    			System.out.println(result.getStatus().getText());
	    			}
	                else
	                {
	                    System.out.println("Remote call completed with exception: " + cce.getException());
	                }
	            }
	        }
	    };
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception
	{
		if (_registration != null)
			_registration.unregister();

		if (_container != null)
			_container.disconnect();

		if (_containerManagerServiceTracker != null)
			_containerManagerServiceTracker.close();
	}

	private ID getRestID(String uri)
	{
		return IDFactory.getDefault().createID(REST_NAMESPACE, uri);
	}

	private IRemoteServiceClientContainerAdapter getRestClientContainerAdapter()
	{
		return (IRemoteServiceClientContainerAdapter) _container.getAdapter(IRemoteServiceClientContainerAdapter.class);
	}

	private IRemoteServiceRegistration registerCallable(IRemoteCallable callable, Dictionary<String, String> properties)
	{
		return _adapter.registerCallables(new IRemoteCallable[]{callable}, properties);
	}

	private IRestCall getRestXMLCall()
	{
		return RestCallFactory.createRestCall(TWITTER_RESOURCEPATH);
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
