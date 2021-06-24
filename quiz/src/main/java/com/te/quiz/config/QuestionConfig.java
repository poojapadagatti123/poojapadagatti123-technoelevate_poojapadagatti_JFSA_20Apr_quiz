package com.te.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.te.quiz.dto.Question;


  
	@Configuration
	public class QuestionConfig {
		@Bean("quiz")
		@Scope("prototype")
	public Question getQuesBean() {
		return new Question();
	}
  }

