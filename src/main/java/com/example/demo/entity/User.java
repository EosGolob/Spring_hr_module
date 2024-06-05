package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String LastName;
	
	private String email;
	private String password;
	private Date createdDate;
	
	@ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinTable(
			 name = "user_roles",
			 joinColumns = @JoinColumn(
					 name = "user_id", referencedColumnName = "id"
					 ),
			 inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
	private Collection<Role> roles;
	
	
	public User(String firstName, String lastName, String email, String password, Date createdDate,
			Collection<Role> roles) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
		this.createdDate = createdDate;
		this.roles = roles;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	

}
