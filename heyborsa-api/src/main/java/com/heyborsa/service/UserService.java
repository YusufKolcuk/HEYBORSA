package com.heyborsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.UserDAO;
import com.heyborsa.dto.LoginDTO;
import com.heyborsa.entity.User;

@Service
@Transactional
public class UserService {
	@Autowired
	UserDAO userDAO;
	
	public Long register(User user)
	{
		return userDAO.insert(user);
	}
	
	public User getUserById(int id)
	{
		return userDAO.GetUserById(id);
	}
	public User login(LoginDTO loginDTO) {
		return userDAO.Login(loginDTO);
	}
}
