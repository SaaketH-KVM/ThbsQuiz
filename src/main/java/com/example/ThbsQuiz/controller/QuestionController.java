package com.example.ThbsQuiz.controller;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ThbsQuiz.helper.MyExcellHelper;
import com.example.ThbsQuiz.model.Questionss;
import com.example.ThbsQuiz.repository.QuestionRepo;
import com.example.ThbsQuiz.service.QuestionService;




@RestController
@RequestMapping("/demo")
    public class QuestionController {
    @Autowired
    QuestionRepo repo;
    
    @Autowired
    QuestionService questionservice;

    @GetMapping("/allQuestions")
    public List<Questionss> getAllQuestions() {
        return repo.findAll();
    }

//    @GetMapping("subject/{subject}")
//    public List<Questionss> getQuestionsBySubject(@PathVariable String subject) {
//        return repo.findBySubject(subject);
//    }
//    
    @PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (MyExcellHelper.checkExcelFormat(file)) {
            //true

            this.questionservice.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }
	
	@GetMapping("/boll")
	public List<Questionss> getboll(){
		return this.questionservice.getAllQuestions1();
	


}
}
