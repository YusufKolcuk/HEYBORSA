package com.heyborsa.dto;

public class QuestionDTO {
	private int user_id;
	private String subject;
	private String header;
	private String content;
	
	
	
	public QuestionDTO(int user_id, String subject, String header, String content) {
		super();
		this.user_id = user_id;
		this.subject = subject;
		this.header = header;
		this.content = content;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getHeader() {
		return header;
	}



	public void setHeader(String header) {
		this.header = header;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public QuestionDTO()
	{
		
	}
	
	
}
