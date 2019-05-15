package com.heyborsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heyborsa.entity.Gold;
import com.heyborsa.entity.Question;
import com.heyborsa.service.GoldService;

@RestController
@RequestMapping(value="/market")
public class MarketController {
	
	@Autowired 
	GoldService goldService;
	
	@CrossOrigin
	@RequestMapping(value="/getall",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Gold>> get(){
		
		return new ResponseEntity<List<Gold>>(goldService.read(),HttpStatus.OK);
	}
}
