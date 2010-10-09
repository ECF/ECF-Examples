package org.eclipse.ecf.examples.bot.habr.oscar.handler;

public class UserCommandMessage
{
	private String command;

	private String user;

	public UserCommandMessage(String data)
	{
		String[] strings = data.split(" ");
		if (strings == null || strings.length < 2)
			throw new IllegalStateException();

		setCommand(strings[0].trim());
		setUser(strings[1].trim());
	}

	public String getCommand()
	{
		return command;
	}

	public void setCommand(String command)
	{
		this.command = command;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	@Override
	public String toString()
	{
		return "command = " + getCommand() + ", user = " + getUser();
	}
}
