package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.Scanner;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;
import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;

/**
 * \ This class i.e. Appointment will accessed by admin where admin can book
 * appointment for the patient and can see the doctor list.
 * 
 * @author Jayant
 *
 */
@Component
public class Appointment {
	private static Logger logger = LoggerFactory.getLogger(Appointment.class);

	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private CRUDdoctor crudDoctor;
	@Autowired
	private ClinicManagementSystem clinicManagementSystem;

	/**
	 * By the help of this method i.e. appointmentList admin can Create appointment
	 * and can see doctor list.
	 * @throws Exception 
	 */

	public void appointmentList() throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			logger.debug("-------------Appointment-------------");
			System.out.println("Press:- " + "\n1.Create  Appointment" + "\n2.See Doctor list" + "\n3.EXIT");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				create();
				logger.debug("----------Appointment Created Successfully----------");
				break;
			case 2:
				crudDoctor.read();
				logger.debug("----------This is a List of Doctors----------");
				break;
			case 3:
				clinicManagementSystem.show();
			}
		}
	}

	public void create() {
		AppointmentDto appointmentDto = new AppointmentDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Appointment ID");
		String appointmentId = sc.next();
		appointmentDto.setAppointmentId(appointmentId);
		System.out.println("Enter Patient Name");
		String patientName = sc.next().trim();
		appointmentDto.setPatientname(patientName);
		System.out.println("Enter Doctor Id ");
		String drId = sc.next().trim();
		appointmentDto.setDrId(drId);
		System.out.println("Enter Problem");
		String problem = sc.next().trim();
		appointmentDto.setProblem(problem);
		System.out.println("Enter Date of Appointment");
		String appointmentDate = sc.next().trim();
		appointmentDto.setAppointmentDate(appointmentDate);
		System.out.println("Enter Time of Appointment");
		String appointmentTime = sc.next().trim();
		appointmentDto.setAppointmentTime(appointmentTime);
		if (validateAppoitment(appointmentDto)) {
			return;
		}
		try {
			appointmentDao.create(appointmentId, patientName, drId, problem, appointmentDate, appointmentTime);

			logger.debug("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			logger.debug("\n--------Unsuccesful ----------");
		}

	}

	private boolean validateAppoitment(AppointmentDto appointment) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<AppointmentDto>> violations = validator.validate(appointment);

		for (ConstraintViolation<AppointmentDto> violation : violations) {
			logger.error(violation.getMessage());
		}
		return violations.size() > 0;
	}

}
