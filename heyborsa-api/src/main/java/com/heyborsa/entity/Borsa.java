package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Borsa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String isim;
	private int deger;
	private int hacim;
	private Date tarih;
	
	
	
	public Borsa(Long id, String isim, int deger, int hacim, Date tarih) {
		this.id = id;
		this.isim = isim;
		this.deger = deger;
		this.hacim = hacim;
		this.tarih = tarih;
	}
	public Borsa() {
		
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
	public int getDeger() {
		return deger;
	}
	public void setDeger(int deger) {
		this.deger = deger;
	}
	public int getHacim() {
		return hacim;
	}
	public void setHacim(int hacim) {
		this.hacim = hacim;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
	
}
