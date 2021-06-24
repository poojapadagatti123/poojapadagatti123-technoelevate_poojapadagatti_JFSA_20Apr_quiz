package com.te.quiz.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Category {
 
	@Id
	@Column
	private int cid;
	@Column
	private String type;
    @OneToMany(mappedBy ="category",cascade=CascadeType.ALL)
	private List<Question> question;
	
}
