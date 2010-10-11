package org.eclipse.ecf.examples.bot.habr.xmpp.fetcher;

import org.eclipse.ecf.examples.bot.habr.xmpp.fetcher.exceptions.GetInfoException;
import org.eclipse.ecf.examples.bot.habr.xmpp.fetcher.exceptions.UserNotFoundException;

public interface IHabraApiFetcher
{
	public HabraApiEntity fetch(String user) throws GetInfoException, UserNotFoundException;
}
