package org.eclipse.ecf.examples.remoteservices.rest.processor;

import java.io.NotSerializableException;
import java.util.Map;


import org.eclipse.ecf.examples.remoteservices.rest.twitter.entity.Status;
import org.eclipse.ecf.examples.remoteservices.rest.twitter.entity.User;
import org.eclipse.ecf.remoteservice.IRemoteCall;
import org.eclipse.ecf.remoteservice.client.IRemoteCallable;
import org.eclipse.ecf.remoteservice.client.IRemoteResponseDeserializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;

public class XStreamResponseDeserializer implements IRemoteResponseDeserializer
{
	private XStream _stream;

	public XStreamResponseDeserializer()
	{
		_stream = new XStream();
		Annotations.configureAliases(_stream, User.class);
		Annotations.configureAliases(_stream, Status.class);
	}

	@Override
	@SuppressWarnings("rawtypes")	
	public Object deserializeResponse(String endpoint, IRemoteCall call,
			IRemoteCallable callable, Map responseHeaders, String responseBody)
				throws NotSerializableException 
	{
		return _stream.fromXML(responseBody);
	}
}
