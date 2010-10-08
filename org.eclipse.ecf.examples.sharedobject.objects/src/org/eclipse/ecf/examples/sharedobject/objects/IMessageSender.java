package org.eclipse.ecf.examples.sharedobject.objects;

import java.io.IOException;

import org.eclipse.ecf.core.identity.ID;

public interface IMessageSender
{
	public void sendMessage(ID targetID, Object message) throws IOException;
}
