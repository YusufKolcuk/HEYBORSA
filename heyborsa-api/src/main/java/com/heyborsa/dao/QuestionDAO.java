package com.heyborsa.dao;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.heyborsa.entity.Question;



@Repository
public class QuestionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long insert(Question sorular)
	{
		return (Long)sessionFactory.getCurrentSession().save(sorular);
	}
	
	
	public void Update(Question sorular)
	{
		sessionFactory.getCurrentSession().update(sorular);
	}
	
	public void Delete(Question sorular)
	{
		sessionFactory.getCurrentSession().delete(sorular);
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> ReadByUserId (int id) {
		List<Question> soru = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Question WHERE user_id=:id").setInteger("id",id);
			soru = (List<Question>) query.getResultList();
			return soru;
		}
		catch(NoResultException e)
		{
			return (List<Question>)soru;
		}
	}
	
	public Question ReadByQuestionId (int id) {
		Question soru = null;
		try {
			@SuppressWarnings("deprecation")
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Question WHERE id=:id").setInteger("id",id);
			soru = (Question) query.getSingleResult();
			return soru;
		}
		catch(NoResultException e)
		{
			return (Question)soru;
		}
	}
	
	

}
