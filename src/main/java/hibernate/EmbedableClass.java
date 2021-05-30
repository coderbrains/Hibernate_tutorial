package hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedableClass {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student1 s1 = new Student1();
		s1.setName("Awanish");
		s1.setCity("DELHI");
		
		Certificate c1 = new Certificate();
		c1.setCertificate_type("Core Java");
		c1.setDurations("4 months");
		
		s1.setCerti(c1);
		
		session.save(s1);

		tx.commit();
		session.close();
		factory.close();
	}

}

@Entity
class Student1{
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	private Certificate certi;
	
	public Student1(int id,String name, String city, Certificate certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certi = certi;
	}

	public Student1() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the certi
	 */
	public Certificate getCerti() {
		return certi;
	}

	/**
	 * @param certi the certi to set
	 */
	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

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

	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", city=" + city + ", certi=" + certi + "]";
	}
	
	
	
}

@Embeddable
class Certificate{
	
	private String certificate_type;
	private String durations;
	
	public Certificate(String certificate_type, String durations) {
		super();
		this.certificate_type = certificate_type;
		this.durations = durations;
	}

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the certificate_type
	 */
	public String getCertificate_type() {
		return certificate_type;
	}

	/**
	 * @param certificate_type the certificate_type to set
	 */
	public void setCertificate_type(String certificate_type) {
		this.certificate_type = certificate_type;
	}

	/**
	 * @return the durations
	 */
	public String getDurations() {
		return durations;
	}

	/**
	 * @param durations the durations to set
	 */
	public void setDurations(String durations) {
		this.durations = durations;
	}
	
	
}