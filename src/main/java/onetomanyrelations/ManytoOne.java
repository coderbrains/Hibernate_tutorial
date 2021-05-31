package onetomanyrelations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoOne {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session  session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Que questions = new Que();
		questions.setQid(101);
		questions.setQuestions("What is java?");
		
		Ans answers = new Ans();
		answers.setAns("java is a programming language..");
		answers.setAns_id(102);
		answers.setQ(questions);
		
		Ans answers1 = new Ans();
		answers1.setAns("java has a lot of class.");
		answers1.setAns_id(103);
		answers1.setQ(questions);
		
		Ans answers2 = new Ans();
		answers2.setAns("java is a object oriented programming language.");
		answers2.setAns_id(104);
		answers2.setQ(questions);
		
		Ans answers3 = new Ans();
		answers3.setAns("java has many classes to be used patiently");
		answers3.setAns_id(105);
		answers3.setQ(questions);
		
		List<Ans> list = new ArrayList<Ans>();
		list.add(answers);
		list.add(answers1);
		list.add(answers2);
		list.add(answers3);
		
		questions.setList(list);

		session.save(answers);
		session.save(answers1);
		session.save(answers2);
		session.save(answers3);
		session.save(questions);
		
		tx.commit();
		session.close();
		factory.close();

	}

}
