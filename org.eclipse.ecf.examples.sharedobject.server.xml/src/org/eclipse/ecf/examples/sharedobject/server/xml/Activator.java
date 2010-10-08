package org.eclipse.ecf.examples.sharedobject.server.xml;


import org.eclipse.ecf.core.ContainerFactory;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.core.sharedobject.ISharedObjectContainer;
import org.eclipse.ecf.examples.sharedobject.objects.xstream.XStreamSOMessageSerializer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
	public static final String GENERIC_SERVER_ID = "ecftcp://localhost:4280/mygroup";

	public static final String GENERIC_SERVER_CONTAINER = "ecf.generic.server";

	private IContainer _server;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception
	{
		_server = ContainerFactory.getDefault().createContainer(GENERIC_SERVER_CONTAINER, createNewID(GENERIC_SERVER_ID));
		((ISharedObjectContainer) _server).setSharedObjectMessageSerializer(new XStreamSOMessageSerializer());
		System.out.println("Server has been created on " + GENERIC_SERVER_ID);
	}

	private ID createNewID(String id)
	{
		return IDFactory.getDefault().createStringID(id);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception
	{
		if (_server != null)
			_server.dispose();
	}
}
