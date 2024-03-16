package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Question;
import com.example.demo.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionsController {
	
	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping
	public Question create(@RequestBody Question question) {
return this.questionService.create(question);
}
	
	@GetMapping
	public List<Question >getAll() {
		return this.questionService.get();
	}
	@GetMapping("/{questionId}")
	public Question getByOne(@PathVariable Long questionId) {
		return this.questionService.getOne(questionId);
	}
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
	return this.questionService.getQuestionsOfQuiz(quizId);
}
}