package onetoonemapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneBidirectional {

	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t  = session.beginTransaction();
		
		Q q = new Q();
		A a =new A();
		
		
		q.setQid(1565);
		q.setQuestion("Why java?");
		a.setAid(3);
		a.setAns("because it is a great programming language..");
		q.setA(a);
		a.setQ(q);
		
		session.save(q);
		session.save(a);
		
		
		t.commit();
		session.close();
		factory.close();

	}

}


@Entity
class Q{
	
	@Id
	private int Qid;
	private String question;
	
	@OneToOne
	private  A a;

	public Q(int qid, String question, A a) {
		super();
		Qid = qid;
		this.question = question;
		this.a = a;
	}

	public Q() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the qid
	 */
	public int getQid() {
		return Qid;
	}

	/**
	 * @param qid the qid to set
	 */
	public void setQid(int qid) {
		Qid = qid;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the a
	 */
	public A getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(A a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "Q [Qid=" + Qid + ", question=" + question + ", a=" + a + "]";
	}
	
	

}


@Entity
class A{
	
	@Id
	private int aid;
	private String ans;
	
	@OneToOne
	private Q q;
	public A(int aid, String ans, Q q) {
		super();
		this.aid = aid;
		this.ans = ans;
		this.q = q;
	}
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
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
	public Q getQ() {
		return q;
	}
	/**
	 * @param q the q to set
	 */
	public void setQ(Q q) {
		this.q = q;
	}
	@Override
	public String toString() {
		return "A [aid=" + aid + ", ans=" + ans + ", q=" + q + "]";
	}
	
	
	
}
