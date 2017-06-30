package com.yummy.bakery.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(columnNames = { "user_id", "order_id" }) })
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
    private long id;
	
	@NotNull
    @Column(name = "status")
    private String status;
	
	@NotNull
    @Column(name = "user_id")
	private String userId;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;*/
	
	/*@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, targetEntity=OrderDetails.class)
	private Set<OrderDetails> orderDetails;*/
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity=OrderDetails.class, orphanRemoval=true)
    @JoinColumn(name = "order_id")
	private Set<OrderDetails> orderDetails;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_stamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date date;
	
	public Order() {
		
	}


	/*public Order(String status, User user, OrderDetails orderDetails) {
		super();
		this.status = status;
		this.user = user;
		this.orderDetails = orderDetails;
	}
*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
*/
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
