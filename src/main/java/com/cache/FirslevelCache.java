package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hqlQuery.Studentt;

public class FirslevelCache {

	public static void main(String[] args) {
		
		//This cache concept is provided automatically .
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Studentt studentt = session.get(Studentt.class, 100);
		System.out.println(studentt);
		
		System.out.println("some work is done here and then the same data is again called..");
		
		Studentt studentt2 = session.get(Studentt.class, 100);
		System.out.println(studentt2);
		
		//the first student is kept in the session cache and the  select query is not processed
		
		//we can even check the cache that whether it contains the object or not.
		
		System.out.println(session.contains(studentt));
		
		
		t.commit();
		session.close();
		factory.close();

	}

}
