package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.DoctorloginDao;

/**
 * This class is for Doctors,only doctor who have a doctor access can access it
 * by doctor's username and password.
 * 
 * @author Jayant
 *
 */
@Component
public class DoctorLogin {
	private static Logger logger = LoggerFactory.getLogger(DoctorLogin.class);
	Scanner sc = new Scanner(System.in);

	/**
	 * In this method i.e. DoctorMethod it will check the doctor's username and
	 * password if it is correct then the user can access doctor's functionalities.
	 */
	@Autowired
	private DoctorloginDao doctorLoginDao;
	@Autowired
	private ClinicManagementSystem clinicManagementSystem;
	@Autowired
	private Prescription prescription;
	@Autowired
	private BookedAppointment bookedAppointment;
	

	public boolean doctorMethod() {
		try {
			logger.debug("-------------------Doctor Panel------------------");

			logger.debug("\n-----Doctor Login------");
			System.out.print("\nEnter Username: ");
			String username = sc.next();

			System.out.print("\nEnter Password: ");
			String password = sc.next();
			if (doctorLoginDao.doctorDao(username, password)) {
				logger.debug("Admin Login Successful");
				return true;
			} else {
				logger.debug("Incorrect Username & Password");
				return false;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This method will perform all the operations which will access by Doctor.
	 * Doctor will give input for specific operation.
	 * 
	 * @throws Exception
	 */

	public int doctor_panel() throws Exception {

		System.out.println("Select: " + "\n1.List of patient" + "\n2.Add prescription and notes for a patient"
				+ "\n3.See booked appointments" + "\n4.Check patient history and his prescription" + "\n5.Exit");
		int a = sc.nextInt();

		switch (a) {
		case 1:
			Listpatient.listPatient();

			break;
		case 2:
			prescription.prescription();

			break;
		case 3:
			bookedAppointment.bookedAppointment();

			break;
		case 4:
//			Prescription.prescription();
			break;
		case 5:
			clinicManagementSystem.show();

			logger.debug("------------------Exit Successfully-----------------------");
			break;

		}
		return a;
	}

}
