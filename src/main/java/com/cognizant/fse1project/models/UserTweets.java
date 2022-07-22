package com.cognizant.fse1project.models;

import java.util.List;

public class UserTweets {
	private List<Tweet> tweets;

	UserTweets() {
	}

	public UserTweets(List<Tweet> tweets) {
		super();
		this.tweets = tweets;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

}
