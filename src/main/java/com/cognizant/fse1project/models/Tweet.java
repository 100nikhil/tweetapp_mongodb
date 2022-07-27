package com.cognizant.fse1project.models;

import java.time.LocalDateTime;
import java.util.Set;

public class Tweet {

	private String tid;
	private String email;
	private String tweet;
	private LocalDateTime created;
	private Set<String> likes;
	private Set<Reply> replies;

	public Tweet() {
	}

	public Tweet(String tid, String email, String tweet, LocalDateTime created, Set<String> likes, Set<Reply> replies) {
		super();
		this.tid = tid;
		this.email = email;
		this.tweet = tweet;
		this.created = created;
		this.likes = likes;
		this.replies = replies;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<String> getLikes() {
		return likes;
	}

	public void setLikes(Set<String> likes) {
		this.likes = likes;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Tweet [tid=" + tid + ", email=" + email + ", tweet=" + tweet + ", created=" + created + ", likes="
				+ likes + ", replies=" + replies + "]";
	}

}
