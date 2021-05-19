package com.raulrezende.financialcontrol.entities.dto;

import java.time.Instant;

import com.raulrezende.financialcontrol.entities.Bank;

public class BankDTO {

	private Long id;
	private Integer cod;
	private String name;
	private String shortname;
	private String image;
	
	private Instant createdAt;
	private Instant updatedAt;
	
	public BankDTO() {
	}

	public BankDTO(Long id, Integer cod, String name, String shortName, String image) {
		this.id = id;
		this.cod = cod;
		this.name = name;
		this.shortname = shortName;
		this.image = image;
	}
	
	public BankDTO(Bank entity) {
		id = entity.getId();
		cod = entity.getCod();
		name = entity.getName();
		shortname = entity.getShortName();
		image = entity.getImage();
		createdAt = entity.getCreatedAt();
		updatedAt = entity.getUpdatedAt();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortname;
	}

	public void setShortName(String shortName) {
		this.shortname = shortName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}
}
