package com.heyborsa.dto;

public class ValidateQuestionDTO {
	private Long question_id;
	private Long user_id;
	public Long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public ValidateQuestionDTO(Long question_id, Long user_id) {
		this.question_id = question_id;
		this.user_id = user_id;
	}
	
	public ValidateQuestionDTO() {
		
	}
}
