package com.example.ThbsQuiz.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "Questionss")
public class Questionss {
//    @Id
//    private int _id;
//    private String question;
//    private String[] options;
//    private int correct_option;
//    private String difficulty_level;
//    private String subject;
//    private String subtopic;
//    private String question_type;
	

	
	@Id
	private Integer _id;
	private String questiontitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnswer;
	private String difficultyLevel;
	private String category;
	
	public Questionss() {
		// TODO Auto-generated constructor stub
	}

	public Questionss(Integer _id, String questiontitle, String option1, String option2, String option3, String option4,
			String rightAnswer, String difficultyLevel, String category) {
		super();
		this._id = _id;
		this.questiontitle = questiontitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightAnswer = rightAnswer;
		this.difficultyLevel = difficultyLevel;
		this.category = category;
	}


}
