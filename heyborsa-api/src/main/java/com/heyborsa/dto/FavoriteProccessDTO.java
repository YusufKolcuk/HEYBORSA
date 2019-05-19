package com.heyborsa.dto;

public class FavoriteProccessDTO {
	private Long user_id;
	private String favorite_type;	
	private String favorite_data;
	private Long id;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	
	public FavoriteProccessDTO(Long user_id, String favorite_type, String favorite_data, Long id) {
		super();
		this.user_id = user_id;
		this.favorite_type = favorite_type;
		this.favorite_data = favorite_data;
		this.id = id;
	}
	
	public FavoriteProccessDTO()
	{
		
	}
}
