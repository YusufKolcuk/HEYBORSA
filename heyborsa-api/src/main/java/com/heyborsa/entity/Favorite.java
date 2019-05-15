package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Favorite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String favorite_type;
	private String favorite_data;
	private Long user_id;
	private Date created_time;
	
	public Favorite(Long id, String favorite_type, String favorite_data, Long user_id, Date created_time) {
		super();
		this.id = id;
		this.favorite_type = favorite_type;
		this.favorite_data = favorite_data;
		this.user_id = user_id;
		this.created_time = created_time;
	}
	
	public Favorite()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFavorite_type() {
		return favorite_type;
	}

	public void setFavorite_type(String favorite_type) {
		this.favorite_type = favorite_type;
	}

	public String getFavorite_data() {
		return favorite_data;
	}

	public void setFavorite_data(String favorite_data) {
		this.favorite_data = favorite_data;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	
}
