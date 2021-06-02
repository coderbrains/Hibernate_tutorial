package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import hqlQuery.Studentt;

public class CriteteriaExample {

	public static void main(String[] args) {
		
		Session openSession = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = openSession.beginTransaction();
		Criteria c = openSession.createCriteria(Studentt.class);
		
		c.add(Restrictions.between("id", 100, 1000)); // we can even add the restrictions  there.
		
		List<Studentt> l = c.list();
		
		for(Studentt s : l) {
			System.out.println(s);
		}
		
		t.commit();
		openSession.close();
	}

}
