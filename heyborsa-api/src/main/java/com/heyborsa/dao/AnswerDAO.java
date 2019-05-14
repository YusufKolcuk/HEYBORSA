package com.heyborsa.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.entity.Answer;

@Repository
public class AnswerDAO {
	@Autowired
	SessionFactory sessionFactory;
	public Long insert(Answer answer)
	{
		return (Long) sessionFactory.getCurrentSession().save(answer);
	}
	
	public void delete(Answer answer)
	{
		sessionFactory.getCurrentSession().delete(answer);
	}
	
	@SuppressWarnings("deprecation")
	public Answer read(int id)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Answer WHERE id=:id").setInteger("id", id);
		return (Answer) query.getSingleResult();
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Answer> readByQuestionId(int id)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Answer WHERE question_id=:question_id").setInteger("question_id", id);
		return (List<Answer>) query.getResultList();
	}
	
}
