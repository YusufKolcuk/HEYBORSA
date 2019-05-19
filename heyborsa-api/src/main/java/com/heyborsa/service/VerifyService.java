package com.heyborsa.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.VerifyDAO;
import com.heyborsa.entity.Verify;

@Service
@Transactional
public class VerifyService {

	@Autowired
	private VerifyDAO verifyDAO;
	
	public Long insert(String email,Date date,String key)
	{
		
		Verify verify = new Verify();
		verify.setDate(date);
		verify.setEmail(email);
		verify.setKey(key);
		return (Long) verifyDAO.insert(verify);
	}
	
	public Verify getByEmail(String email)
	{
		return (Verify) verifyDAO.getByEmail(email);
	}
	
	public Verify getByKey(String key)
	{
		return verifyDAO.getByKey(key);
	}
	
	public void Delete(Verify verify)
	{
		verifyDAO.Delete(verify);
	}
}
