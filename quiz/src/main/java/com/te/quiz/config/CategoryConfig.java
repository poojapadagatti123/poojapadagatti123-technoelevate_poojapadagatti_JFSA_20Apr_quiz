package com.te.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.te.quiz.dto.Category;

@Configuration
@Import(QuestionConfig.class)
public class CategoryConfig {
  
	@Bean("category")
	@Scope("prototype")
	public Category getCategory() {
		return new Category();
	}
	
}
