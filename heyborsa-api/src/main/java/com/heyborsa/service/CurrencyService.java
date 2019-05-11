package com.heyborsa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.CurrencyDAO;
import com.heyborsa.entity.Doviz;

@Service
@Transactional
public class CurrencyService {
	@Autowired
	private CurrencyDAO currencyDAO;
	
	public Long insert(Doviz doviz)
	{
		return (Long) currencyDAO.insert(doviz);
	}
	
	public void insert(ArrayList<Doviz> doviz)
	{
		currencyDAO.insert(doviz);
	}
	
	public Doviz read(String type)
	{
		return currencyDAO.read(type);
	}
}
