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

import com.heyborsa.dto.AnswerDTO;
import com.heyborsa.dto.QuestionDTO;
import com.heyborsa.dto.ValidateQuestionDTO;
import com.heyborsa.entity.Answer;
import com.heyborsa.entity.Question;
import com.heyborsa.service.AnswerService;
import com.heyborsa.service.QuestionService;


@RestController
@RequestMapping(value="/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@CrossOrigin
	@RequestMapping(value="/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> add(@RequestBody QuestionDTO questionDTO){
		
		Question soru = new Question();
		soru.setHeader(questionDTO.getHeader());
		soru.setStatus("waiting");
		soru.setContent(questionDTO.getContent());
		soru.setSubject(questionDTO.getSubject());
		soru.setUser_id(questionDTO.getUser_id());
		soru.setDate(new Date(System.currentTimeMillis()));
		return new ResponseEntity<Long>(questionService.insert(soru),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity delete(@RequestBody Question question){
		questionService.delete(question);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/get",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Question>> get(@RequestParam("id") int id){
		
		return new ResponseEntity<List<Question>>(questionService.ReadByUserId(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/getall",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Question>> getAll(){
		
		return new ResponseEntity<List<Question>>(questionService.GetAll(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/getanswer",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Answer>> getanswer(@RequestParam("id") int id){
		
		return new ResponseEntity<List<Answer>>(answerService.ReadByQuestionId(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/addwithuser",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> sendAnswer(@RequestBody AnswerDTO answerDTO)
	{
		Date date=new Date(System.currentTimeMillis());
		Answer answer = new Answer();
		answer.setAnswer(answerDTO.getMessage());
		answer.setFu_id(0l);
		answer.setDate(date);
		answer.setQuestion_id(answerDTO.getQuestion_id());
		
		Question question = questionService.ReadByQuestionId((int)answerDTO.getQuestion_id());
		question.setStatus("waiting");
		questionService.update(question);
		
		return new ResponseEntity<Long>(answerService.addAnswerWithUser(answer),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/addwithfu",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> sendAnswerWithFu(@RequestBody AnswerDTO answerDTO)
	{
		Date date=new Date(System.currentTimeMillis());
		Answer answer = new Answer();
		answer.setAnswer(answerDTO.getMessage());
		answer.setFu_id(1l);
		answer.setDate(date);
		answer.setQuestion_id(answerDTO.getQuestion_id());
		
		Question question = questionService.ReadByQuestionId((int)answerDTO.getQuestion_id());
		question.setStatus("answered");
		questionService.update(question);
		
		return new ResponseEntity<Long>(answerService.addAnswerWithUser(answer),HttpStatus.OK);
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "getanswerbyid",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Answer> getAnswerById(@RequestParam("id") int id)
	{
		return new ResponseEntity<Answer>(answerService.getAnswerById(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "validatequestion",method = RequestMethod.POST)
	@ResponseBody
	public boolean validateQuestion(@RequestBody ValidateQuestionDTO validateQuestionDTO)
	{
		return questionService.ValidateQuestion(
				validateQuestionDTO.getUser_id(),validateQuestionDTO.getQuestion_id());
	}
	
	@CrossOrigin
	@RequestMapping(value = "getopenedquestions",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Question>> getOpenedQuestions()
	{
		return new ResponseEntity<List<Question>>(questionService.getOpenedeQuestions(),HttpStatus.OK);
	}
	
	
	
}
