package org.eclipse.ecf.examples.sharedobject.oscar.objects.xstream;

import java.io.IOException;

import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.sharedobject.util.ISharedObjectMessageSerializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamSOMessageSerializer implements ISharedObjectMessageSerializer
{
	private XStream _stream;

	public XStreamSOMessageSerializer()
	{
		_stream = new XStream(new DomDriver());
	}

	public Object deserializeMessage(byte[] data) throws IOException, ClassNotFoundException
	{
		System.out.println("deserialize data = " + new String(data));
		return _stream.fromXML(new String(data));
	}

	public byte[] serializeMessage(ID sharedObjectID, Object message) throws IOException
	{
		System.out.println("serialize message = " + message);
		return _stream.toXML(message).getBytes();
	}
}
