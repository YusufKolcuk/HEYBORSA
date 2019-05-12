package com.heyborsa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SoruCevap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long soru_id;
	private String cevap;
	private Date tarih;
	private Long fu_id; // fu = finans uzmaný
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSoru_id() {
		return soru_id;
	}

	public void setSoru_id(Long soru_id) {
		this.soru_id = soru_id;
	}

	public String getCevap() {
		return cevap;
	}

	public void setCevap(String cevap) {
		this.cevap = cevap;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public Long getFu_id() {
		return fu_id;
	}

	public void setFu_id(Long fu_id) {
		this.fu_id = fu_id;
	}

	public SoruCevap(Long id, Long soru_id, String cevap, Date tarih, Long fu_id) {
		this.id = id;
		this.soru_id = soru_id;
		this.cevap = cevap;
		this.tarih = tarih;
		this.fu_id = fu_id;
	}
	
	public SoruCevap()
	{
		
	}
	
	
}
