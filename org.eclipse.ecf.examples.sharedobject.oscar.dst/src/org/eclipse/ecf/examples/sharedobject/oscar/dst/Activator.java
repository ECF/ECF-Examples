package org.eclipse.ecf.examples.sharedobject.oscar.dst;


import org.eclipse.ecf.core.ContainerConnectException;
import org.eclipse.ecf.core.ContainerFactory;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerListener;
import org.eclipse.ecf.core.events.IContainerEvent;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.core.security.ConnectContextFactory;
import org.eclipse.ecf.core.security.IConnectContext;
import org.eclipse.ecf.core.sharedobject.ISharedObject;
import org.eclipse.ecf.core.sharedobject.ISharedObjectContainer;
import org.eclipse.ecf.core.sharedobject.ISharedObjectManager;
import org.eclipse.ecf.core.sharedobject.events.ISharedObjectActivatedEvent;
import org.eclipse.ecf.examples.sharedobject.oscar.objects.MySharedObject;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
    public static final String UIN = "ICQ-UIN";

    public static final String PASSWORD = "ICQ-PASSWORDS";

    public static final String OSCAR_CONTAINER = "ecf.oscar.icqlib";

    private IContainer[] _containers;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception
    {
        createClients();
        connectClients();
        System.out.println("All clients have been connected");
    }

    private int getClientCount()
    {
        return 1;
    }

    private IContainer[] createClients() throws Exception
    {
        _containers = new IContainer[getClientCount()];

        for (int i = 0; i < _containers.length; i++)
            _containers[i] = createClient(i);

        for (int i = 0; i < _containers.length; i++)
            _containers[i].addListener(createConnectedContainerListener(i));

        return _containers;
    }

    private IContainerListener createConnectedContainerListener(final int index)
    {
        return new IContainerListener()
        {
            public void handleEvent(IContainerEvent event)
            {
                if (event instanceof ISharedObjectActivatedEvent)
                {
                    try
                    {
                        ISharedObjectActivatedEvent ae = (ISharedObjectActivatedEvent) event;

                        System.out.println("Took shared object with id = " + ae.getActivatedID().getName()
                                + " to " + ae.getLocalContainerID().getName());

                        ISharedObjectManager manager = getClientSOManager(index);
                        ISharedObject sharedObject = manager.getSharedObject(ae.getActivatedID());
                        System.out.println("Shared Object class = " + sharedObject.getClass().getName());

                        if (sharedObject instanceof MySharedObject)
                        {
                            MySharedObject my = (MySharedObject) sharedObject;
                            System.out.println("Name = " + my.getName());
                            System.out.println("Demo = " + my.getProperty());
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private void connectClients() throws Exception
    {
        for (int i = 0; i < _containers.length; i++)
            connectClient(_containers[i], createServerID(),
                    ConnectContextFactory.createUsernamePasswordConnectContext(UIN, PASSWORD));
    }

    private void connectClient(IContainer containerToConnect, ID connectID, IConnectContext context)
            throws ContainerConnectException
    {
        containerToConnect.connect(connectID, context);
    }

    private IContainer createClient(int index) throws Exception
    {
        return ContainerFactory.getDefault().createContainer(OSCAR_CONTAINER);
    }

    private ID createNewID(String id)
    {
        return IDFactory.getDefault().createStringID(id);
    }

    private ID createServerID() throws Exception
    {
        return IDFactory.getDefault().createID(_containers[0].getConnectNamespace(), UIN);
    }

    private ISharedObjectContainer getClientSOContainer(int clientindex)
    {
        return (ISharedObjectContainer) _containers[clientindex];
    }

    private ISharedObjectManager getClientSOManager(int clientindex)
    {
        return getClientSOContainer(clientindex).getSharedObjectManager();
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception
    {
        if (_containers != null)
        {
            for (int i = 0; i < _containers.length; i++)
                _containers[i].dispose();
        }
    }
}
