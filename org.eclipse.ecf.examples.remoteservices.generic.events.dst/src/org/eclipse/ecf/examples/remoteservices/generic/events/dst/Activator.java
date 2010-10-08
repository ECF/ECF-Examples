package org.eclipse.ecf.examples.remoteservices.generic.events.dst;

import java.util.Dictionary;
import java.util.Hashtable;


import org.eclipse.ecf.core.ContainerConnectException;
import org.eclipse.ecf.core.ContainerCreateException;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerManager;
import org.eclipse.ecf.examples.remoteservices.generic.events.util.EventAdminUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
    public static final String GENERIC_SERVER_ID = "ecftcp://localhost:4280/mygroup";

    public static final String GENERIC_CLIENT_CONTAINER = "ecf.generic.client";

    public static final String E_A_NAME = "org.eclipse.ecf.examples.remoteservices.generic.events";

    private IContainer container;

    private ServiceTracker containerManagerTracker;

    private BundleContext bundleContext;

    private ServiceRegistration eventHandlerRegistration;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception
    {
        // save context
        bundleContext = context;

        // create container and connect
        createContainer();

        // create and share EventAdmin implementation
        EventAdminUtil.createSharedEventAdmin(container, context, E_A_NAME);

        // register handler
        eventHandlerRegistration = bundleContext.registerService(EventHandler.class.getName(),
                new DemoEventHandler(), getHandlerServiceProperties("org/eclipse/ecf/examples/*"));
    }

     protected Dictionary<String, Object> getHandlerServiceProperties(String... topics)
     {
         Dictionary<String, Object> result = new Hashtable<String, Object>();
         result.put(EventConstants.EVENT_TOPIC, topics);
         return result;
     }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception
    {
        if (eventHandlerRegistration != null)
            eventHandlerRegistration.unregister();

        if (container != null)
            container.dispose();

        if (containerManagerTracker != null)
            containerManagerTracker.close();
    }

    private void createContainer() throws ContainerCreateException, ContainerConnectException
    {
        container = getContainerManager().getContainerFactory().createContainer(GENERIC_CLIENT_CONTAINER);
        container.connect(EventAdminUtil.getID(GENERIC_SERVER_ID), null);
    }

    private IContainerManager getContainerManager()
    {
        if (containerManagerTracker == null)
        {
            containerManagerTracker = new ServiceTracker(bundleContext, IContainerManager.class.getName(), null);
            containerManagerTracker.open();
        }

        return (IContainerManager) containerManagerTracker.getService();
    }
}
