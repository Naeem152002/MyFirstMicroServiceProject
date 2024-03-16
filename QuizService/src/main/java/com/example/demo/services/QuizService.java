package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Quiz;

public interface QuizService {
	
	Quiz add(Quiz quiz);
	
	List<Quiz>get();
	
	Quiz get(Long id);
	

}
