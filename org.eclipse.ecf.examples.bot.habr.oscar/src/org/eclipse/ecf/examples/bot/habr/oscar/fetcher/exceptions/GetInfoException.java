package org.eclipse.ecf.examples.bot.habr.oscar.fetcher.exceptions;

public class GetInfoException extends Exception
{
	private static final long serialVersionUID = 2408901734431651263L;

	private static final String COULD_NOT_GET_USER_INFO = "Could not get user info";

	public GetInfoException()
	{
		super(COULD_NOT_GET_USER_INFO);
	}

	public GetInfoException(Throwable t)
	{
		super(COULD_NOT_GET_USER_INFO, t);
	}
}
