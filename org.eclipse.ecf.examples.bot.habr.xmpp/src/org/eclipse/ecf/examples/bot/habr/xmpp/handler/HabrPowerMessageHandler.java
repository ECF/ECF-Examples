package org.eclipse.ecf.examples.bot.habr.xmpp.handler;


import org.eclipse.ecf.examples.bot.habr.xmpp.fetcher.HabraApiEntity;
import org.eclipse.ecf.presence.im.IChatMessage;

public class HabrPowerMessageHandler extends HabrBasicMessageHandler
{
	private static final String COMMAND = "~power";

	private static final String DATA_FOR_USER_FMT = "habrapower for user {0} is {1}";

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
			sendData(message.getFromID(), makeMessage(entry.getPower(), command.getUser(), DATA_FOR_USER_FMT));
		}
		catch (Exception e)
		{
			sendData(message.getFromID(), e.getMessage());
		}
	}
}
