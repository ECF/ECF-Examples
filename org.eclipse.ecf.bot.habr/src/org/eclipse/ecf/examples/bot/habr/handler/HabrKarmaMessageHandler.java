package org.eclipse.ecf.examples.bot.habr.handler;


import org.eclipse.ecf.examples.bot.habr.fetcher.HabraApiEntity;
import org.eclipse.ecf.presence.im.IChatMessage;

public class HabrKarmaMessageHandler extends HabrBasicMessageHandler
{
	private static final String COMMAND = "~karma";

	private static final String DATA_FOR_USER_FMT = "karma for user {0} is {1}";

	@Override
	public void handleIMMessage(IChatMessage message)
	{
		UserCommandMessage command = new UserCommandMessage(message.getBody());
		if (command == null)
			return;

		if (!COMMAND.equals(command.getCommand()))
			return;

		System.out.println(command);

		try
		{
			HabraApiEntity entry = getUserData(command.getUser());
			sendData(message.getFromID(), makeMessage(entry.getKarma(), command.getUser(), DATA_FOR_USER_FMT));
		}
		catch (Exception e)
		{
			sendData(message.getFromID(), e.getMessage());
		}
	}
}
