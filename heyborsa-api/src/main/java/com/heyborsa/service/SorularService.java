package com.heyborsa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.CurrencyDAO;
import com.heyborsa.dao.SorularDAO;
import com.heyborsa.entity.Doviz;
import com.heyborsa.entity.Sorular;

@Service
@Transactional
public class SorularService {
	@Autowired
	private SorularDAO sorularDAO;
	
	public Long insert(Sorular soru)
	{
		return (Long) sorularDAO.insert(soru);
	}
	public void update(Sorular soru) {
		sorularDAO.Update(soru);
	}
	public void delete(Sorular soru) {
		sorularDAO.Delete(soru);
			}
	public List<Sorular> ReadByUserId(int userid)
	{
		return (List<Sorular>) sorularDAO.ReadByUserId(userid);
	}
	public Sorular ReadByQuestionId(int questionid) {
		return (Sorular) sorularDAO.ReadByUserId(questionid);
	}
}
