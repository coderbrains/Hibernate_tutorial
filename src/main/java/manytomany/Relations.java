package manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Relations {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setEid(101);
		e1.setEname("Awanish");
		
		Employee e2 = new Employee();
		e2.setEid(102);
		e2.setEname("Manish");
		
		Employee e3 = new Employee();
		e3.setEid(103);
		e3.setEname("Sunish");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e2);
		list.add(e1);
		
		Projects p =  new Projects();
		p.setPname("GUI");
		p.setPid(105);
		
		Projects p1 =  new Projects();
		p1.setPname("GUI");
		p1.setPid(106);
		
		Projects p2 =  new Projects();
		p2.setPname("GUI");
		p2.setPid(107);
		
		
		List<Projects> list2 = new ArrayList<Projects>();
		list2.add(p);
		list2.add(p1);
		
		p.setEmployees(list);
		e1.setProjects(list2);
		
		System.out.println(p);
		System.out.println(e1);
		
		session.save(p);
		session.save(p1);
		session.save(p2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		
		
		tx.commit();
		session.close();
		factory.close();

	}

}
