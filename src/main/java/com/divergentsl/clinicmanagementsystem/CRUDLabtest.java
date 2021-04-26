package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
import com.divergentsl.clinicmanagementsystem.dto.LabtestDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the Lab Tests.
 * 
 * @author Jayant
 *
 */
@Component
public class CRUDLabtest {
	private static Logger logger = LoggerFactory.getLogger(CRUDLabtest.class);
	@Autowired
	private static LabtestDao labtestDao;
	@Autowired
	private AdminLogin adminLogin;

	/**
	 * This method i.e. CRUDtest is accessible by admin where admin can operate CRUD
	 * on test which are in Lab.
	 */
	public void CRUDLab() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("--------CRUD LabTest--------");
			System.out.println("Press:- " + "\n1.Create Test" + "\n2.See Test list" + "\n3.Edit Test"
					+ "\n4.Delete Test" + "\n5.EXIT");
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
			}
		}
	}

	public void create() {
		LabtestDto labtestDto = new LabtestDto();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Test ID");
		int id = sc.nextInt();
		labtestDto.setId(id);
		System.out.println("Enter Test Name");
		String name = sc.next().trim();
		labtestDto.setName(name);
		System.out.println("Enter Test Price");
		int price = sc.nextInt();
		labtestDto.setPrice(price);
		if (validateLabtest(labtestDto)) {
			return;
		}
		try {
			labtestDao.create(id, name, price);
			logger.debug("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			logger.debug("\n--------Unsuccesful ----------" + e.getMessage());
		}
	}

	public void read() {
		System.out.println(
				"--------------------------------------Test List---------------------------------------------");

		try {
			List<LabtestDto> dtos = labtestDao.read();
			// System.out.printf("%s %20s %20s",id,name,price\n);

			for (LabtestDto labDto : dtos) {

				System.out.printf("%s %20s %20s \n", labDto.getId(), labDto.getName(), labDto.getPrice());

			}
		} catch (SQLException e) {
			logger.debug("----------Can't read---------" + e.getMessage());
		}
	}

	public void update() {
		LabtestDto labtestDto = new LabtestDto();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Test ID of test  you want to edit");
		int id = sc.nextInt();
		labtestDto.setId(id);
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		labtestDto.setName(name);
		System.out.println("Enter a price you want to update");
		int price = sc.nextInt();
		labtestDto.setPrice(price);
		if (validateLabtest(labtestDto)) {
			return;
		}
		try {
			labtestDao.update(id, name, price);
			logger.debug("\n-------Value  Updated-------");

		} catch (SQLException e) {

			logger.debug("\n-------Can't  Update-------" + e.getMessage());
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Test ID of Test you want to Delete");
		String Test_id = sc.next();

		try {
			labtestDao.delete(Test_id);
			logger.debug("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			logger.debug("---------------Can't Delete-----------------" + e.getMessage());
		}
	}

	private boolean validateLabtest(LabtestDto test) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<LabtestDto>> violations = validator.validate(test);

		for (ConstraintViolation<LabtestDto> violation : violations) {
			System.err.println(violation.getMessage());
		}
		return violations.size() > 0;
	}
}
