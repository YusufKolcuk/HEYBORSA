package com.heyborsa.dto;

public class AnswerDTO {
	private long question_id;
	private String message;
	public AnswerDTO(long question_id, String message) {
		super();
		this.question_id = question_id;
		this.message = message;
	}
	
	public AnswerDTO()
	{
		
	}
	
	public long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
