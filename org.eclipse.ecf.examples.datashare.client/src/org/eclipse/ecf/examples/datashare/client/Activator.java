package org.eclipse.ecf.examples.datashare.client;

import java.util.Hashtable;

import org.eclipse.ecf.core.ContainerConnectException;
import org.eclipse.ecf.core.ContainerFactory;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDCreateException;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.core.security.IConnectContext;
import org.eclipse.ecf.datashare.IChannel;
import org.eclipse.ecf.datashare.IChannelContainerAdapter;
import org.eclipse.ecf.datashare.IChannelListener;
import org.eclipse.ecf.datashare.events.IChannelEvent;
import org.eclipse.ecf.datashare.events.IChannelMessageEvent;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
	public static final String GENERIC_SERVER_ID = "ecftcp://localhost:4280/mygroup";

	public static final String GENERIC_CLIENT_CONTAINER = "ecf.generic.client";

	public static final String CHANNEL_NAME = "channel";

	public static final String SERVER_CHANNEL_NAME = "server";

	public static final int CLIENTS_CNT = 5;

	private IContainer[] containers;

	private Hashtable<ID, IChannelEvent> messageEvents = new Hashtable<ID, IChannelEvent>();

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception
	{
		createClients();
		addChannelToClients();
		connectClients();

		sendMessages();
	}

	private void createClients() throws Exception
	{
		containers = new IContainer[CLIENTS_CNT];

		for (int i = 0; i < containers.length; i++)
			containers[i] = ContainerFactory.getDefault().createContainer(GENERIC_CLIENT_CONTAINER);
	}

	private void addChannelToClients() throws Exception
	{
		for (int i = 0; i < CLIENTS_CNT; i++)
		{
			IChannelContainerAdapter channelContainer = (IChannelContainerAdapter) containers[i]
			        .getAdapter(IChannelContainerAdapter.class);
			channelContainer.createChannel(getNewID(CHANNEL_NAME), getChannelListener(containers[i].getID()), null);
		}
	}

	private ID getNewID(String id) throws IDCreateException
	{
		return IDFactory.getDefault().createStringID(id);
	}

	private IChannelListener getChannelListener(final ID id) throws Exception
	{
		return new IChannelListener()
		{
			public void handleChannelEvent(IChannelEvent event)
			{
				if (event instanceof IChannelMessageEvent)
				{
					messageEvents.put(id, event);
				}
			}
		};
	}

	private void connectClients() throws Exception
	{
		for (int i = 0; i < containers.length; i++)
			connectClient(containers[i], IDFactory.getDefault().createStringID(GENERIC_SERVER_ID), getConnectContext(i));
	}

	private IConnectContext getConnectContext(int index)
	{
		return null;
	}

	private void connectClient(IContainer containerToConnect, ID connectID, IConnectContext context)
			throws ContainerConnectException
	{
		containerToConnect.connect(connectID, context);
	}

	private void disconnectClients() throws Exception
	{
		for (int i = 0; i < containers.length; i++)
			containers[i].disconnect();
	}

	private IChannelContainerAdapter getChannelContainer(int index)
	{
		return (IChannelContainerAdapter) containers[index].getAdapter(IChannelContainerAdapter.class);
	}

	private void sendMessages() throws IDCreateException, Exception
	{
		IChannelContainerAdapter senderContainer = getChannelContainer(0);
		IChannel sender = senderContainer.getChannel(getNewID(CHANNEL_NAME));
		sender.sendMessage("Hello from ECF!".getBytes());

		IChannel toServer = senderContainer.createChannel(getNewID(SERVER_CHANNEL_NAME),
				getChannelListener(getNewID(SERVER_CHANNEL_NAME)), null);

		toServer.sendMessage("Hello from client".getBytes());

		sleep(3000);

		for (int i = 1; i < CLIENTS_CNT; i++)
			handleEvent(containers[i].getID());

		handleEvent(getNewID(SERVER_CHANNEL_NAME));
	}

	private void handleEvent(ID id)
	{
		IChannelEvent event = messageEvents.get(id);
		if (event instanceof IChannelMessageEvent)
		{
			System.out.println("chanelID = " + event.getChannelID().getName());
			System.out.println("data = " + new String(((IChannelMessageEvent) event).getData()));
			System.out.println();
		}
	}

	private void sleep(int pause)
	{
		try
		{
			Thread.sleep(pause);
		}
		catch (InterruptedException e)
		{
		}
	}

	private void clearClientEvents()
	{
		messageEvents.clear();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception
	{
		clearClientEvents();
		disconnectClients();
	}
}
