package io.spandana.movieflix_api.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email=:pEmail") 
//write named query for admin to add movie
})

public class User {
	
	@OneToMany(mappedBy = "User")
    private List<Comment> comment;
	
	@Id
	@Column(unique=true)
	private String email;
	
	private String firstName;
	private String lastName;	
	private String password;
	private String userType;
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
