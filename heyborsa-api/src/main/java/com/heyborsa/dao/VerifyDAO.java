package com.heyborsa.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.Verify;

@Repository
public class VerifyDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long insert(Verify verify)
	{
		return (Long) sessionFactory.getCurrentSession().save(verify);
	}
	
	public Verify getByEmail(String email)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Verify WHERE email=:email")
				.setString("email", email);
		return (Verify) query.getSingleResult();
	}
	
	public Verify getByKey(String key)
	{
		Verify verify = null;
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Verify WHERE verify_key=:key")
				.setString("key", key);
		try {
			verify = (Verify) query.getSingleResult();
			return verify;
		}catch(NoResultException e)
		{
			e.printStackTrace();
			return verify;
		}
	}
	
	public void Delete(Verify verify)
	{
		sessionFactory.getCurrentSession().delete(verify);
	}
}
