package com.heyborsa.dao;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.Doviz;
import com.heyborsa.financeapi.Moneys;

import antlr.collections.List;

@Repository
public class CurrencyDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long insert(Doviz doviz)
	{
		return (Long)sessionFactory.getCurrentSession().save(doviz);
	}
	
	public void insert(ArrayList<Doviz> doviz)
	{
		for(Doviz _doviz: doviz)
		{
			sessionFactory.getCurrentSession().save(_doviz);
		}
	}
	
	public Doviz read(String dovizType)
	{
	
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Doviz WHERE isim=EURO ORDER BY tarih DESC");
			
			return (Doviz) query.getSingleResult();
	}
}
