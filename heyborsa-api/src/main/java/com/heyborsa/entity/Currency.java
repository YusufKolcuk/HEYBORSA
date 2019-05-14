package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private float buying_price;
	private float selling_price;
	private Date date;
	
	
	
	public Currency(Long id, String name, float buying_price, float selling_price, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.buying_price = buying_price;
		this.selling_price = selling_price;
		this.date = date;
	}

	public Currency() {
		
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



	public float getBuying_price() {
		return buying_price;
	}



	public void setBuying_price(float buying_price) {
		this.buying_price = buying_price;
	}



	public float getSelling_price() {
		return selling_price;
	}



	public void setSelling_price(float selling_price) {
		this.selling_price = selling_price;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}

}
