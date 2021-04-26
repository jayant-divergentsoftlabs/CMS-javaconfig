package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

/**
 * By this class Doctor can see the list of all the patients which have visited yet.
 * @author Jayant
 *
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

public class Listpatient {
	private static Logger logger = LoggerFactory.getLogger(Listpatient.class);

	@Autowired
	private static PatientDao patientDao;

	public static void listPatient() {
		logger.debug("--------------------------------------Patient List---------------------------------------------");

		try {
			List<PatientDto> dtos = patientDao.read();
			// System.out.printf("id name \t age gender\t contactnumber\t weight\n");

			for (PatientDto patientDto : dtos) {
				System.out.printf(" %s %30s %15s  %20s %20s %20d \n", patientDto.getId(), patientDto.getName(),
						patientDto.getAge(), patientDto.getGender(), patientDto.getContactnumber(),
						patientDto.getWeight());
				
			}
		} catch (SQLException e) {
			System.err.println(e);
			logger.debug("----------Can't read---------");
		}

	}
}
