package com.divergentsl.clinicmanagementsystem;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * In this class we will input from user that he/she want to login through
 * Doctor or Admin.
 * 
 * @return He/she have admin access then he/she will go to admin and if he/she
 *         is Doctor then then will go to doctor.
 * @author Jayant
 *
 */
@Component("ClinicManagement")

public class ClinicManagementSystem {
	private static Logger logger = LoggerFactory.getLogger(ClinicManagementSystem.class);

	@Autowired
	private AdminLogin adminLogin;
	@Autowired
	private DoctorLogin doctorLogin;
	@Autowired
	Environment env;

	public String show() throws Exception {

		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("Enter the Login panel");
			System.out.println("1. Admin");
			System.out.println("2. Doctor");
			System.out.println("Exit");
			int Input = sc.nextInt();
			switch (Input) {
			case 1:
				if (adminLogin.adminMethod()) {
					adminLogin.adminPanel();

				} else {
					logger.debug("Wrong password");
				}

				break;
			case 2:
				doctorLogin.doctorMethod();
				int d = doctorLogin.doctor_panel();

				break;
			case 3:

				logger.debug("------------------Exit Successfully-----------------------");
			default:
				logger.debug("Enter valid panel");
			}
		}
	}

	public String getPropertyValue() {
		return env.getProperty("test");
	}
}
