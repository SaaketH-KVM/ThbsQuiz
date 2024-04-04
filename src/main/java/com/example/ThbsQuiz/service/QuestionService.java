package com.example.ThbsQuiz.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ThbsQuiz.helper.MyExcellHelper;
import com.example.ThbsQuiz.model.Questionss;
import com.example.ThbsQuiz.repository.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepo questionrepo;
	
	public void save(MultipartFile file) {
		try {
			List<Questionss> question= MyExcellHelper.convertExcellToListofProduct(file.getInputStream());
			questionrepo.saveAll(question);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Questionss> getAllQuestions1(){
		return questionrepo.findAll();
		
	}

}
