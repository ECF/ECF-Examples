package org.eclipse.ecf.examples.bot.habr.xmpp.fetcher.parser;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.eclipse.ecf.examples.bot.habr.xmpp.fetcher.HabraApiEntity;
import org.eclipse.ecf.examples.bot.habr.xmpp.fetcher.exceptions.GetInfoException;
import org.eclipse.ecf.examples.bot.habr.xmpp.fetcher.exceptions.UserNotFoundException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HabraApiParser
{
	private static final String RATING_POSITION_TAG = "ratingPosition";
	private static final String RATING_TAG = "rating";
	private static final String KARMA_TAG = "karma";
	private static final String USER_NOT_FOUND_CODE = "404";
	private static final String ERROR_TAG = "error";

	public HabraApiEntity parseEntity(String data, String user) throws UserNotFoundException, GetInfoException
	{
		return createEntity(getDocument(data), user);
	}

	private Document getDocument(String data) throws GetInfoException
	{
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			return db.parse(new ByteArrayInputStream(data.trim().getBytes()));
		}
		catch (Exception e)
		{
			throw new GetInfoException(e);
		}
	}

	private HabraApiEntity createEntity(Document document, String user) throws UserNotFoundException, GetInfoException
	{
		Element root = document.getDocumentElement();

		// Errors checking
		NodeList errors = root.getElementsByTagName(ERROR_TAG);
		if (errors != null && errors.getLength() > 0)
		{
			for (int i = 0; i < errors.getLength(); i++)
			{
				Element el = (Element) errors.item(i);
				if (USER_NOT_FOUND_CODE.equals(el.getTextContent()))
					throw new UserNotFoundException(user);
			}

			throw new GetInfoException();
		}

		// Get info about karma, rating, ratingPosition
		NodeList data = root.getChildNodes();
		if (data != null)
		{
			HabraApiEntity entry = new HabraApiEntity();
			for (int i = 0; i < data.getLength(); i++)
			{
				Node node = data.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					if (KARMA_TAG.equals(node.getNodeName()))
						entry.setKarma(node.getTextContent());
					if (RATING_TAG.equals(node.getNodeName()))
						entry.setPower(node.getTextContent());
					if (RATING_POSITION_TAG.equals(node.getNodeName()))
						entry.setPosition(node.getTextContent());
				}
			}

			return entry;
		}

		return null;
	}
}
