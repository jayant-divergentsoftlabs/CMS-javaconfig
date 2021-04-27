package com.divergentsl.clinicmanagementsystem.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
@Component
public class DoctorDto {
	@NotBlank(message = "ID can't be Null")
	String id;
	
	@NotNull(message = "Please enter doctor name")
	String name;
	
	@NotNull(message = "Please enter doctor's speciality")
	String speciality;
	
	@NotBlank(message = "Please enter valid fee")
	@Max(value = 1500, message = "fee should not be greater than 1500")
	String fee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

}