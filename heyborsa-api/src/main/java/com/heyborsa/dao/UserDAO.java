package com.heyborsa.dao;

import java.util.Base64;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.dto.LoginDTO;
import com.heyborsa.entity.User;
import com.heyborsa.security.Encryption;
import com.mysql.cj.util.Base64Decoder;

@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long insert(User user)
	{
		return (Long)sessionFactory.getCurrentSession().save(user);
	}
	
	public void Update(User user)
	{
		sessionFactory.getCurrentSession().update(user);
	}
	
	public void Delete(User user)
	{
		sessionFactory.getCurrentSession().delete(user);
	}
	
	
	public User GetUserById(int id)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id=:id")
				.setInteger("id", id);
		return (User) query.getSingleResult();
	}
	
	public User Login(LoginDTO loginDTO)
	{
		String password= Encryption.sha256(loginDTO.getPassword());
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=:email AND password=:password")
				.setString("email", loginDTO.getEmail())
				.setString("password",password);
		User user = null;
		try {
			user = (User) query.getSingleResult();
			return user;
		}catch(javax.persistence.NoResultException e)
		{
			return user;
		}
	}
	
	public User GetUserByEmail(String email)
	{

		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=:email")
				.setString("email",email);
		User user = null;
		try {
			user = (User) query.getSingleResult();
			return user;
		}catch(javax.persistence.NoResultException e)
		{
			return user;
		}
	}
	
	
	
	
}
