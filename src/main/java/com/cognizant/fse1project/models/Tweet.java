package com.cognizant.fse1project.models;

import java.time.LocalDateTime;
import java.util.Set;

public class Tweet {

	private String tid;
	private String tweet;
	private LocalDateTime created;
	private boolean like;
	private Set<Reply> replies;

	public Tweet() {
	}

	public Tweet(String tid, String tweet, LocalDateTime created, boolean like, Set<Reply> replies) {
		super();
		this.tid = tid;
		this.tweet = tweet;
		this.created = created;
		this.like = like;
		this.replies = replies;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Tweet [tid=" + tid + ", tweet=" + tweet + ", created=" + created + ", like=" + like + ", replies="
				+ replies + "]";
	}

}
