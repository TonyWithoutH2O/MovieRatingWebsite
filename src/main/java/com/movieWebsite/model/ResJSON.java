package com.movieWebsite.model;

public class ResJSON {
	private int status;
	private String message;
	
	public ResJSON() {
		super();
	}
	
	public ResJSON(int status) {
		super();
		this.status = status;
	}

	public ResJSON(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "User [status=" + status + ", message=" + message + "]";
	}
}
