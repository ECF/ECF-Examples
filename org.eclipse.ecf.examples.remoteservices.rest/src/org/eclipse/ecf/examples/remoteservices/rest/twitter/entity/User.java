package org.eclipse.ecf.examples.remoteservices.rest.twitter.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("user")
public class User
{
	@XStreamAlias("id")
	private long _id;

	@XStreamAlias("name")
	private String _name;

	@XStreamAlias("screen_name")
	private String _login;

	@XStreamAlias("location")
	private String _location;

	@XStreamAlias("description")
	private String _description;

	@XStreamAlias("profile_image_url")
	private String _picUrl;

	@XStreamAlias("url")
	private String _url;

	@XStreamAlias("protected")
	private boolean _protected;

	@XStreamAlias("followers_count")
	private int _followersCount;

	@XStreamAlias("profile_background_color")
	private String _backgroundColor;

	@XStreamAlias("profile_text_color")
	private String _textColor;

	@XStreamAlias("profile_link_color")
	private String _linkColor;

	@XStreamAlias("profile_sidebar_fill_color")
	private String _sidebarColor;

	@XStreamAlias("profile_sidebar_border_color")
	private String _borderColor;

	@XStreamAlias("friends_count")
	private int _friendsCount;

	@XStreamAlias("created_at")
	private String _created;

	@XStreamAlias("favourites_count")
	private int _favouritesCount;

	@XStreamAlias("utc_offset")
	private long _utcOffset;

	@XStreamAlias("time_zone")
	private String _timeZone;

	@XStreamAlias("profile_use_background_image")
	private boolean _useBackgroundImage;
	
	@XStreamAlias("profile_background_image_url")
	private String _backgroundUrl;

	@XStreamAlias("profile_background_tile")
	private String _backgroundTitle;

	@XStreamAlias("notifications")
	private String _notifications;

	@XStreamAlias("geo_enabled")
	private boolean _geo;

	@XStreamAlias("verified")
	private boolean _verified;

	@XStreamAlias("following")
	private String _folowing;

	@XStreamAlias("statuses_count")
	private int _statusesCount;

	@XStreamAlias("status")
	private Status _status;
	
	@XStreamAlias("lang")
	private String _lang;
	
	@XStreamAlias("contributors_enabled")
	private boolean _contributorsEnabled;
	
	@XStreamAlias("follow_request_sent")
	private boolean _followRequestSent;
	
	@XStreamAlias("listed_count")
	private int _listedCount;
	
	@XStreamAlias("show_all_inline_media")
	private boolean _showAllInlineMedia;

	public User() {}

	public Long getId()
	{
		return _id;
	}

	public String getName()
	{
		return _name;
	}

	public String getLogin()
	{
		return _login;
	}

	public String getLocation()
	{
		return _location;
	}

	public String getDescription()
	{
		return _description;
	}

	public String getPicUrl()
	{
		return _picUrl;
	}

	public String getUrl()
	{
		return _url;
	}

	public boolean isProtected()
	{
		return _protected;
	}

	public int getFollowersCount()
	{
		return _followersCount;
	}

	public String getBackgroundColor()
	{
		return _backgroundColor;
	}

	public String getTextColor()
	{
		return _textColor;
	}

	public String getLinkColor()
	{
		return _linkColor;
	}

	public String getSidebarColor()
	{
		return _sidebarColor;
	}

	public String getBorderColor()
	{
		return _borderColor;
	}

	public int getFriendsCount()
	{
		return _friendsCount;
	}

	public String getCreated()
	{
		return _created;
	}

	public int getFavouritesCount()
	{
		return _favouritesCount;
	}

	public long getUtcOffset()
	{
		return _utcOffset;
	}

	public String getTimeZone()
	{
		return _timeZone;
	}

	public String getBackgroundUrl()
	{
		return _backgroundUrl;
	}

	public String getBackgroundTitle()
	{
		return _backgroundTitle;
	}

	public String getNotifications()
	{
		return _notifications;
	}

	public boolean isGeo()
	{
		return _geo;
	}

	public boolean isVerified()
	{
		return _verified;
	}

	public String getFolowing()
	{
		return _folowing;
	}

	public int getStatusesCount()
	{
		return _statusesCount;
	}

	public Status getStatus()
	{
		return _status;
	}

	public boolean isUseBackgroundImage() 
	{
		return _useBackgroundImage;
	}

	public void setUseBackgroundImage(boolean useBackgroundImage) 
	{
		_useBackgroundImage = useBackgroundImage;
	}

	public String getLang() 
	{
		return _lang;
	}

	public void setLang(String lang) 
	{
		_lang = lang;
	}

	public boolean isContributorsEnabled() 
	{
		return _contributorsEnabled;
	}

	public void setContributorsEnabled(boolean contributorsEnabled) 
	{
		_contributorsEnabled = contributorsEnabled;
	}

	public boolean isFollowRequestSent() 
	{
		return _followRequestSent;
	}

	public void setFollowRequestSent(boolean followRequestSent) 
	{
		_followRequestSent = followRequestSent;
	}

	public int getListedCount() 
	{
		return _listedCount;
	}

	public void setListedCount(int listedCount) 
	{
		_listedCount = listedCount;
	}

	public boolean isShowAllInlineMedia() 
	{
		return _showAllInlineMedia;
	}

	public void setShowAllInlineMedia(boolean showAllInlineMedia) 
	{
		_showAllInlineMedia = showAllInlineMedia;
	}	
}
