package org.eclipse.ecf.examples.generic.server;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerManager;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.ecf.examples.generic.server";

    // The shared instance
    private static Activator plugin;

    private ServiceTracker containerManagerServiceTracker;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;

        IContainerManager containerManager = getContainerManagerService();
        IContainer[] allContainers = containerManager.getAllContainers();
        for (IContainer container: allContainers)
        {
            System.out.println(container.getID().toExternalForm());
        }
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);

        if (containerManagerServiceTracker != null)
            containerManagerServiceTracker.close();
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    private IContainerManager getContainerManagerService() {
        if (containerManagerServiceTracker == null) {
            containerManagerServiceTracker = new ServiceTracker(plugin.getBundle().getBundleContext(),
                    IContainerManager.class.getName(), null);
            containerManagerServiceTracker.open();
        }

        return (IContainerManager) containerManagerServiceTracker.getService();
    }
}
