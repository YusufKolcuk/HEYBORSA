package com.heyborsa.controller;

import java.util.Date;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heyborsa.dto.LoginDTO;
import com.heyborsa.dto.RegisterDTO;
import com.heyborsa.entity.Kullanici;
import com.heyborsa.helper.Encryption;
import com.heyborsa.service.KullaniciService;
import java.security.MessageDigest;
import java.util.Date;

@RestController
@RequestMapping(value="/kullanici")
public class KullaniciController {
	@Autowired
	private KullaniciService kullaniciService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2(Model model,HttpServletRequest request) {

		return "home";
	}
	
	@RequestMapping(value = "/ekle",method = RequestMethod.POST)
	@ResponseBody
	public String home3(@RequestParam Map<String,String> request) {
		
       
        return "home";
	}
	
	@RequestMapping(value="/getir",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Kullanici> getir(@RequestParam("id") int id)
	{
		return new ResponseEntity<Kullanici>(kullaniciService.getUserById(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/kayit",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> kayit(@RequestBody RegisterDTO registerDTO){
		
		String isim=registerDTO.getIsim();
		String soyisim=registerDTO.getSoyisim();
		String eposta=registerDTO.getEposta();
		String parola = Encryption.sha256(registerDTO.getParola());
		String telefon=registerDTO.getTelefon();	
		Date tarih=new Date(System.currentTimeMillis());
		boolean aktif = false;
		int kullanici = 1;
		
		Kullanici _kullanici = new Kullanici();
		_kullanici.setIsim(isim);
		_kullanici.setSoyisim(soyisim);
		_kullanici.setEposta(eposta);
		_kullanici.setSifre(parola);
		_kullanici.setTelefon(telefon);
		_kullanici.setTarih(tarih);
		_kullanici.setAktif(aktif);
		_kullanici.setTarih(tarih);
		_kullanici.setKullanici_tip(kullanici);
		return new ResponseEntity<Long>(kullaniciService.kayit(_kullanici),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/giris",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Kullanici> giris(@RequestBody LoginDTO loginDTO){
		System.out.println(loginDTO.getEposta() + " " + loginDTO.getParola());
		return new ResponseEntity<Kullanici>(kullaniciService.giris(loginDTO.getEposta(), loginDTO.getParola()),HttpStatus.OK);
	}
	
	
	
	
}
 
