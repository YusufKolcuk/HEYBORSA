package com.heyborsa.dao;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.Kullanici;
import com.heyborsa.entity.Sorular;
import com.heyborsa.helper.Encryption;



@Repository
public class SorularDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long insert(Sorular sorular)
	{
		return (Long)sessionFactory.getCurrentSession().save(sorular);
	}
	
	
	public void Update(Sorular sorular)
	{
		sessionFactory.getCurrentSession().update(sorular);
	}
	
	public void Delete(Sorular sorular)
	{
		sessionFactory.getCurrentSession().delete(sorular);
	}
	
	public List<Sorular> ReadByUserId (int id) {
		List<Sorular> soru = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Sorular WHERE kullaniciid=:id").setInteger("id",id);
			soru = (List<Sorular>) query.getResultList();
			return soru;
		}
		catch(NoResultException e)
		{
			return (List<Sorular>)soru;
		}
	}
	
	public Sorular ReadByQuestionId (int id) {
		Sorular soru = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Sorular WHERE id=:id").setInteger("id",id);
			soru = (Sorular) query.getSingleResult();
			return soru;
		}
		catch(NoResultException e)
		{
			return (Sorular)soru;
		}
	}
	
	

}
