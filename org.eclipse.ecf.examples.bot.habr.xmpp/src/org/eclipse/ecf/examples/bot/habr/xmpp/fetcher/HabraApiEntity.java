package org.eclipse.ecf.examples.bot.habr.xmpp.fetcher;

public class HabraApiEntity
{
	private String _karma;

	private String _power;

	private String _position;

	public HabraApiEntity() {}

	public HabraApiEntity(String karma, String power, String position)
	{
		_karma = karma;
		_position = position;
		_power = power;
	}

	public String getKarma()
	{
		return _karma;
	}

	public void setKarma(String karma)
	{
		_karma = karma;
	}

	public String getPower()
	{
		return _power;
	}

	public void setPower(String power)
	{
		_power = power;
	}

	public String getPosition()
	{
		return _position;
	}

	public void setPosition(String position)
	{
		_position = position;
	}
}
