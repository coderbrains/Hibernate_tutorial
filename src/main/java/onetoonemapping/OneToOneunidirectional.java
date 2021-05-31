package onetoonemapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneunidirectional {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Questions q = new Questions();
		q.setQuestionid(105);
		q.setQuestions("What is c?");
		
		
		Answers ans = new Answers();
		ans.setAnswerid(106);
		ans.setAns("c is also a normal programming language...");
		q.setAnswers(ans);
		
//		session.save(ans);
//		session.save(q);
		
		Questions questions1 = session.get(Questions.class, 1);
		System.out.println(questions1.getQuestions());
		System.out.println(questions1.getAnswers().getAns());
		
		tx.commit();
		session.close();
		factory.close();
	}
}

@Entity
class Questions{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionid;
	private String questions;
	@OneToOne
	private Answers answers;
	public Questions(int questionid, String questions, Answers answers) {
		super();
		this.questionid = questionid;
		this.questions = questions;
		this.answers = answers;
	}
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the questionid
	 */
	public int getQuestionid() {
		return questionid;
	}
	/**
	 * @param questionid the questionid to set
	 */
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
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
	 * @return the answers
	 */
	public Answers getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Answers answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Questions [questionid=" + questionid + ", questions=" + questions + ", answers=" + answers + "]";
	}
	
	
}

@Entity
class Answers{
	
	@Id
	private int answerid;
	private String ans;
	public Answers(int answerid, String ans) {
		super();
		this.answerid = answerid;
		this.ans = ans;
	}
	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the answerid
	 */
	public int getAnswerid() {
		return answerid;
	}
	/**
	 * @param answerid the answerid to set
	 */
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
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
	@Override
	public String toString() {
		return "Answers [answerid=" + answerid + ", ans=" + ans + "]";
	}
	
	
	
	
}