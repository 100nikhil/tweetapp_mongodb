package com.cognizant.fse1project.models;

public class Reply {

	private String email;
	private String reply;

	public Reply() {
	}

	public Reply(String email, String reply) {
		super();
		this.email = email;
		this.reply = reply;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "Reply [email=" + email + ", reply=" + reply + "]";
	}

}
