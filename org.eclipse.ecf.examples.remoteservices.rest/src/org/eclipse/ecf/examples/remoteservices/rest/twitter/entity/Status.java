package org.eclipse.ecf.examples.remoteservices.rest.twitter.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("status")
public class Status
{
	@XStreamAlias("id")
	private long _id;

	@XStreamAlias("created_at")
	private String _created;

	@XStreamAlias("text")
	private String _text;

	@XStreamAlias("source")
	private String _source;

	@XStreamAlias("truncated")
	private boolean _truncated;

	@XStreamAlias("in_reply_to_status_id")
	private String _replyToStatusId;

	@XStreamAlias("in_reply_to_user_id")
	private String _replyToUserId;

	@XStreamAlias("in_reply_to_screen_name")
	private String _replyTo;

	@XStreamAlias("favorited")
	private boolean _favorited;

	@XStreamAlias("geo")
	private String _geo;
	
	@XStreamAlias("coordinates")
	private String _coordinates;
	
	@XStreamAlias("place")
	private String _place;
	
	@XStreamAlias("contributors")
	private String _contributors;

	public Status() {}

	public long getId()
	{
		return _id;
	}

	public String getCreated()
	{
		return _created;
	}

	public String getText()
	{
		return _text;
	}

	public String getSource()
	{
		return _source;
	}

	public boolean isTruncated()
	{
		return _truncated;
	}

	public String getReplyToStatusId()
	{
		return _replyToStatusId;
	}

	public String getReplyToUserId()
	{
		return _replyToUserId;
	}

	public String getReplyTo()
	{
		return _replyTo;
	}

	public boolean isFavorited()
	{
		return _favorited;
	}

	public String getGeo()
	{
		return _geo;
	}

	public String getCoordinates() 
	{
		return _coordinates;
	}

	public void setCoordinates(String coordinates) 
	{
		_coordinates = coordinates;
	}

	public String getPlace() 
	{
		return _place;
	}

	public void setPlace(String place) 
	{
		_place = place;
	}

	public String getContributors() 
	{
		return _contributors;
	}

	public void setContributors(String contributors) 
	{
		_contributors = contributors;
	}	
}
