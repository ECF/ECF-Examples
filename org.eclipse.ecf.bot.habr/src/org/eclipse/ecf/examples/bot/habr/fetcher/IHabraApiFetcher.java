package org.eclipse.ecf.examples.bot.habr.fetcher;

import org.eclipse.ecf.examples.bot.habr.fetcher.exceptions.GetInfoException;
import org.eclipse.ecf.examples.bot.habr.fetcher.exceptions.UserNotFoundException;

public interface IHabraApiFetcher
{
	public HabraApiEntity fetch(String user) throws GetInfoException, UserNotFoundException;
}
