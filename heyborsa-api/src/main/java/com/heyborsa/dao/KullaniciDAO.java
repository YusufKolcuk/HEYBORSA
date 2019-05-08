package com.heyborsa.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.Kullanici;
import com.heyborsa.helper.Encryption;

@Repository
public class KullaniciDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long insert(Kullanici kullanici)
	{
		return (Long)sessionFactory.getCurrentSession().save(kullanici);
	}
	
	public void Update(Kullanici kullanici)
	{
		sessionFactory.getCurrentSession().update(kullanici);
	}
	
	public void Delete(Kullanici kullanici)
	{
		sessionFactory.getCurrentSession().delete(kullanici);
	}
	
	
	public Kullanici GetKullanici(int id)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Kullanici WHERE id=:id")
				.setInteger("id", id);
		return (Kullanici) query.getSingleResult();
	}
	
	public Kullanici Giris(String eposta,String sifre)
	{
		sifre = Encryption.sha256(sifre);
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Kullanici WHERE eposta=:eposta AND sifre=:sifre")
				.setString("eposta", eposta)
				.setString("sifre",sifre);
		Kullanici kullanici = null;
		try {
			kullanici = (Kullanici) query.getSingleResult();
			kullanici.setSifre(null);
			System.out.println("CEVAP VERÝLDÝ");
			return kullanici;
		}catch(javax.persistence.NoResultException e)
		{
			System.out.println("CEVAP VERÝLDÝ");
			return kullanici;
		}
	}
}
