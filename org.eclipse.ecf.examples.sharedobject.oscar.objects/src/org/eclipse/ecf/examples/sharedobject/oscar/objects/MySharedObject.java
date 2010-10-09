package org.eclipse.ecf.examples.sharedobject.oscar.objects;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.identity.IDFactory;
import org.eclipse.ecf.core.sharedobject.BaseSharedObject;
import org.eclipse.ecf.core.sharedobject.ReplicaSharedObjectDescription;
import org.eclipse.ecf.core.sharedobject.SharedObjectInitException;
import org.eclipse.ecf.core.sharedobject.events.ISharedObjectActivatedEvent;
import org.eclipse.ecf.core.util.Event;
import org.eclipse.ecf.core.util.IEventProcessor;

public class MySharedObject extends BaseSharedObject
{
	private static final String EMPTY = "";

	public static final String NAME_PROPERTY = "name";

	public static final String PROPERTY_PROPERTY = "property";

	private final String _uin;

	private String _name;

	private DemoProperty _property;

	public MySharedObject(String uin, String name, String id, int a, float b)
	{
		_name = name;
		_uin = uin;
		_property = new DemoProperty(id, a, b);
	}

	/**
	 * Replica constructor (null constructor)
	 */
	public MySharedObject() {_uin = EMPTY;}

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
							ISharedObjectActivatedEvent activated = (ISharedObjectActivatedEvent) event;
							if (activated.getActivatedID().equals(getID()) && isConnected())
							{
								try
								{
									MySharedObject.this.replicateToRemoteContainers(
											new ID[]{createToID(activated.getLocalContainerID())});
								}
								catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
						return false;
					}

					private ID createToID(ID id)
					{
						return IDFactory.getDefault().createID(id.getNamespace(), _uin);
					}
				});

			System.out.println("Primary(" + getContext().getLocalContainerID().getName() + ")");
		}
		else
		{
			// This is a replica, so deserialize properties from HashMap to Object
			_name = (String) getConfig().getProperties().get(NAME_PROPERTY);
			_property = (DemoProperty) getConfig().getProperties().get(PROPERTY_PROPERTY);
			System.out.println("Replica(" + getContext().getLocalContainerID().getName() + ")");
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ecf.core.sharedobject.BaseSharedObject#getReplicaDescription(org.eclipse.ecf.core.identity.ID)
	 */
	protected ReplicaSharedObjectDescription getReplicaDescription(ID receiver)
	{
		System.out.println("getReplicaDescription(receiver = " + receiver + ")");

		// Put primary state into properties and include in replica description
		// This is serialization SharedObject into HashMap
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(NAME_PROPERTY, _name);
		properties.put(PROPERTY_PROPERTY, _property);
		return new ReplicaSharedObjectDescription(this.getClass(), getConfig().getSharedObjectID(),
				getConfig().getHomeContainerID(), properties);
	}

	public String getName()
	{
		return _name;
	}

	public DemoProperty getProperty()
	{
		return _property;
	}
}
