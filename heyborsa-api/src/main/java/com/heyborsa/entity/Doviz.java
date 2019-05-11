package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doviz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String isim;
	private float alis_deger;
	private float satis_deger;
	private String tarih;
	
	public Doviz(Long id, String isim, float alis_deger, float satis_deger, String tarih) {
		this.id = id;
		this.isim = isim;
		this.alis_deger = alis_deger;
		this.satis_deger = satis_deger;
		this.tarih = tarih;
	}
	public Doviz() {
		
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
	public float getAlis_deger() {
		return alis_deger;
	}
	public void setAlis_deger(float alis_deger) {
		this.alis_deger = alis_deger;
	}
	public float getSatis_deger() {
		return satis_deger;
	}
	public void setSatis_deger(float satis_deger) {
		this.satis_deger = satis_deger;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
}
