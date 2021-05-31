package hibernate;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Database;

/*
 * Types of states in the cruel hibernate...
 * Transient state
 * persistent state
 * detached state
 * remove state
 * 
 * 
 */


public class HibernateStates {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		ABC abc = new ABC();
		abc.setId(1);
		abc.setName("Hello World");
		Certificates certi = new Certificates();
		certi.certi = "This is a Hello world";
		abc.setCerti(certi);
		
		// It is in transient state till now;
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(abc); //now the abc object is in the persistent state
		
		//we can also change the value of the object because it is in the persistent state.
		
		abc.setName("web development");

		tx.commit();		
		session.close();
		
		//this part is in the detached states.
		
		abc.setName("android development");
//		it donot appears in the Databas.......
		
		factory.close();
		
		//now for the removed states we have to fetch the database and then call delete database
		
		
	
	}
	

}


@Entity
class ABC{
	
	@Id
	private int id;
	private String name;
    private	Certificates  certi;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the certi
	 */
	public Certificates getCerti() {
		return certi;
	}
	/**
	 * @param certi the certi to set
	 */
	public void setCerti(Certificates certi) {
		this.certi = certi;
	}
	
    
}

@Embeddable
class Certificates{
	
	String certi;
}