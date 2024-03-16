package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Question;
import com.example.demo.repository.QuestionRepo;

@Service
public class QuestionsServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	
	@Override
	public Question create(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepo.save(question);
	}

	@Override
	public List<Question> get() {
		// TODO Auto-generated method stub
		return this.questionRepo.findAll();
	}

	@Override
	public Question getOne(Long id) {
		// TODO Auto-generated method stub
		return this.questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		return this.questionRepo.findByQuizId(quizId);
	}

}
