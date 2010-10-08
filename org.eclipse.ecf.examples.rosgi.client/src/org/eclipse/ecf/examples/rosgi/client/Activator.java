package org.eclipse.ecf.examples.rosgi.client;

import java.util.Date;


import org.eclipse.ecf.core.IContainerManager;
import org.eclipse.ecf.core.util.ECFException;
import org.eclipse.ecf.examples.remoteservices.hello.IHello;
import org.eclipse.ecf.osgi.services.distribution.IDistributionConstants;
import org.eclipse.ecf.remoteservice.IRemoteCall;
import org.eclipse.ecf.remoteservice.IRemoteService;
import org.eclipse.ecf.remoteservice.RemoteServiceHelper;
import org.eclipse.equinox.concurrent.future.IFuture;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator implements BundleActivator, IDistributionConstants, ServiceTrackerCustomizer
{
    public static final String CONSUMER_NAME = "org.eclipse.ecf.examples.rosgi.client";

    private BundleContext _context;
    private ServiceTracker _containerManagerServiceTracker;
    private ServiceTracker _helloServiceTracker;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception
    {
        _context = context;
        
        IContainerManager containerManager = getContainerManagerService();
        containerManager.getContainerFactory().createContainer("ecf.r_osgi.peer");

        _helloServiceTracker = new ServiceTracker(context, createRemoteFilter(), this);
        _helloServiceTracker.open();
    }

    private Filter createRemoteFilter() throws InvalidSyntaxException
    {
        return _context.createFilter("(&("+org.osgi.framework.Constants.OBJECTCLASS + "=" + IHello.class.getName()
                + ")(" + SERVICE_IMPORTED + "=*))");
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception
    {
        _helloServiceTracker.close();

        if (_containerManagerServiceTracker != null)
            _containerManagerServiceTracker.close();
    }

    public Object addingService(ServiceReference reference)
    {
        System.out.println("IHello service proxy being added");

        IHello hello = (IHello) _context.getService(reference);

        System.out.println((new Date()) + " Call hello using proxy");
        hello.hello(CONSUMER_NAME);
        System.out.println((new Date()) + " Called hello using proxy");

        // bundle org.eclipse.ecf.remoteservice
        IRemoteService remoteService = (IRemoteService) reference.getProperty(SERVICE_IMPORTED);
        try
        {
            System.out.println((new Date()) + " Call hello asynchronously");

            remoteService.fireAsync(new IRemoteCall() {
                public String getMethod() {
                    return "hello";
                }

                public Object[] getParameters() {
                    return new Object[] { CONSUMER_NAME + " async" };
                }

                public long getTimeout() {
                    return 30000;
                }});
            System.out.println((new Date()) + " Called hello asynchronously");
        }
        catch (ECFException e) {
            e.printStackTrace();
        }

        // This futureExec returns immediately
        System.out.println((new Date()) + " Call hello using future");
        IFuture future = RemoteServiceHelper.futureExec(remoteService, "hello",
                new Object[] { CONSUMER_NAME + " future" });

        try {
            // This method blocks until a return
            future.get();
            System.out.println((new Date()) + " Called hello using future");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hello;
    }

    public void modifiedService(ServiceReference reference, Object service)
    {
    }

    public void removedService(ServiceReference reference, Object service)
    {
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
