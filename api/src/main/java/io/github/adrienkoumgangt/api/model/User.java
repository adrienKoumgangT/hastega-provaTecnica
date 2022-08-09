package io.github.adrienkoumgangt.api.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="username", nullable=false)
	private String username;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	public Integer getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
