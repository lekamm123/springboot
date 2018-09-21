package com.in28minutes.springboot.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.SurveyService;

@RestController
public class SurveyController {
	@Autowired
	SurveyService surveyService ;
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retriveQuestionForSurvey(@PathVariable String surveyId)
	{
		//localhost:9000/surveys/Survey1/questions
		return surveyService.retrieveQuestions(surveyId);
	
	}
	
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retriveDetailForQuestion(@PathVariable String surveyId,@PathVariable String questionId)
	{
		//localhost:9000/surveys/Survey1/questions/Question1
		
		return surveyService.retrieveQuestion(surveyId, questionId);
	
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Void> retriveDetailForQuestion(@PathVariable String surveyId,@RequestBody Question newQuestion)
	{
		Question question = surveyService.addQuestion(surveyId, newQuestion);
		
		//localhost:9000/surveys/Survey1/questions


		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(question.getId()).toUri();
		return ResponseEntity.created(location).build();
	
	}


}