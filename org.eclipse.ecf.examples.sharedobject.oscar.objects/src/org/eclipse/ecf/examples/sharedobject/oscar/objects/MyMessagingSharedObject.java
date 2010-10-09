package org.eclipse.ecf.examples.sharedobject.oscar.objects;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.sharedobject.BaseSharedObject;
import org.eclipse.ecf.core.sharedobject.ReplicaSharedObjectDescription;
import org.eclipse.ecf.core.sharedobject.SharedObjectInitException;
import org.eclipse.ecf.core.sharedobject.SharedObjectMsg;
import org.eclipse.ecf.core.sharedobject.events.ISharedObjectActivatedEvent;
import org.eclipse.ecf.core.util.Event;
import org.eclipse.ecf.core.util.IEventProcessor;

public class MyMessagingSharedObject  extends BaseSharedObject implements IMessageSender {

	public static final String NAME_PROPERTY = "name";

	private String _name;

	private IMessageReceiver _messageReceiver;

	public MyMessagingSharedObject(String name, IMessageReceiver receiver)
	{
		_name = name;
		_messageReceiver = receiver;
	}

	/**
	 * Replica constructor (null constructor)
	 */
	public MyMessagingSharedObject() {}

	/* (non-Javadoc)
	 * @see org.eclipse.ecf.core.sharedobject.BaseSharedObject#initialize()
	 */
	protected void initialize() throws SharedObjectInitException
	{
		super.initialize();

		if (isPrimary())
		{
			// If primary, then add an event processor that handles activated
			// event by replicating to all current remote containers
			addEventProcessor(new IEventProcessor()
				{
					public boolean processEvent(Event event)
					{
						if (event instanceof ISharedObjectActivatedEvent)
						{
							ISharedObjectActivatedEvent ae = (ISharedObjectActivatedEvent) event;
							if (ae.getActivatedID().equals(getID()) && isConnected())
								MyMessagingSharedObject.this.replicateToRemoteContainers(null);
						}
						return false;
					}
				});
			System.out.println("Primary(" + getContext().getLocalContainerID().getName() + ")");
		}
		else
		{
			// This is a replica, so initialize the name from property
			_name = (String) getConfig().getProperties().get(NAME_PROPERTY);
			System.out.println("Replica(" + getContext().getLocalContainerID().getName() + ")");
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ecf.core.sharedobject.BaseSharedObject#getReplicaDescription(org.eclipse.ecf.core.identity.ID)
	 */
	protected ReplicaSharedObjectDescription getReplicaDescription(ID receiver)
	{
		// Put primary state into properties and include in replica description
		Map<String, Serializable> properties = new HashMap<String, Serializable>();
		properties.put(NAME_PROPERTY, _name);
		return new ReplicaSharedObjectDescription(this.getClass(), getConfig().getSharedObjectID(),
				getConfig().getHomeContainerID(), properties);
	}

	protected void handleMessage(ID fromID, String message)
	{
		if (_messageReceiver != null)
			_messageReceiver.handleMessage(fromID, message);
		else
			System.out.println(_name + " says " + message);
	}

	protected boolean handleSharedObjectMsg(SharedObjectMsg msg)
	{
		try
		{
			msg.invoke(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return true;
	}

	public void sendMessage(ID targetId, Object message) throws IOException
	{
		sendSharedObjectMsgTo(null, SharedObjectMsg.createMsg(this.getClass().getName(),
				"handleMessage", new Object[] {getLocalContainerID(), message}));
	}
}
