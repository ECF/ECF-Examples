package org.eclipse.ecf.examples.sharedobject.objects;

import org.eclipse.ecf.core.identity.ID;

public interface IMessageReceiver
{
	public void handleMessage(ID fromID, Object message);
}
