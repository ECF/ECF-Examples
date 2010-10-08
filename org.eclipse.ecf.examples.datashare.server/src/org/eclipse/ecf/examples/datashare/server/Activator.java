package org.eclipse.ecf.examples.datashare.server;

import org.eclipse.ecf.core.ContainerFactory;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.IContainerListener;
import org.eclipse.ecf.core.events.IContainerConnectedEvent;
import org.eclipse.ecf.core.events.IContainerEvent;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDCreateException;
import org.eclipse.ecf.core.identity.IDFactory;
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

	public static final String GENERIC_SERVER_CONTAINER = "ecf.generic.server";

	public static final String SERVER_CHANNEL_NAME = "server";

	private IContainer _container;

	private IChannel _serverChannel;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception
	{
		_container = createServer();
		_container.addListener(createConnectedContainerListener());
	}

	private IContainer createServer() throws Exception
	{
		return ContainerFactory.getDefault().createContainer(GENERIC_SERVER_CONTAINER, getNewID(GENERIC_SERVER_ID));
	}

	private IContainerListener createConnectedContainerListener()
	{
		return new IContainerListener()
		{
			public void handleEvent(IContainerEvent event)
			{
				if (event instanceof IContainerConnectedEvent)
				{
					try
					{
						ID containerId = ((IContainerConnectedEvent) event).getTargetID();
						System.out.println("connected from " + containerId.getName());
						if (_serverChannel == null)
							_serverChannel = createChannel();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		};
	}

	private ID getNewID(String id) throws IDCreateException
	{
		return IDFactory.getDefault().createStringID(id);
	}

	private IChannel createChannel() throws Exception
	{
		IChannelContainerAdapter adapter = (IChannelContainerAdapter) _container
				.getAdapter(IChannelContainerAdapter.class);
		return adapter.createChannel(getNewID(SERVER_CHANNEL_NAME), getChannelListener(), null);
	}

	private IChannelListener getChannelListener()
	{
		return new IChannelListener()
		{
			public void handleChannelEvent(IChannelEvent event)
			{
				if (event instanceof IChannelMessageEvent)
				{
					try
					{
						IChannelMessageEvent message = (IChannelMessageEvent) event;
						System.out.println("Message from client with id = " + message.getFromContainerID());
						System.out.println("Data: " + new String(message.getData()));

						_serverChannel.sendMessage(message.getFromContainerID(), "Reply from Server".getBytes());
					}
					catch (Exception e)
					{
						e.printStackTrace();
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
		if (_serverChannel != null)
			_serverChannel.dispose();

		if (_container != null)
		{
			_container.disconnect();
			_container.dispose();
		}
	}
}
