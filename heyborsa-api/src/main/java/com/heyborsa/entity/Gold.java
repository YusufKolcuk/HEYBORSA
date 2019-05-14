package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gold {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int buying_price;
	private int selling_price;
	private Date date;
	
	
	public Gold() {
		
	}

	
	public Gold(Long id, String name, int buying_price, int selling_price, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.buying_price = buying_price;
		this.selling_price = selling_price;
		this.date = date;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getBuying_price() {
		return buying_price;
	}


	public void setBuying_price(int buying_price) {
		this.buying_price = buying_price;
	}


	public int getSelling_price() {
		return selling_price;
	}


	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
