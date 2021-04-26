package com.divergentsl.clinicmanagementsystem;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.AdminDao;

/**
 * This class is for admin,only admin accessor can access it by admin's username
 * and password.
 * 
 * @author Jayant
 *
 */
@Component
public class AdminLogin {
	private static Logger logger = LoggerFactory.getLogger(AdminLogin.class);

	@Autowired
	public AdminDao adminDao;
	@Autowired
	private ClinicManagementSystem clinicManagementSystem;

	@Autowired
	private CRUDdoctor cruDdoctor;
	@Autowired
	private CRUDpatient cruDpatient;
	@Autowired
	private CRUDdrug cruDdrug;
	@Autowired
	private CRUDLabtest crudLabtest;
	@Autowired
	private Appointment appointment;

	/**
	 * The adminMethod will check the username and password of the admin and if it
	 * is correct then it will login successfully otherwise give the another chance
	 * and will give try again.
	 * 
	 * @return
	 */
	public boolean adminMethod() {
		Scanner sc = new Scanner(System.in);

		try {
			logger.debug("-------------------Admin Panel------------------");

			logger.debug("\n-----Admin Login------");
			System.out.print("\nEnter Username: ");
			String username = sc.next();

			System.out.print("\nEnter Password: ");
			String password = sc.next();
			if (adminDao.admindao(username, password)) {
				logger.debug("Admin Login Successful");
				return true;
			} else {
				logger.debug("Incorrect Username & Password");
				return false;
			}

		} catch (Exception e) {
			logger.debug("Exception: " + e);
		}

		return true;
	}

	/**
	 * This method will perform all the operations which will access by admin. Admin
	 * will give input for specific operation.
	 */
	public int adminPanel() {
		try {
			while (true) {

				System.out.println(
						"Select: " + "\n1.CRUD Doctor" + "\n2.CRUD Patient" + "\n3.CRUD Drugs" + "\n4.CRUD Lab Test"
								+ "\n5.Book appointment for a patient by selecting Doctor and Date/time" + "\n6.Exit");

				Scanner sc = new Scanner(System.in);
				int a = Integer.parseInt(sc.nextLine());
				switch (a) {
				case 1:
					cruDdoctor.CRUDdr();
					break;
				case 2:
					cruDpatient.CRUDp();
					break;
				case 3:
					cruDdrug.CRUDdrug();
					break;
				case 4:
					crudLabtest.CRUDLab();
					break;
				case 5:
					appointment.appointmentList();
					break;
				case 6:
					clinicManagementSystem.show();
					logger.debug("------------------Exit Successfully-----------------------");
					break;

				default:
					logger.debug("Please Enter valid input");
				}

			}
		} finally {
			logger.debug("\nCRUD Operation");
		}

	}
}
