package com.divergentsl.clinicmanagementsystem.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class DrugDto {
	@NotNull(message = "Please enter drug name")
	String name;
	@NotNull(message = "Please enter drug's description")
    String description;
	@NotNull(message = "Please enter drug's price")
    int price;
	@NotNull(message = "ID can't be Null")
	int id;
	@NotNull(message = "Please enter drug's quantity")
	@Max(value = 200, message = "Quantity should not be greater than 200")
	int quantity;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
