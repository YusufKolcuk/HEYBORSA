package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NotFound;

@Entity
public class Verify {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String email;
	@Column(columnDefinition="varchar(255)")
	private String verify_key;
	private Date date;
	
	public Verify() {
		
	}
	
	public Verify(Long id, String email, String key, Date date) {

		this.id = id;
		this.email = email;
		this.verify_key = key;
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKey() {
		return verify_key;
	}
	public void setKey(String key) {
		this.verify_key = key;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
