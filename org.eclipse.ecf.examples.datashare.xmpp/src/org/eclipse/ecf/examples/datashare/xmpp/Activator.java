package org.eclipse.ecf.examples.datashare.xmpp;

import org.eclipse.ecf.core.ContainerConnectException;
import org.eclipse.ecf.core.ContainerFactory;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDCreateException;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.core.security.ConnectContextFactory;
import org.eclipse.ecf.core.security.IConnectContext;
import org.eclipse.ecf.core.util.ECFException;
import org.eclipse.ecf.datashare.IChannel;
import org.eclipse.ecf.datashare.IChannelContainerAdapter;
import org.eclipse.ecf.datashare.IChannelListener;
import org.eclipse.ecf.datashare.events.IChannelEvent;
import org.eclipse.ecf.datashare.events.IChannelMessageEvent;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
	public static final String XMPP_NAMESPACE = "ecf.xmpp";

	public static final String XMPP_CONTAINER = "ecf.xmpp.smack";

	public static final String XMPP_ACCOUNT_ID = "account";

	public static final String XMPP_TO_ID = "to";

	public static final String XMPP_TO_RESOURCE_ID = "resource";

	public static final String LOGIN = "login";

	public static final String PASSWORD = "password";

	public static final String CHANNEL_NAME = "channel";

	private IContainer _container;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception
	{
		_container = ContainerFactory.getDefault().createContainer(XMPP_CONTAINER);

		connectClient(getNewID(true, System.getProperty(XMPP_ACCOUNT_ID)),
				getConnectContext(System.getProperty(LOGIN), System.getProperty(PASSWORD)));

		addChannelToClient();

		System.out.println("I'm " + System.getProperty(XMPP_ACCOUNT_ID));

		if (System.getProperty(XMPP_TO_ID) != null)
			sendMessage();
	}

	protected void connectClient(ID connectID, IConnectContext context) throws ContainerConnectException
	{
		_container.connect(connectID, context);
	}

	protected IConnectContext getConnectContext(String username, String password)
	{
		return ConnectContextFactory.createUsernamePasswordConnectContext(username, password);
	}

	private ID getNewID(boolean namespace, String id) throws IDCreateException
	{
		if (namespace)
			return IDFactory.getDefault().createID(IDFactory.getDefault().getNamespaceByName(XMPP_NAMESPACE), id);
		else
			return IDFactory.getDefault().createStringID(id);
	}

	private void addChannelToClient() throws Exception
	{
		IChannelContainerAdapter channelContainer = (IChannelContainerAdapter) _container
				.getAdapter(IChannelContainerAdapter.class);
		channelContainer.createChannel(getNewID(false, CHANNEL_NAME), getChannelListener(), null);
	}

	private IChannel getChannel()
	{
		IChannelContainerAdapter channelContainer = (IChannelContainerAdapter) _container
			.getAdapter(IChannelContainerAdapter.class);
		return channelContainer.getChannel(getNewID(false, CHANNEL_NAME));
	}

	private void sendMessage() throws ECFException
	{
		IChannel sender = getChannel();
		System.out.println("send message to " + System.getProperty(XMPP_TO_ID));
		sender.sendMessage(IDFactory.getDefault().createID(_container.getConnectNamespace(), System.getProperty(XMPP_TO_ID) + "/" + System.getProperty(XMPP_TO_RESOURCE_ID)),
				("Hello from " + System.getProperty(XMPP_ACCOUNT_ID) + "!").getBytes());
	}

	private IChannelListener getChannelListener() throws Exception
	{
		return new IChannelListener()
		{
			public void handleChannelEvent(IChannelEvent event)
			{
				if (event instanceof IChannelMessageEvent)
				{
					IChannelMessageEvent message = (IChannelMessageEvent) event;
					System.out.println(new String(message.getData()));
					System.out.println("channel = " + message.getChannelID());
					System.out.println("from = " + message.getFromContainerID());
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
		if (_container != null)
		{
			_container.disconnect();
			_container.dispose();
		}
	}
}
