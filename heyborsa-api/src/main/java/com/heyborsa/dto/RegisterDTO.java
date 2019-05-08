package com.heyborsa.dto;

public class RegisterDTO {
	private String isim;
	private String soyisim;
	private String eposta;
	private String parola;
	private String telefon;
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getSoyisim() {
		return soyisim;
	}
	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}
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
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public RegisterDTO(String isim, String soyisim, String eposta, String parola, String telefon) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.eposta = eposta;
		this.parola = parola;
		this.telefon = telefon;
	}
	
	public RegisterDTO()
	{
		
	}
}
