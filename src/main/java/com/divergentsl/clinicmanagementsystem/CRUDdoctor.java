package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.*;
import java.util.Map.Entry;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the doctor.
 * 
 * @author Jayant
 *
 */
@Component
public class CRUDdoctor {
	private static Logger logger = LoggerFactory.getLogger(CRUDdoctor.class);
	static Scanner sc = new Scanner(System.in);

	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private AdminLogin adminLogin;

	/**
	 * This method i.e. CRUDdr is accessible by admin where admin can operate CRUD
	 * on doctor.
	 * @throws Exception 
	 */
	public void CRUDdr() throws Exception {

		while (true) {
			System.out.println("----------CRUD Operation for Doctor----------");
			System.out.println("Press:- " + "\n1.Create Doctor" + "\n2.See doctor list" + "\n3.Edit Doctor"
					+ "\n4.Delete Doctor" + "\n5.EXIT");
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

				break;
			default:
				logger.debug("-------------------Enter Valid Input--------------------");
				break;
			}
		}
	}

	public void create() {
		DoctorDto doctorDto = new DoctorDto();
		System.out.println("Enter Doctor ID");
		String id = sc.next();
		doctorDto.setId(id);
		System.out.println("Enter Doctor Name");
		String name = sc.next().trim();
		doctorDto.setName(name);
		System.out.println("Enter Doctor Speciality");
		String speciality = sc.next().trim();
		doctorDto.setSpeciality(speciality);
		System.out.println("Enter Doctor Fee");
		String fee = sc.next();
		doctorDto.setFee(fee);
		if (validateDoctor(doctorDto)) {
			return;
		}

		try {
			doctorDao.create(id, name, speciality, fee);
			logger.debug("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			logger.debug("\n--------Unsuccesful ----------" + e.getMessage());
		}

	}

	public void read() {
		System.out.println(
				"--------------------------------------Doctor List---------------------------------------------");

		try {

			List<Map<String, Object>> list = doctorDao.read();
			if (list != null) {

				// logger.info("id\t name \t speciality\t fee\n");

				for (Map<String, Object> map : list) {
					for (Entry<String, Object> get : map.entrySet()) {

						System.out.printf("%20s", get.getValue());

					}
					logger.info("\n");
				}
			}
		} catch (SQLException e) {
			logger.debug("----------Can't read---------" + e.getMessage());
		}

	}

	public void update() {
		DoctorDto doctorDto = new DoctorDto();
		System.out.println("Enter Doctor ID of doctor you want to edit");
		String id = sc.next();
		doctorDto.setId(id);
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		doctorDto.setName(name);
		System.out.println("Enter a speciality you want to update");
		String speciality = sc.next();
		doctorDto.setSpeciality(speciality);
		System.out.println("Enter a fee you want to update");
		String fee = sc.next();
		doctorDto.setFee(fee);
		if (validateDoctor(doctorDto)) {
			return;
		}

		try {

			doctorDao.update(id, name, speciality, fee);
			logger.debug("\n-------Value  Updated-------");

		} catch (SQLException e) {

			logger.debug("\n-------Can't  Update-------" + e.getMessage());
		}
	}

	public void delete() {

		try {

			System.out.println("Enter Doctor ID of doctor you want to Delete");
			String D_Id = sc.next();
			doctorDao.delete(D_Id);
			logger.debug("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			logger.debug("---------------Can't Delete-----------------" + e.getMessage());
		}
	}

	private boolean validateDoctor(DoctorDto doctor) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<DoctorDto>> violations = validator.validate(doctor);

		for (ConstraintViolation<DoctorDto> violation : violations) {
			logger.error(violation.getMessage());
		}
		return violations.size() > 0;
	}
}
