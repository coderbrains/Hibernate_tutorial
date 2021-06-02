package com.sqlqueries;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import hqlQuery.Studentt;

public class SqlQueries {

	public static void main(String[] args) {
		
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Session factory = session.openSession();
		Transaction t = factory.beginTransaction();
		
		String sql = "select * from Studentt";
		NativeQuery query = factory.createSQLQuery(sql);
		List<Object[]> al = query.list();
		
		for(Object[] ss : al){
			
			System.out.println(ss[1]);
			
		}
		
		t.commit();
		session.close();
		factory.close();

	}

}
