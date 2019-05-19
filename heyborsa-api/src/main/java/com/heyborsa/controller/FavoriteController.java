package com.heyborsa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heyborsa.dto.FavoriteDTO;
import com.heyborsa.dto.FavoriteProccessDTO;
import com.heyborsa.entity.Favorite;
import com.heyborsa.service.FavoriteService;

@RestController
@RequestMapping(value="/favorites")
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@CrossOrigin
	@RequestMapping(value="/checkmultiple",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Favorite>> checkMultiple(@RequestParam String currencyName)
	{
		return null;
	}
	
	@CrossOrigin
	@RequestMapping(value="/checkfavoritesbyfavoritetype",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Favorite>> checkFavoriteByFavoriteType(@RequestBody FavoriteDTO favoriteDTO)
	{
		return new ResponseEntity<List<Favorite>>(favoriteService.GetFavoriteByFavoriteType(favoriteDTO),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/addfavorite",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> addFavorite(@RequestBody Favorite favorite)
	{
		favorite.setCreated_time(new Date(System.currentTimeMillis()));
		return new ResponseEntity<Long>(favoriteService.AddFavorite(favorite),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/removefavorite",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeFavorite(@RequestBody FavoriteProccessDTO favoriteProccessDTO)
	{
		favoriteService.RemoveFavorite(favoriteProccessDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/getall",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Favorite>> getAll(@RequestParam Long id)
	{
		return new ResponseEntity<List<Favorite>>(favoriteService.GetFavoriteByUserId(id),HttpStatus.OK);
	}
}
