package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kullanici {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String isim;
	private String soyisim;
	private String eposta;
	private String sifre;
	private String telefon;
	private Date tarih;
	private boolean aktif;
	private int kullanici_tip;
	public Kullanici(Long id, String isim, String soyisim, String eposta, String sifre, String telefon, Date tarih,
			boolean aktif, int kullanici_tip) {
		super();
		this.id = id;
		this.isim = isim;
		this.soyisim = soyisim;
		this.eposta = eposta;
		this.sifre = sifre;
		this.telefon = telefon;
		this.tarih = tarih;
		this.aktif = aktif;
		this.kullanici_tip = kullanici_tip;
	}
	public Kullanici() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	public boolean isAktif() {
		return aktif;
	}
	public void setAktif(boolean aktif) {
		this.aktif = aktif;
	}
	public int getKullanici_tip() {
		return kullanici_tip;
	}
	public void setKullanici_tip(int kullanici_tip) {
		this.kullanici_tip = kullanici_tip;
	}
	
	
	
}
