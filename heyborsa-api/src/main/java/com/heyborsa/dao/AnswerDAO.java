package com.heyborsa.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.dto.AnswerDTO;
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
	
	public Long addAnswerWithUser(Answer answer)
	{	
		return (Long) sessionFactory.getCurrentSession().save(answer);
	}
	
	public Answer getAnswerById(long id)
	{
		Answer answer = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Answer WHERE id=:id").setLong("id", id);
			answer = (Answer) query.getSingleResult();
			return answer;
		}catch(NoResultException e) {
			return answer;
		}
	}
	
}
