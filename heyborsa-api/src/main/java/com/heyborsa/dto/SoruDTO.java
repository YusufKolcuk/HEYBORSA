package com.heyborsa.dto;

public class SoruDTO {
	private int user_id;
	private String konu;
	private String baslik;
	private String icerik;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getKonu() {
		return konu;
	}
	public void setKonu(String konu) {
		this.konu = konu;
	}
	public String getBaslik() {
		return baslik;
	}
	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}
	public String getIcerik() {
		return icerik;
	}
	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
	public SoruDTO(int user_id, String konu, String baslik, String icerik) {
		super();
		this.user_id = user_id;
		this.konu = konu;
		this.baslik = baslik;
		this.icerik = icerik;
	}
	
	public SoruDTO()
	{
		
	}
	
	
}
