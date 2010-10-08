package org.eclipse.ecf.examples.bot.habr.handler;

import java.text.MessageFormat;


import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.util.ECFException;
import org.eclipse.ecf.examples.bot.habr.fetcher.HabraApiEntity;
import org.eclipse.ecf.examples.bot.habr.fetcher.IHabraApiFetcher;
import org.eclipse.ecf.examples.bot.habr.fetcher.UrlClientHabraApiFetcher;
import org.eclipse.ecf.examples.bot.habr.fetcher.exceptions.GetInfoException;
import org.eclipse.ecf.examples.bot.habr.fetcher.exceptions.UserNotFoundException;
import org.eclipse.ecf.presence.IPresenceContainerAdapter;
import org.eclipse.ecf.presence.bot.IIMBotEntry;
import org.eclipse.ecf.presence.bot.IIMMessageHandler;
import org.eclipse.ecf.presence.im.IChatManager;

public abstract class HabrBasicMessageHandler implements IIMMessageHandler
{
	private IChatManager _chat;

	protected String makeMessage(String karma, String user, String fmt)
	{
		return MessageFormat.format(fmt, user, karma);
	}

	protected void sendData(ID toId, String data)
	{
		try
		{
			_chat.getChatMessageSender().sendChatMessage(toId, data);
		}
		catch (ECFException e)
		{
			e.printStackTrace();
		}
	}

	protected HabraApiEntity getUserData(String user) throws GetInfoException, UserNotFoundException
	{
		IHabraApiFetcher fetcher = new UrlClientHabraApiFetcher();
		return fetcher.fetch(user);
	}

	@Override
	public void init(IIMBotEntry robot)
	{
	}

	@Override
	public void preContainerConnect(IContainer container, ID targetID)
	{
		IPresenceContainerAdapter adapter = (IPresenceContainerAdapter) container
			.getAdapter(IPresenceContainerAdapter.class);

		_chat = adapter.getChatManager();
	}
}
