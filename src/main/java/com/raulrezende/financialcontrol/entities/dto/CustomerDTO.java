package com.raulrezende.financialcontrol.entities.dto;

import java.time.Instant;

import com.raulrezende.financialcontrol.entities.Customer;

public class CustomerDTO {

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Boolean premium = false;
	
	private Instant createdAt;
	private Instant updateAt;
	
	public CustomerDTO() {
		
	}

	public CustomerDTO(Long id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
	}
	
	public CustomerDTO(Customer entity) {
		id = entity.getId();
		firstname = entity.getFirstName();
		lastname = entity.getLastName();
		email = entity.getEmail();
		password = entity.getPassword();
		premium = entity.getPremium();
		createdAt = entity.getCreatedAt();
		updateAt = entity.getUpdateAt();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
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

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Instant updateAt) {
		this.updateAt = updateAt;
	}
}
