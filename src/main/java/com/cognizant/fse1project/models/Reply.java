package com.cognizant.fse1project.models;

public class Reply {

	private String rid;  //replier id
	private String reply;

	public Reply() {
	}

	public Reply(String rid, String reply) {
		super();
		this.rid = rid;
		this.reply = reply;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", reply=" + reply + "]";
	}

}
