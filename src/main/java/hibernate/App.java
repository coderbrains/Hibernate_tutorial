package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "App started..." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory =  cfg.buildSessionFactory();
        
        System.out.println(factory);
         
        System.out.println(factory.isClosed());
        
        Student stu = new Student();
        stu.setId(102);
        stu.setName("MANISH");
        stu.setCity("LUCKNOW");
        
        System.out.println(stu);
        
        Session session = factory.openSession();
        
        Transaction tx =  session.beginTransaction();
        
        session.save(stu);
        
        tx.commit();
        
        
        session.close();
    }
}
