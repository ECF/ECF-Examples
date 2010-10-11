package org.eclipse.ecf.examples.bot.habr.fetcher;

import java.io.IOException;
import java.text.MessageFormat;

import org.eclipse.ecf.examples.bot.habr.fetcher.exceptions.GetInfoException;
import org.eclipse.ecf.examples.bot.habr.fetcher.exceptions.UserNotFoundException;
import org.eclipse.ecf.examples.bot.habr.fetcher.parser.HabraApiParser;


public abstract class BasicHabraApiFetcher implements IHabraApiFetcher
{
	private static final String API_URL_FMT = "http://habrahabr.ru/api/profile/{0}/";

	protected String getUrl(String user)
	{
		return MessageFormat.format(API_URL_FMT, user);
	}

	@Override
 	public HabraApiEntity fetch(String user) throws GetInfoException, UserNotFoundException
 	{
		try
		{
			return new HabraApiParser().parseEntity(fetchDataFromServer(getUrl(user)), user);
		}
		catch (UserNotFoundException e) {
			throw e;
		}
		catch (GetInfoException e) {
			throw e;
		}
		catch (Exception e)
		{
			throw new GetInfoException(e);
		}
	}

	protected abstract String fetchDataFromServer(String from) throws IOException;
}
