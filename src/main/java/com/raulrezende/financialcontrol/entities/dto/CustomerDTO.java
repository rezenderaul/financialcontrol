package com.raulrezende.financialcontrol.entities.dto;

import java.time.Instant;

import com.raulrezende.financialcontrol.entities.Customer;

public class CustomerDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Boolean premium;
	
	private Instant createdAt;
	private Instant updateAt;
	
	public CustomerDTO() {
		
	}

	public CustomerDTO(Long id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		premium = false;
	}
	
	public CustomerDTO(Customer entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		password = entity.getPassword();
		premium = entity.getPremium();
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
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
