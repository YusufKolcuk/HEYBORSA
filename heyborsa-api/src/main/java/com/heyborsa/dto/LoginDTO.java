package com.heyborsa.dto;

public class LoginDTO{
	private String eposta;
	private String parola;
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	
	public LoginDTO(String eposta, String parola) {
		super();
		this.eposta = eposta;
		this.parola = parola;
	}
	
	
	public LoginDTO()
	{
		
	}
	
}
