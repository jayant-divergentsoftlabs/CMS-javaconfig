package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the Patient.
 * 
 * @author Jayant
 *
 */
@Component
public class CRUDpatient {
	private static Logger logger = LoggerFactory.getLogger(CRUDpatient.class);
	static Scanner sc = new Scanner(System.in);

	@Autowired
	private PatientDao patientDao;
	@Autowired
	private AdminLogin adminLogin;

	/**
	 * This method i.e. CRUDp is accessible by admin where admin can operate CRUD on
	 * Patient.
	 * @throws Exception 
	 */
	public void CRUDp() throws Exception {
		while (true) {
			System.out.println("--------CRUD Patient--------");
			System.out.println("Press:- " + "\n1.Create Patient" + "\n2.See Patient list" + "\n3.Edit Patient"
					+ "\n4.Delete Patient" + "\n5.EXIT");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				create();
				break;
			case 2:
				read();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				adminLogin.adminPanel();
				logger.debug("------------------Exit Successfully-----------------------");
				break;
			default:
				logger.debug("-------------------Enter Valid Input--------------------");
			}
		}
	}

	public void create() {
		PatientDto patientDto = new PatientDto();
		System.out.println("Enter patient ID");
		String id = sc.next();
		patientDto.setId(id);
		System.out.println("Enter patient Name");
		String name = sc.next().trim();
		patientDto.setName(name);
		System.out.println("Enter patient Age");
		int age = sc.nextInt();
		patientDto.setAge(age);
		System.out.println("Enter patient Gender");
		String gender = sc.next();
		patientDto.setGender(gender);
		System.out.println("Enter patient Contact Number");
		String contactnumber = sc.next();
		patientDto.setContactnumber(contactnumber);
		System.out.println("Enter patient Weight");
		int weight = sc.nextInt();
		patientDto.setWeight(weight);
		if (validatePatient(patientDto)) {
			return;
		}
		try {
			patientDao.create(id, name, age, gender, contactnumber, weight);
			logger.debug("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			logger.debug("\n--------Unsuccesful ----------");
		}

	}

	public void read() {
		logger.debug("--------------------------------------Patient List---------------------------------------------");
try {
		List<Map<String, Object>> list = patientDao.read();
		if (list != null) {
		//System.out.printf(" id\t name\t age\t gender\t contactnumber\t weight\n");

		for (Map<String, Object> map : list) {
			for (Entry<String, Object> get : map.entrySet()) {

				System.out.printf("%15s", get.getValue());

			}
			logger.info("\n");
		}
	}
} catch (Exception e) {
			System.err.println(e);
			logger.debug("----------Can't read---------");
		}

	}

	public void update() {
		PatientDto patientDto = new PatientDto();
		System.out.println("Enter Patient ID of doctor you want to edit");
		String id = sc.next();
		patientDto.setId(id);
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		patientDto.setName(name);
		System.out.println("Enter a age you want to update");
		int age = sc.nextInt();
		patientDto.setAge(age);
		System.out.println("Enter a gender you want to update");
		String gender = sc.next();
		patientDto.setGender(gender);
		System.out.println("Enter a contactnumber you want to update");
		String contactnumber = sc.next();
		patientDto.setContactnumber(contactnumber);
		System.out.println("Enter a Weight you want to update");
		int weight = sc.nextInt();
		patientDto.setWeight(weight);
		if (validatePatient(patientDto)) {
			return;
		}
		try {
			patientDao.update(id, name, age, gender, contactnumber, weight);
			logger.debug("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			logger.debug("\n-------Can't  Update-------");
		}
	}

	public void delete() {

		System.out.println("Enter Patient ID you want to Delete");
		String P_Id = sc.next();

		try {
			patientDao.delete(P_Id);
			logger.debug("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			logger.debug("---------------Can't Delete-----------------");
		}
	}

	private boolean validatePatient(PatientDto patient) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<PatientDto>> violations = validator.validate(patient);

		for (ConstraintViolation<PatientDto> violation : violations) {
			logger.error(violation.getMessage());
		}
		return violations.size() > 0;
	}

}
