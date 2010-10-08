package org.eclipse.ecf.examples.remoteservices.generic.events.util;

import java.util.Properties;

import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.core.sharedobject.ISharedObject;
import org.eclipse.ecf.core.sharedobject.ISharedObjectContainer;
import org.eclipse.ecf.core.sharedobject.SharedObjectAddException;
import org.eclipse.ecf.remoteservice.eventadmin.DistributedEventAdmin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;

public class EventAdminUtil
{
	public static EventAdmin createSharedEventAdmin(IContainer container, BundleContext context, String name)
			throws SharedObjectAddException
	{
		DistributedEventAdmin eventAdmin = new DistributedEventAdmin(context);
		shareEventAdmin(eventAdmin, getSharedObjectContainer(container), name);

		eventAdmin.start();

		return eventAdmin;
	}

	public static ID getID(String id)
	{
		return IDFactory.getDefault().createStringID(id);
	}

	public static ServiceRegistration registerEventAdminService(EventAdmin eventAdmin, BundleContext context)
	{
		return context.registerService(EventAdmin.class.getName(), eventAdmin, null);
	}

	public static ServiceRegistration registerEventAdminService(EventAdmin eventAdmin, BundleContext context,
			String topics)
	{
		Properties props = new Properties();
		props.put(EventConstants.EVENT_TOPIC, topics);
		return context.registerService(EventAdmin.class.getName(), eventAdmin, props);
	}

	private static ISharedObjectContainer getSharedObjectContainer(IContainer container)
	{
		return (ISharedObjectContainer) container.getAdapter(ISharedObjectContainer.class);
	}

	private static void shareEventAdmin(ISharedObject eventAdmin, ISharedObjectContainer so, String name)
			throws SharedObjectAddException
	{
		so.getSharedObjectManager().addSharedObject(getID(name), eventAdmin, null);
	}

}
