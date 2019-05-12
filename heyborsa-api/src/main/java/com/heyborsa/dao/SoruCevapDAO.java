package com.heyborsa.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.SoruCevap;

@Repository
public class SoruCevapDAO {
	@Autowired
	SessionFactory sessionFactory;
	public Long insert(SoruCevap soruCevap)
	{
		return (Long) sessionFactory.getCurrentSession().save(soruCevap);
	}
	
	public void delete(SoruCevap soruCevap)
	{
		sessionFactory.getCurrentSession().delete(soruCevap);
	}
	
	public SoruCevap read(int id)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM SoruCevap WHERE id=:id").setInteger("id", id);
		return (SoruCevap) query.getSingleResult();
	}
	
	public List<SoruCevap> readByQuestionId(int id)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM SoruCevap WHERE soru_id=:soru_id").setInteger("soru_id", id);
		return (List<SoruCevap>) query.getResultList();
	}
	
}
