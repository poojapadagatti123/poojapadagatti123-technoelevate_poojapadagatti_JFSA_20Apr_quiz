package com.te.quiz.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Question {
	  @Id
	  @Column
      private int qid;
	  @Column
      private String question;
	  @Column
      private String option1;
	  @Column
      private String option2;
	  @Column
      private String option3;
	  @Column
      private String option4;
	  @Column
	  private String answer;
	  
	  @ManyToOne(cascade=CascadeType.ALL)
	  @JoinColumn(name="cid")
	  private Category category;
      
}
