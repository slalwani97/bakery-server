package com.yummy.bakery.model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;
    
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.ALL, targetEntity=UserRole.class)
    private UserRole userRole;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_stamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date date;
    
    public Role() {
    	
    }

	public Role(String name, UserRole userRole, Date date) {
		super();
		this.name = name;
		this.userRole = userRole;
		this.date = date;
	}



	public Role(String name, UserRole userRole) {
		super();
		this.name = name;
		this.userRole = userRole;
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    

}
