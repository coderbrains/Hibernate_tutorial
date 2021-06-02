package com.pagination.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hqlQuery.Studentt;

public class HqlPagination {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Query<Studentt> query = session.createQuery("from Studentt");
		query.setFirstResult(0);
		query.setMaxResults(20);
		List<Studentt> list = query.list();
		
		for(Studentt s : list) {
			System.out.println(s.getId() + "  --> "  +  s.getName());
		}

		t.commit();
		factory.close();
		session.close();

	}

}
