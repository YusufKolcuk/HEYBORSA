package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Altin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String isim;
	private int alis_deger;
	private int satis_deger;
	private Date tarih;
	public Altin(Long id, String isim, int alis_deger, int satis_deger, Date tarih) {
		this.id = id;
		this.isim = isim;
		this.alis_deger = alis_deger;
		this.satis_deger = satis_deger;
		this.tarih = tarih;
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
	public int getAlis_deger() {
		return alis_deger;
	}
	public void setAlis_deger(int alis_deger) {
		this.alis_deger = alis_deger;
	}
	public int getSatis_deger() {
		return satis_deger;
	}
	public void setSatis_deger(int satis_deger) {
		this.satis_deger = satis_deger;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
	
	
}
