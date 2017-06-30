package com.yummy.bakery.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@GenericGenerator(name = "generator", strategy = "foreign",
	parameters = @Parameter(name = "property", value = "users"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false)
    private long id;
	
	@NotNull
    @Column(name = "fullname")
    private String fullName;
	
	@NotNull
    @Column(name = "addr1")
    private String addr1;
	
	@NotNull
    @Column(name = "addr2")
    private String addr2;
	
	@NotNull
    @Column(name = "phone")
    private long phoneNumber;
	
	@NotNull
    @Column(name = "city")
    private String city;
	
	@NotNull
    @Column(name = "postal_code")
    private Integer postalCode;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_stamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date date;
	
	public UserDetails() {
		
	}

	public UserDetails(String fullName, String addr1, String addr2, long phoneNumber, String city, Integer postalCode,
			User user, Date date) {
		super();
		this.fullName = fullName;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.postalCode = postalCode;
		this.user = user;
		this.date = date;
	}



	public UserDetails(String fullName, String addr1, String addr2, long phoneNumber, String city,
			Integer postalCode, User user) {
		super();
		this.fullName = fullName;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.postalCode = postalCode;
		this.user = user;
	}

	public UserDetails(String fullName, String addr1, String addr2, long phoneNumber, String city,
			Integer postalCode) {
		super();
		this.fullName = fullName;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.postalCode = postalCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
