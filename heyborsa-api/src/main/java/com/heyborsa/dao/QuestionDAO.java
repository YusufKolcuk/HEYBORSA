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
	
	public List<Question> GetAll()
	{
		List<Question> soru = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Question");
			soru = (List<Question>) query.getResultList();
			return soru;
		}
		catch(NoResultException e)
		{
			return (List<Question>)soru;
		}
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
	
	public boolean ValidateQuestion(Long user_id, Long question_id)
	{
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Question WHERE user_id=:user_id AND id=:question_id")
					.setLong("user_id", user_id)
					.setLong("question_id", question_id);
			if(query.getSingleResult() != null)
				return true;
			return false;
		}catch(NoResultException e)
		{
			return false;
		}
	}
	
	public List<Question> getOpenedeQuestions()
	{
		 List<Question> questions = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Question WHERE status=:status")
					.setString("status", "waiting");
			questions = query.getResultList();
			return questions;
		}catch(NoResultException e)
		{
			return questions;
		}
	}
	

	
	

}
