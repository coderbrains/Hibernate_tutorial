package hqlQuery;

import javax.persistence.Id;

import org.hibernate.annotations.Entity;

@javax.persistence.Entity
public class Studentt {
	@Id
	private int id;
	private String name;
	private String branch;
	private int age;
	public Studentt(int id, String name, String branch, int age) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.age = age;
	}
	public Studentt() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Studentt [id=" + id + ", name=" + name + ", branch=" + branch + ", age=" + age + "]";
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
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
