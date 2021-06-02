package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mappingxml {

	public static void main(String[] args) {
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Person person = new Person(10, "Manish", "Mirjapur", "857468XXXX");
		session.save(person);
		
		
		buildSessionFactory.close();
		t.commit();
		session.close();
	}

}
