package com.heyborsa.controller;


import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
import com.heyborsa.entity.Verify;
import com.heyborsa.security.Encryption;
import com.heyborsa.service.MailService;
import com.heyborsa.service.UserService;
import com.heyborsa.service.VerifyService;




@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired 
	private MailService mailService;
	
	@Autowired
	private VerifyService verifyService;
	
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
		String key = UUID.randomUUID().toString();
		verifyService.insert(registerDTO.getEmail(), date,key);
		try {
			mailService.RegisterMail(registerDTO.getFirst_name(),registerDTO.getLast_name(),key,registerDTO.getEmail());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Long>(userService.register(_user),HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO){
		
		return new ResponseEntity<User>(userService.login(loginDTO),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/validate",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> Validate(@RequestParam String token)
	{
		byte[] decodingToken = Base64.getDecoder().decode(token);
		String decodingString = new String(decodingToken);
		String[] datas = decodingString.split(":");
		String email = datas[0];
		String password = datas[1];
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setEmail(email);
		loginDTO.setPassword(password);
		return new ResponseEntity<User>(userService.login(loginDTO),HttpStatus.OK);
	}
	
	/*
	 * 
	 * Key i alýp o keye ait olan kullanýcýnýn aktifliðini true yapýyoruz
	 * true yaptýktan sonra o verify entitysini siliyoruz
	 * 
	 */
	
	@CrossOrigin
	@RequestMapping(value="/verifyemail",method = RequestMethod.GET)
	@ResponseBody
	public boolean login(@RequestParam String key){
		Verify verify = verifyService.getByKey(key);
		if(verify == null)
			return false;
		User user = userService.GetUserByEmail(verify.getEmail());
		if(user == null)
			return false;
		user.setActive(true);
		userService.Update(user);
		verifyService.Delete(verify);
		return true;
	} 
}
 
