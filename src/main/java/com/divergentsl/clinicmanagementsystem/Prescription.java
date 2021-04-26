package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.PrescriptionDao;
@Component
public class Prescription {
	private static Logger logger = LoggerFactory.getLogger(Prescription.class);
	@Autowired
	private  PrescriptionDao prescriptiondao;


	public void prescription() {
		Scanner sc = new Scanner(System.in);

		Connection con;

		System.out.println("Enter Drug Name");
		String name = sc.nextLine();
		System.out.println("Enter Drug MG");
		int mg = sc.nextInt();
		System.out.println("Enter Drug Quantity");
		int quantity = sc.nextInt();
		System.out.println("Enter Drug Days");
		int days = sc.nextInt();
		System.out.println("Enter Lab test");
		String test = sc.next();
		System.out.println("Enter the Note");
		String notes = sc.next();
		try {
			prescriptiondao.create(name, mg, quantity, days, test, notes);
			logger.debug("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			logger.debug("\n--------Unsuccesful ----------");
		}

	}
}
