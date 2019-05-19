package com.heyborsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heyborsa.dao.FavoriteDAO;
import com.heyborsa.dto.FavoriteDTO;
import com.heyborsa.dto.FavoriteProccessDTO;
import com.heyborsa.entity.Favorite;

@Service
@Transactional
public class FavoriteService {
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	public List<Favorite> GetFavoriteByFavoriteType(FavoriteDTO favoriteDTO)
	{
		return (List<Favorite>) favoriteDAO.GetFavoriteByFavoriteType(favoriteDTO);
	}

	public void RemoveFavorite(FavoriteProccessDTO favoriteProccessDTO) {
		Favorite favorite = new Favorite();
		favorite.setFavorite_data(favoriteProccessDTO.getFavorite_data());
		favorite.setFavorite_type(favoriteProccessDTO.getFavorite_type());
		favorite.setId(favoriteProccessDTO.getId());
		favoriteDAO.RemoveFavorite(favorite);
	}

	public Long AddFavorite(Favorite favorite)
	{
		return (Long) favoriteDAO.AddFavorite(favorite);
	}
	
	public List<Favorite> GetFavoriteByUserId(Long id)
	{
		return (List<Favorite>) favoriteDAO.GetFavoriteByUserId(id);
	}
}
