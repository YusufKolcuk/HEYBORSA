package com.heyborsa.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.Kullanici;

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
	
	public Kullanici GetKullanici(String eposta,String sifre)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Kullanici WHERE eposta=:eposta AND sifre=:sifre")
				.setString("eposta", eposta)
				.setString("sifre",sifre);
		return (Kullanici) query.getSingleResult();
	}
}
