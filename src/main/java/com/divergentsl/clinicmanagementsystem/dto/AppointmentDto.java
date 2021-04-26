package com.divergentsl.clinicmanagementsystem.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentDto {
	@NotBlank(message = "ID can't be Null")
	String appointmentId;
	@NotNull(message = "Please enter patient name")
	String patientname;
	@NotNull(message = "Please enter valid doctorId")
	String DrId;
	@NotNull(message = "Please enter problem")
	String Problem;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	String appointmentDate;
	@DateTimeFormat(pattern = "hh-mm")
	@NotNull(message = "Please provide a time.")
	String appointmentTime;

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getDrId() {
		return DrId;
	}

	public void setDrId(String drId) {
		DrId = drId;
	}

	public String getProblem() {
		return Problem;
	}

	public void setProblem(String problem) {
		Problem = problem;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

}
