package com.heyborsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.SoruCevapDAO;
import com.heyborsa.dao.SorularDAO;
import com.heyborsa.entity.SoruCevap;
import com.heyborsa.entity.Sorular;
@Service
@Transactional
public class SoruCevapService {
	@Autowired
	private SoruCevapDAO sorucevapDAO;
	
	public Long insert(SoruCevap soruCevap)
	{
		return (Long) sorucevapDAO.insert(soruCevap);
	}
	
	public void delete(SoruCevap soruCevap) {
		sorucevapDAO.delete(soruCevap);
			}
		public SoruCevap ReadByQuestionId(int questionid) {
		return (SoruCevap) sorucevapDAO.readByQuestionId(questionid);
	}
}

