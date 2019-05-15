package com.heyborsa.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.Gold;

@Repository
public class GoldDAO {
	@Autowired 
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Gold> read()
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Gold"); 
		return (List<Gold>) query.getResultList();
	}
}
