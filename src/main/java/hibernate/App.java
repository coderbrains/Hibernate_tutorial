package hibernate;

import java.io.FileInputStream;
import java.util.Date;

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
         
//        System.out.println(factory.isClosed());
        
        Student stu = new Student();
        stu.setId(103);
        stu.setName("Sunish");
        stu.setCity("DELHI");
        
        System.out.println(stu);
        
        Address add = new Address();
        add.setAddDate(new Date());
        add.setCity("DELHI");
        add.setStreet("first lane");
        add.setIsopen(true);
        
        try {
        	
        	FileInputStream fis = new FileInputStream("src/main/java/ak.jpg");
            byte[] image = new byte[fis.available()];
            fis.read(image);
            add.setImage(image);
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        System.out.println(add);
       
        
        Session session = factory.openSession();
        
        Transaction tx =  session.beginTransaction();
        
        session.save(add);
        session.save(stu);
        
        tx.commit();
        
        
        session.close();
        
        
        
        
    }
}
