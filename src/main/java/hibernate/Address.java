package hibernate;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "address_details")
public class Address {
	
	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addid;
	
	@Column(name = "street_name", length = 100)
	private String street;
	private String city;
	
	@Transient
	private double x;
	
	@Column(name = "add_date", length = 100)
	@Temporal(TemporalType.DATE)
	private Date addDate;
	private boolean isopen;
	
	@Lob		
	private byte[] image;

	public Address(int addid, String street, String city, double x, Date addDate, boolean isopen, byte[] image) {
		super();
		this.addid = addid;
		this.street = street;
		this.city = city;
		this.x = x;
		this.addDate = addDate;
		this.isopen = isopen;
		this.image = image;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the addid
	 */
	public int getAddid() {
		return addid;
	}

	/**
	 * @param addid the addid to set
	 */
	public void setAddid(int addid) {
		this.addid = addid;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
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
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the addDate
	 */
	public Date getAddDate() {
		return addDate;
	}

	/**
	 * @param addDate the addDate to set
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	/**
	 * @return the isopen
	 */
	public boolean isIsopen() {
		return isopen;
	}

	/**
	 * @param isopen the isopen to set
	 */
	public void setIsopen(boolean isopen) {
		this.isopen = isopen;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [addid=" + addid + ", street=" + street + ", city=" + city + ", x=" + x + ", addDate=" + addDate
				+ ", isopen=" + isopen + ", image=" + Arrays.toString(image) + "]";
	}
	
	

}
