package com.heyborsa.controller;


import java.util.Date;
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
import com.heyborsa.entity.User;
import com.heyborsa.helper.Encryption;

import com.heyborsa.service.UserService;



@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public String home3(@RequestParam Map<String,String> request) {
		
        return "home";
	}
	
	@RequestMapping(value="/get",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> get(@RequestParam("id") int id)
	{
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/register",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> register(@RequestBody RegisterDTO registerDTO){
		
		Date date=new Date(System.currentTimeMillis());
		boolean active = false;
		int user_type = 1;
		
		User _user = new User();
		_user.setFirst_name(registerDTO.getFirst_name());
		_user.setLast_name(registerDTO.getLast_name());
		_user.setEmail(registerDTO.getEmail());
		_user.setPassword(Encryption.sha256(registerDTO.getPassword()));
		_user.setTelephone(registerDTO.getTelephone());
		_user.setDate(date);
		_user.setActive(active);
		_user.setUser_type(user_type);
		return new ResponseEntity<Long>(userService.register(_user),HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO){
		return new ResponseEntity<User>(userService.login(loginDTO),HttpStatus.OK);
	}	
}
 
