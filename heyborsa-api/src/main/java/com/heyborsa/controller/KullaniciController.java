package com.heyborsa.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heyborsa.entity.Kullanici;
import com.heyborsa.service.KullaniciService;


@RestController
public class KullaniciController {
	@Autowired
	private KullaniciService kullaniciService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2(Model model,HttpServletRequest request) {

		return "home";
	}
	
	@RequestMapping(value = "/kullanici/ekle",method = RequestMethod.POST)
	@ResponseBody
	public String home3(Model model,HttpServletRequest request) {
		Kullanici kullanici = new Kullanici(1l,"hasan","hasan","hasan","hasan","hasan",new Date(),true,1);
        kullaniciService.insert(kullanici);
        return "home";
	}
	
	
	
}
