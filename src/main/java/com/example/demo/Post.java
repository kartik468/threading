package com.example.demo;

import java.io.Serializable;

public class Post implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1179248758555748149L;
	
	private int userId;
	private int id;
    private String title;
    private String body;
    
    
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Post [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
}