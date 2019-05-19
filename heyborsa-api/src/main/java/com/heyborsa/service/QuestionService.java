package com.heyborsa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.QuestionDAO;
import com.heyborsa.entity.Question;

@Service
@Transactional
public class QuestionService {
	@Autowired
	private QuestionDAO questionDAO;
	
	public Long insert(Question question)
	{
		return (Long) questionDAO.insert(question);
	}
	public void update(Question question) {
		questionDAO.Update(question);
	}
	public void delete(Question question) {
		questionDAO.Delete(question);
			}
	public List<Question> GetAll()
	{
		return (List<Question>) questionDAO.GetAll();
	}
	public List<Question> ReadByUserId(int userid)
	{
		return (List<Question>) questionDAO.ReadByUserId(userid);
	}
	public Question ReadByQuestionId(int questionid) {
		return (Question) questionDAO.ReadByQuestionId(questionid);
	}
	public boolean ValidateQuestion(Long user_id, Long question_id)
	{
		return (boolean) questionDAO.ValidateQuestion(user_id, question_id);
	}
	
	public List<Question> getOpenedeQuestions()
	{
		return (List<Question>) questionDAO.getOpenedeQuestions();
	}
}
