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


import com.heyborsa.dto.QuestionDTO;
import com.heyborsa.entity.Answer;
import com.heyborsa.entity.Question;
import com.heyborsa.service.AnswerService;
import com.heyborsa.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping(value="/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> ekle(@RequestBody QuestionDTO questionDTO){
		
		Question soru = new Question();
		soru.setHeader(questionDTO.getHeader());
		soru.setStatus("waiting");
		soru.setContent(questionDTO.getContent());
		soru.setSubject(questionDTO.getSubject());
		soru.setUser_id(questionDTO.getUser_id());
		soru.setDate(new Date(System.currentTimeMillis()));
		return new ResponseEntity<Long>(questionService.insert(soru),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/get",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Question>> get(@RequestParam("id") int id){
		
		return new ResponseEntity<List<Question>>(questionService.ReadByUserId(id),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getanswer",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Answer>> getanswer(@RequestParam("id") int id){
		
		return new ResponseEntity<List<Answer>>(answerService.ReadByQuestionId(id),HttpStatus.OK);
	}	
	
}
