package com.heyborsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.KullaniciDAO;
import com.heyborsa.entity.Kullanici;

@Service
@Transactional
public class KullaniciService {
	@Autowired
	KullaniciDAO kullaniciDAO;
	
	public Long kayit(Kullanici kullanici)
	{
		return kullaniciDAO.insert(kullanici);
	}
	
	public Kullanici getUserById(int id)
	{
		return kullaniciDAO.GetKullanici(id);
	}
	public Kullanici giris(String eposta,String parola) {
		return kullaniciDAO.Giris(eposta,parola);
	}
}
