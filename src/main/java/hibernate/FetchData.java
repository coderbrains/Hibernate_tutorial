package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * @Author: Awanish kumar singh
 * 
 * Types of fetching data.
 * 
 * 1.get method  
 * --> returns null if the object is not found in the cache as well as in database.
 * --> use when we are not sure that object exists in db or not.
 * ---> when called for more than once for same object then the database is hit only-once.
 * 
 * 2.load method
 * -->returns exception if the object is not found.
 * --> used when we are sure that the object is in db..
 * --> donot calls the database until and unless the returning object has to be used..
 * 
 * 
 */

public class FetchData {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		//getting the student of id = 103
		
		Student student = (Student)session.get(Student.class, 103);
		
		System.out.println(student);
		
		//getting the values of address which has the id = 2
		
		Address add = (Address)session.get(Address.class, 2);
		System.out.println(add);
		
		session.close();
		factory.close();
	}

}
