package com.heyborsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.AnswerDAO;
import com.heyborsa.entity.Answer;
@Service
@Transactional
public class AnswerService {
	
	@Autowired
	private AnswerDAO answerDAO;
	
	public Long insert(Answer answer)
	{
		return (Long) answerDAO.insert(answer);
	}
	
	public void delete(Answer answer) {
		answerDAO.delete(answer);	
	}
	
	public List<Answer> ReadByQuestionId(int questionid) {
		return (List<Answer>) answerDAO.readByQuestionId(questionid);
	}
	
	
}

