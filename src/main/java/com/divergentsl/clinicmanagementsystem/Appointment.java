package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;


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
	 */

	public  void appointmentList() {
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Appointment ID");
		String appointmentId = sc.next();
		System.out.println("Enter Patient Name");
		String patientName = sc.next().trim();
		System.out.println("Enter Doctor Id ");
		String drId = sc.next().trim();
		System.out.println("Enter Problem");
		String problem = sc.next().trim();
		System.out.println("Enter Date of Appointment");
		String appointmentDate = sc.next().trim();
		System.out.println("Enter Time of Appointment");
		String appointmentTime = sc.next().trim();

		try {
			appointmentDao.create(appointmentId, patientName, drId, problem, appointmentDate, appointmentTime);
			
			logger.debug("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			logger.debug("\n--------Unsuccesful ----------");
		}

	}

}
