package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long question_id;
	private String answer;
	private Date date;
	private Long fu_id; // fu = finans uzmaný
	

	public Answer()
	{
		
	}
	
	public Answer(Long id, Long question_id, String answer, Date date, Long fu_id) {
		super();
		this.id = id;
		this.question_id = question_id;
		this.answer = answer;
		this.date = date;
		this.fu_id = fu_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Long getFu_id() {
		return fu_id;
	}

	public void setFu_id(Long fu_id) {
		this.fu_id = fu_id;
	}

	
	
}
