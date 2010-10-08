package org.eclipse.ecf.examples.remoteservices.generic.events.src;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

public class DemoEventSender
{
	private EventAdmin eventAdmin;

	private String sender;

	private String topic;

	private int messageCounter = 0;

	public DemoEventSender(EventAdmin eventAdmin, String topic, String sender)
	{
		this.eventAdmin = eventAdmin;
		this.topic = topic;
		this.sender = sender;
	}

	public void send()
	{
		 if (eventAdmin != null)
			 eventAdmin.postEvent(new Event(topic, getEventProperties()));
	}

	protected Dictionary<String, Object> getEventProperties()
	{
		Dictionary<String, Object> result = new Hashtable<String, Object>();
		result.put("message", "message #" + messageCounter++);
		result.put("sender", sender);
		return result;
	}

	public void start()
	{
		getTaskThread().start();
	}

	public void stop()
	{
		getTaskThread().interrupt();
	}

	private Thread taskThread = new Thread(new Runnable()
	{
		public void run()
		{
			while (true)
			{
				try
		        {
					send();
					Thread.sleep(5000);
		        }
		        catch (InterruptedException ex)
		        {
		        }
		    }
		}
	});

	protected Thread getTaskThread()
	{
		return taskThread;
	}
}
