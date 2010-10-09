package org.eclipse.ecf.examples.bot.habr.oscar.fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.ecf.examples.bot.habr.oscar.fetcher.exceptions.GetInfoException;
import org.eclipse.ecf.examples.bot.habr.oscar.fetcher.exceptions.UserNotFoundException;
import org.eclipse.ecf.examples.bot.habr.oscar.fetcher.parser.HabraApiParser;


public class UrlClientHabraApiFetcher extends BasicHabraApiFetcher
{
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

	protected String fetchDataFromServer(String from) throws IOException
	{
		URL url = new URL(from);
        URLConnection uc = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[512];
        while (reader.read(buffer) != -1)
        	builder.append(buffer);

        return builder.toString();
	}
}
