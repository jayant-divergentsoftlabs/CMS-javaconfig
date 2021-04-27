package com.divergentsl.clinicmanagementsystem.dto;

import javax.validation.constraints.NotNull;

public class LabtestDto {
	@NotNull(message = "Please enter test name")
	String  name;
	@NotNull(message = "ID can't be Null")
	int id;
	@NotNull(message = "price can't be Null")
	int price;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	}


