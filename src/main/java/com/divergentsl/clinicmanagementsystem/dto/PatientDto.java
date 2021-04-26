package com.divergentsl.clinicmanagementsystem.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PatientDto {
	@NotBlank(message = "ID can't be Null")
	String id;
	@NotNull(message = "Please enter patient name")
	String name;  
	@Size(min = 10, max = 10, message="Contact number must have 10 digits")
	String contactnumber;
	@Min(value = 40, message = "Weight should not be less than 40")
    @Max(value = 200, message = "Weight should not be greater than 200")
	int weight;
	@Min(value = 1, message = "Age should not be less than 1 year")
    @Max(value = 150, message = "Age should not be greater than 150")
	int age;
	@Pattern(regexp = "^(M|F|O)$")
	String gender;
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
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
	