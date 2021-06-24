package com.te.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.te.quiz.config.CategoryConfig;
import com.te.quiz.dto.Category;
import com.te.quiz.dto.Question;

public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext context=new AnnotationConfigApplicationContext(CategoryConfig.class);
		//1.category
		Category category1=context.getBean(Category.class);
		// category 1 set value
		category1.setCid(1);
        category1.setType("sport");
        //2.category
        Category category2=context.getBean(Category.class);
        // category 2 set value
     	category2.setCid(2);
     	category2.setType("science");
		
		Question question1=context.getBean(Question.class);
		Question question2=context.getBean(Question.class);
		Question question3=context.getBean(Question.class);
		Question question4=context.getBean(Question.class);
		Question question5=context.getBean(Question.class);
		Question question6=context.getBean(Question.class);
		Question question7=context.getBean(Question.class);
		Question question8=context.getBean(Question.class);
		Question question9=context.getBean(Question.class);
		Question question10=context.getBean(Question.class);
		
		//1 question for sport
		question1.setQid(1);
		question1.setQuestion("Which of the following football club wins FIFA Club World Cup 2020?");
		question1.setOption1("1.Juventus F. C");
		question1.setOption2("2.FC Barcelona");
		question1.setOption3("3.Manchester United");
		question1.setOption4("4.Bayern Munich");
		question1.setAnswer("Bayern Munich");
		question1.setCategory(category1);
		
		//2 question for sport
		question2.setQid(2);
		question2.setQuestion("Who has become the first Indian fencer to qualify for Tokyo Olympic Games?");
		question2.setOption1("1.Kavitha Devi");
		question2.setOption2("2.Bhavani Devi");
	    question2.setOption3("3.Daina Devi");
		question2.setOption4("4.Kaushik Vedika");
		question2.setAnswer("Bhavani Devi");
		question2.setCategory(category1);
		
		//3 question for sport
		question3.setQid(3);
		question3.setQuestion(" Who becomes the first cricketer who has hit the six sixes in an over in One Day Internation (50-50) cricket?");
		question3.setOption1("Kieron Pollard");
		question3.setOption2("2.Yuvraj Singh");
		question3.setOption3("3.Herschelle Gibs");
		question3.setOption4("4.Viv Richards");
		question3.setAnswer("Herschelle Gibs");
		question3.setCategory(category1);
		
		
		//4 question for sport
		question4.setQid(4);
		question4.setQuestion(" Who becomes the first cricketer who has hit the six sixes in an over in One Day Internation (50-50) cricket?");
		question4.setOption1("Kieron Pollard");
		question4.setOption2("2.Yuvraj Singh");
	    question4.setOption3("3.Herschelle Gibs");
		question4.setOption4("4.Viv Richards");
		question4.setAnswer("Herschelle Gibs");
		question4.setCategory(category1);
		
		//5 question for sport
		question5.setQid(5);
		question5.setQuestion(" Who becomes the first cricketer who has hit the six sixes in an over in One Day Internation (50-50) cricket?");
		question5.setOption1("Kieron Pollard");
		question5.setOption2("2.Yuvraj Singh");
	    question5.setOption3("3.Herschelle Gibs");
		question5.setOption4("4.Viv Richards");
		question5.setAnswer("Herschelle Gibs");
		question5.setCategory(category1);
		
		//Store the question of sports
		List<Question> questionList1=new ArrayList<Question>();
		questionList1.add(question1);
		questionList1.add(question2);
		questionList1.add(question3);
		questionList1.add(question4);
		questionList1.add(question5);
		
		
		//setting category value
		category1.setQuestion(questionList1);
		
		
		
		// category 2 set value
		category2.setCid(2);
		category2.setType("science");
		
		//1 question for science
		question6.setQid(6);
		question6.setQuestion("Who is honoured as Father of Modern Chemistry?");
		question6.setOption1("Antoine Lavoisier");
		question6.setOption2("2.David Joseph");
		question6.setOption3("3.Rinky Martin");
		question6.setOption4("4.Newton");
		question6.setAnswer("Antoine Lavoisier");
		question6.setCategory(category2);
		
		//2 question for science
		question7.setQid(7);
		question7.setQuestion("Who invented periodic table?");
		question7.setOption1("1.Dmitri Mendeleev");
		question7.setOption2("2.David Joseph");
		question7.setOption3("3.Rinky Martin");
		question7.setOption4("4.Newton");
		question7.setAnswer("Dmitri Mendeleev");
		question7.setCategory(category2);
		
		//3 question for science
		question8.setQid(8);
		question8.setQuestion("Who invented periodic table?");
		question8.setOption1("1.Dmitri Mendeleev");
		question8.setOption2("2.David Joseph");
		question8.setOption3("3.Rinky Martin");
		question8.setOption4("4.Newton");
		question8.setAnswer("Dmitri Mendeleev");
		question8.setCategory(category2);
		 
		List<Question> questionList2=new ArrayList<Question>();
		questionList2.add(question6);
		questionList2.add(question7);
		questionList2.add(question8);
		category2.setQuestion(questionList2);
		
		try {
			
			functionality(category1,category2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void functionality(Category category1, Category category2) {
		Scanner sc=new Scanner(System.in);
		EntityManagerFactory empEntityManagerFactory=Persistence.createEntityManagerFactory("quiz");
		EntityManager empManager=empEntityManagerFactory.createEntityManager();
		EntityTransaction transaction=empManager.getTransaction();
		transaction.begin();
		empManager.persist(category1);
		empManager.persist(category2);
		transaction.commit();
		//Enter the user name
		System.out.println("Enter your name");
		String name=sc.nextLine();
		System.out.println(name+" lets play have fun");
		System.out.println("Choice which quiz you want to play");
		System.out.println("1.sport \n 2.science");
		System.out.println();
		int id=sc.nextInt();
		String s="from Category where cid=:id ";
		Query q=empManager.createQuery(s);
		 q.setParameter("id", id);
		Category category=(Category) q.getSingleResult();
		List<Question> questions=category.getQuestion();
		int finalscore=0;
		for(Question que:questions) {
			System.out.println(que.getOption1());
			System.out.println(que.getOption2());
			System.out.println(que.getOption3());
			System.out.println(que.getOption4());
			System.out.println();
			System.out.println("enter your answer ");
			String ans = sc.nextLine();
			String correctans=que.getAnswer();
			
			if(ans.equalsIgnoreCase(correctans)) {
				System.out.println("Correct!!!!!!");
				
				finalscore++;
			}else {
				System.out.println("better luck next time");
			}
			
			System.out.println();
			
		}
		System.out.println();
		System.out.println("you final score is "+finalscore);
		
		
		
	}
}
