package onetomanyrelations;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Que{

	@Id
	private int qid;
	private String questions;
	
	@OneToMany(mappedBy = "q")
	private List<Ans> list;

	public Que(int qid, String questions, List<Ans> list) {
		super();
		this.qid = qid;
		this.questions = questions;
		this.list = list;
	}

	public Que() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the qid
	 */
	public int getQid() {
		return qid;
	}

	/**
	 * @param qid the qid to set
	 */
	public void setQid(int qid) {
		this.qid = qid;
	}

	/**
	 * @return the questions
	 */
	public String getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(String questions) {
		this.questions = questions;
	}

	/**
	 * @return the list
	 */
	public List<Ans> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Ans> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Questions [qid=" + qid + ", questions=" + questions + ", list=" + list + "]";
	}
	
	
	
}
