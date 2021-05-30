package hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * @author Awanish kumar singh...
 * 	
 * @Entity - Used to identify entity property..;
 * @Table - Used to identify table quality..	
 * @Id - used to identify primary id of a table.
 * @GeneratedValue - hibernate will automatically generate values for that using an internal sequence.
 * 					Therefore we dont have to set manually.
 * @Column - Used to identify the new column name.
 * @Transient - tells the hibernate not to save the field.
 * @Temporal - tells the hibernate the format in which the date needs to be saved.
 * @Lob  - tells the hibernate that this is the large object and not the simple one. e.g - Blob, Clob.
 * Advanced columns - @OneToOne, @OneToMany, @ManyToMany, @ManyToOne , @JoinColumn etc...
 * 
 */

@Entity
public class Student {

	@Id   //used to make primary key..
	private int id;
	private String name;
	private String city;
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	
}
