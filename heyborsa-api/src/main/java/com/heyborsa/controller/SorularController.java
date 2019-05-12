package com.heyborsa.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.heyborsa.dto.LoginDTO;
import com.heyborsa.dto.RegisterDTO;
import com.heyborsa.dto.SoruDTO;
import com.heyborsa.entity.Kullanici;
import com.heyborsa.entity.Sorular;
import com.heyborsa.helper.Encryption;
import com.heyborsa.service.SorularService;

@RestController
@RequestMapping(value="/sorular")
public class SorularController {
	
	@Autowired
	private SorularService sorularService;
	
	@CrossOrigin
	@RequestMapping(value="/ekle",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> ekle(@RequestBody SoruDTO soruDTO){
		
		Sorular soru = new Sorular();
		soru.setBaslik(soruDTO.getBaslik());
		System.out.println(soruDTO.getBaslik() + " " + soruDTO.getIcerik());
		soru.setDurum("bekleniyor");
		soru.setIcerik(soruDTO.getIcerik());
		soru.setKonu(soruDTO.getKonu());
		soru.setKullaniciid(soruDTO.getUser_id());
		soru.setTarih(new Date(System.currentTimeMillis()));
		return new ResponseEntity<Long>(sorularService.insert(soru),HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/getir",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Sorular>> getir(@RequestParam("id") int id){
		
		return new ResponseEntity<List<Sorular>>(sorularService.ReadByUserId(id),HttpStatus.OK);
	}	
	
}
