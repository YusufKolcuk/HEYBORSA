package com.heyborsa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.CurrencyDAO;
import com.heyborsa.entity.Currency;

@Service
@Transactional
public class CurrencyService {
	@Autowired
	private CurrencyDAO currencyDAO;
	
	public Long insert(Currency currency)
	{
		return (Long) currencyDAO.insert(currency);
	}
	
	public void insert(ArrayList<Currency> currency)
	{
		currencyDAO.insert(currency);
	}
	
	public Currency read(String type)
	{
		return currencyDAO.read(type);
	}
}
