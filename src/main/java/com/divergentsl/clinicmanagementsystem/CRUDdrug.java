package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.DrugDao;

import com.divergentsl.clinicmanagementsystem.dto.DrugDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the drug.
 * 
 * @author Jayant
 *
 */
@Component
public class CRUDdrug {
	private static Logger logger = LoggerFactory.getLogger(CRUDdrug.class);

	@Autowired
	private DrugDao drugdao;
	@Autowired
	private AdminLogin adminLogin;

	/**
	 * This method i.e. CRUDdrug is accessible by admin where admin can operate CRUD
	 * on Drug .
	 * @throws Exception 
	 */
	public void CRUDdrug() throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("-------------CRUD Drug Operation-------------");
			System.out.println("Press:- " + "\n1.Create Drug" + "\n2.See Drug list" + "\n3.Edit Drug"
					+ "\n4.Delete Drug" + "\n5.EXIT");
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
		DrugDto drugDto = new DrugDto();
		Scanner sc = new Scanner(System.in);

		Connection con;

		System.out.println("Enter Drug ID");
		int id = sc.nextInt();
		drugDto.setId(id);
		System.out.println("Enter Drug Name");
		String name = sc.next().trim();
		drugDto.setName(name);
		System.out.println("Enter Drug Quantity");
		int quantity = sc.nextInt();
		drugDto.setQuantity(quantity);
		System.out.println("Enter Drug Description");
		String description = sc.next();
		drugDto.setDescription(description);
		System.out.println("Enter Drug Price");
		int price = sc.nextInt();
		drugDto.setPrice(price);
		if (validateDrug(drugDto)) {
			return;
		}
		try {
			drugdao.create(id, name, quantity, description, price);
			logger.debug("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			logger.debug("\n--------Unsuccesful ----------");
		}
	}

	public void read() {
		logger.debug("--------------------------------------Drug List---------------------------------------------");

		try {

			List<Map<String, Object>> list = drugdao.read();
			if (list != null) {
				logger.debug("id          name \t        quantity      description\t  price\n ");

				for (Map<String, Object> map : list) {
					for (Entry<String, Object> get : map.entrySet()) {

						System.out.printf("%15s", get.getValue());

					}
					logger.info("\n");
				}
			}
		} catch (SQLException e) {
			logger.debug("----------Can't read---------" + e.getMessage());
		}

	}

	public void update() {
		DrugDto drugDto = new DrugDto();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Drug ID  you want to edit");
		int id = sc.nextInt();
		drugDto.setId(id);
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		drugDto.setName(name);
		System.out.println("Enter a Quantity you want to update");
		int quantity = sc.nextInt();
		drugDto.setQuantity(quantity);
		System.out.println("Enter a description you want to update");
		String description = sc.next();
		drugDto.setDescription(description);
		System.out.println("Enter a price you want to update");
		int price = sc.nextInt();
		drugDto.setPrice(price);
		if (validateDrug(drugDto)) {
			return;
		}
		try {

			drugdao.update(id, name, quantity, description, price);

			logger.debug("\n-------Value  Updated-------");

		} catch (SQLException e) {
			logger.debug("\n-------Can't  Update-------" + e.getMessage());
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter drug ID of drug you want to Delete");
		String Drug_id = sc.next();

		try {

			drugdao.delete(Drug_id);
			logger.debug("---------------Deleted successfully-----------------");
		} catch (SQLException e) {
			logger.debug("---------------Can't Delete-----------------" + e.getMessage());
		}
	}

	private boolean validateDrug(DrugDto drug) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<DrugDto>> violations = validator.validate(drug);

		for (ConstraintViolation<DrugDto> violation : violations) {
			logger.error(violation.getMessage());
		}
		return violations.size() > 0;
	}
}
