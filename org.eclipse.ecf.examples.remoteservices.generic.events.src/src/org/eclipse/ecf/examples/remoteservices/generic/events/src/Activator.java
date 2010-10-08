package org.eclipse.ecf.examples.remoteservices.generic.events.src;


import org.eclipse.ecf.core.ContainerCreateException;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerManager;
import org.eclipse.ecf.examples.remoteservices.generic.events.util.EventAdminUtil;
import org.eclipse.ecf.remoteservice.eventadmin.DistributedEventAdmin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
    public static final String GENERIC_SERVER_ID = "ecftcp://localhost:4280/mygroup";

    public static final String GENERIC_SERVER_CONTAINER = "ecf.generic.server";

    public static final String TOPIC = "org/eclipse/ecf/examples/demo";

    public static final String E_A_NAME = "org.eclipse.ecf.examples.remoteservices.generic.events";

    private DistributedEventAdmin eventAdmin;

    private IContainer container;

    private ServiceRegistration eventAdminRegistration;

    private ServiceTracker containerManagerTracker;

    private BundleContext bundleContext;

    private DemoEventSender sender;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception
    {
        // save context
        bundleContext = context;

        // create container
        createServer();

        // create and share EventAdmin implementation
        eventAdmin = (DistributedEventAdmin) EventAdminUtil.createSharedEventAdmin(container, context, E_A_NAME);

        // register as EventAdmin service instance
        EventAdminUtil.registerEventAdminService(eventAdmin, context);

        // start events sender
        sender = new DemoEventSender(eventAdmin, TOPIC, container.getID().getName());
        sender.start();
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception
    {
        if (sender != null)
            sender.stop();

        if (eventAdminRegistration != null)
            eventAdminRegistration.unregister();

        if (eventAdmin != null)
            eventAdmin.stop();

        if (container != null)
            container.dispose();

        if (containerManagerTracker != null)
            containerManagerTracker.close();
    }

    private void createServer() throws ContainerCreateException
    {
        container = getContainerManager().getContainerFactory().createContainer(GENERIC_SERVER_CONTAINER,
                EventAdminUtil.getID(GENERIC_SERVER_ID));
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
