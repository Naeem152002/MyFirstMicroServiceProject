package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Question;

public interface  QuestionRepo extends JpaRepository<Question, Long>{

	
	List<Question>findByQuizId(Long quizId);
}
