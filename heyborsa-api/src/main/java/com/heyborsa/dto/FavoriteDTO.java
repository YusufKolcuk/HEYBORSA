package com.heyborsa.dto;

public class FavoriteDTO {
	
	private int user_id;
	private String favorite_type;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFavorite_type() {
		return favorite_type;
	}
	public void setFavorite_type(String favorite_type) {
		this.favorite_type = favorite_type;
	}
	public FavoriteDTO(int user_id, String favorite_type) {
		super();
		this.user_id = user_id;
		this.favorite_type = favorite_type;
	}
	
	public FavoriteDTO()
	{
		
	}
}
