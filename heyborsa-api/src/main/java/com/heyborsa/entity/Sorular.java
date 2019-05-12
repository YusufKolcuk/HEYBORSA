package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Sorular {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long kullaniciid;
	private Date tarih;
	private String konu;
	private String baslik;
	private String icerik;
	private String durum;
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(long kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
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
	public Sorular(long id, long kullaniciid, Date tarih, String konu, String baslik, String icerik,String durum) {
		super();
		this.id = id;
		this.kullaniciid = kullaniciid;
		this.tarih = tarih;
		this.konu = konu;
		this.baslik = baslik;
		this.icerik = icerik;
		this.durum = durum;
	}
	
	public Sorular()
	{
		
	}

}
