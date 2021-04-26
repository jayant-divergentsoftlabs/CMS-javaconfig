package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.*;

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
	private  DoctorDao doctorDao;
     @Autowired
     private AdminLogin adminLogin;
	

	/**
	 * This method i.e. CRUDdr is accessible by admin where admin can operate CRUD
	 * on doctor.
	 */
	public void CRUDdr() {

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

	public  void create() {

		System.out.println("Enter Doctor ID");
		String id = sc.next();
		System.out.println("Enter Doctor Name");
		String name = sc.next().trim();
		System.out.println("Enter Doctor Speciality");
		String speciality = sc.next().trim();
		System.out.println("Enter Doctor Fee");
		String fee = sc.next();

		try {
			doctorDao.create(id, name, speciality, fee);
			logger.debug("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			logger.debug("\n--------Unsuccesful ----------" +e.getMessage());
		}

	}

	public  void read() {
		System.out.println
	  ("--------------------------------------Doctor List---------------------------------------------");

		try {

			List<DoctorDto> dtos = doctorDao.read();
//			logger.debug("id          name \t        speciality      fee\n");

			for (DoctorDto doctorDto : dtos) {
				System.out.printf(" %s %30s %15s  %20s \n", doctorDto.getId(), doctorDto.getName(),
						doctorDto.getSpeciality(), doctorDto.getFee());
			
			}
		} catch (SQLException e) {
			logger.debug("----------Can't read---------" +e.getMessage());
		}

	}

	public void update() {

		System.out.println("Enter Doctor ID of doctor you want to edit");
		String id = sc.next();
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		System.out.println("Enter a speciality you want to update");
		String speciality = sc.next();
		System.out.println("Enter a fee you want to update");
		String fee = sc.next();

		try {

			doctorDao.update(id, name, speciality, fee);
			logger.debug("\n-------Value  Updated-------");

		} catch (SQLException e) {

			logger.debug("\n-------Can't  Update-------" +e.getMessage());
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

}
