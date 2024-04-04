package com.example.ThbsQuiz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ThbsQuiz.model.Questionss;

@Repository
public interface QuestionRepo extends MongoRepository<Questionss,Integer> {

}
