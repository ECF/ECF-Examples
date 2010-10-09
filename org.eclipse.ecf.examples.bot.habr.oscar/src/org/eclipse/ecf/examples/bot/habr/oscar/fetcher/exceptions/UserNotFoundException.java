package org.eclipse.ecf.examples.bot.habr.oscar.fetcher.exceptions;

import java.text.MessageFormat;

public class UserNotFoundException extends Exception
{
	private static final long serialVersionUID = -1240100554537716266L;

	private static final String USER_NOT_FOUND_FMT = "User {0} not found on HabraHabr";

	public UserNotFoundException(String user)
	{
		super(MessageFormat.format(USER_NOT_FOUND_FMT, user));
	}
}
