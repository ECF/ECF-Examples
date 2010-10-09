package org.eclipse.ecf.examples.bot.habr.oscar.fetcher;

import org.eclipse.ecf.examples.bot.habr.oscar.fetcher.exceptions.GetInfoException;
import org.eclipse.ecf.examples.bot.habr.oscar.fetcher.exceptions.UserNotFoundException;

public interface IHabraApiFetcher
{
	public HabraApiEntity fetch(String user) throws GetInfoException, UserNotFoundException;
}
