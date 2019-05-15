package com.heyborsa.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heyborsa.dto.FavoriteDTO;
import com.heyborsa.entity.Favorite;

@Repository
public class FavoriteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Favorite> GetFavoriteByFavoriteType(FavoriteDTO favoriteDTO)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Favorite WHERE user_id=:user_id AND favorite_type=:favorite_type")
				.setLong("user_id", favoriteDTO.getUser_id())
				.setString("favorite_type", favoriteDTO.getFavorite_type());
		List<Favorite> _favorites = null;
		try {
			_favorites = query.getResultList();
			return _favorites;
		}catch(NoResultException e)
		{
			return _favorites;
		}
	}
	
	public void RemoveFavorite(Favorite favorite)
	{
		sessionFactory.getCurrentSession().delete(favorite);
	}
	
	public Long AddFavorite(Favorite favorite)
	{
		return (Long) sessionFactory.getCurrentSession().save(favorite);
	}
	
}
