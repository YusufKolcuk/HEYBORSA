package com.heyborsa.dao;

import java.util.ArrayList;


import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.Currency;


@Repository
public class CurrencyDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long insert(Currency currency)
	{
		return (Long)sessionFactory.getCurrentSession().save(currency);
	}
	
	public void insert(ArrayList<Currency> currency)
	{
		for(Currency _currency: currency)
		{
			sessionFactory.getCurrentSession().save(_currency);
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public Currency read(String currencyType)
	{
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Currency WHERE name=:name ORDER BY date DESC")
					.setString("name",currencyType);
			return (Currency) query.getSingleResult();
	}
}
