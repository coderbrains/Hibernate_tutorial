package onetomanyrelations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ans{
	
	@Id
	private int ans_id;
	private String ans;
	
	@ManyToOne
	private Que q;

	public Ans(int ans_id, String ans, Que q) {
		super();
		this.ans_id = ans_id;
		this.ans = ans;
		this.q = q;
	}

	public Ans() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ans_id
	 */
	public int getAns_id() {
		return ans_id;
	}

	/**
	 * @param ans_id the ans_id to set
	 */
	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}

	/**
	 * @return the ans
	 */
	public String getAns() {
		return ans;
	}

	/**
	 * @param ans the ans to set
	 */
	public void setAns(String ans) {
		this.ans = ans;
	}

	/**
	 * @return the q
	 */
	public Que getQ() {
		return q;
	}

	/**
	 * @param q the q to set
	 */
	public void setQ(Que q) {
		this.q = q;
	}

	@Override
	public String toString() {
		return "Answers [ans_id=" + ans_id + ", ans=" + ans + ", q=" + q + "]";
	}

	
	
}

