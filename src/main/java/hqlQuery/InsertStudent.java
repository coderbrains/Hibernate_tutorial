package hqlQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		for(int i = 0;i <  100 ;i++) {
		
			Studentt student1 = new Studentt();
			student1.setAge(i);
			student1.setName("Awanish Kumar" + i);
			student1.setBranch("ME" + i);
			student1.setId(i * 100);
			session.save(student1);
			
		}
		
		
		
		
		
		
		// fetching all the student from the database.
		
//		String q  = "from Studentt";
//		Query query = session.createQuery(q);
//		List<Studentt> list = query.list(); 
//		
//		for(Studentt student : list) {
//			System.out.println(student);
//		}
//		
		//fetching all the student from the databasse having common attribute.
		
//		q  = "from Studentt where age = 202";
//		query = session.createQuery(q);
//		list = query.list(); 
//		
//		for(Studentt student : list) {
//			System.out.println(student);
//		}
//		
		
		//fetching the student information having the same attribute externally...
		
//		q  = "from Studentt where age =:x";
//		query = session.createQuery(q);
//		query.setParameter("x", 20);
//		list = query.list(); 
//		
//		for(Studentt student : list) {
//			System.out.println(student);
//		}
		
		//deleting a row from the table.
		
//		q = "delete from Studentt where id =:x";
//		query = session.createQuery(q);
//		query.setParameter("x", 101);
//		int r = query.executeUpdate();
//		System.out.println(r);
//		
		
		//updating student from the data base/
		
//		query = session.createQuery("update Studentt set name =:x where id =:i");
//		query.setParameter("i", 10);
//		query.setParameter("x", "Ram");
//		int l = query.executeUpdate();
//		System.out.println(l);
		
		
		// Joining two tables from the hql;
		
//		query = session.createQuery("select q.qid, q.questions , a.ans from Que as q inner join q.list as a");
//		
//		List<Object[]> list3 = query.getResultList();
//		
//		for(Object[] arr: list3) {
//			System.out.println(Arrays.toString(arr));
//		}
//		
		
		
		t.commit();
		factory.close();
		session.close();
	}

}
