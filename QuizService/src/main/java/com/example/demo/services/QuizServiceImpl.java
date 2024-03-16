package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Quiz;
import com.example.demo.repository.QuizRepo;

import feign.RetryableException;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;

	
	
	
	@Override
	public Quiz add(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> get() {
	
		List<Quiz>quizzes=quizRepo.findAll();
		List<Quiz>newQuizList=quizzes.stream().map(quiz->{
			 
 quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
	            
	            return quiz;
	        }).collect(Collectors.toList());
	        return newQuizList;
	}

	@Override
	public Quiz get(Long quizId) {
		
		Quiz quiz= quizRepo.findById(quizId).orElseThrow(()-> new RuntimeException("Quiz not found"));
		  quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
	       
	          
	        return quiz;
	    }
}
