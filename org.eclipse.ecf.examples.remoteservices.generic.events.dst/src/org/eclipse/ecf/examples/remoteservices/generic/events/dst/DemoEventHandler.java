package org.eclipse.ecf.examples.remoteservices.generic.events.dst;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class DemoEventHandler implements EventHandler
{
	public void handleEvent(Event event)
	{
		System.out.println(
				"handleEvent\n\ttopic=" + event.getTopic() +
				"\n\tmessage=" + event.getProperty("message") +
				"\n\tsender=" + event.getProperty("sender"));
	}
}
