package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Question;

public interface QuestionService {
	
	
	Question create(Question question);
	
	
	List<Question>get();
	
	Question getOne(Long id);
	
	
	List<Question>getQuestionsOfQuiz(Long quizId);
	

}
