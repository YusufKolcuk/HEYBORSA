package com.heyborsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyborsa.dao.KullaniciDAO;
import com.heyborsa.entity.Kullanici;

@Service
public class KullaniciService {
	@Autowired
	KullaniciDAO kullaniciDAO;
	
	public Long insert(Kullanici kullanici)
	{
		return kullaniciDAO.insert(kullanici);
	}
}
