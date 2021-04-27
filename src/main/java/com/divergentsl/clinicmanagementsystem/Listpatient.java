package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

/**
 * By this class Doctor can see the list of all the patients which have visited yet.
 * @author Jayant
 *
 */
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.divergentsl.clinicmanagementsystem.dao.ListpatientDao;

public class Listpatient {
	private static Logger logger = LoggerFactory.getLogger(Listpatient.class);

	@Autowired
	private static  ListpatientDao listpatientDao;

	public static  void listPatient() {
		logger.info("--------------------------------------Patient List---------------------------------------------");

		try {
			List<Map<String, Object>> list = listpatientDao.read();
			if (list != null) {
				// System.out.printf("id name \t age gender\t contactnumber\t weight\n");

				for (Map<String, Object> map : list) {
					for (Entry<String, Object> get : map.entrySet()) {

						System.out.printf("%10s ", get.getValue());

					}
					logger.info("\n");
				}
			}
		} catch (SQLException e) {
			System.err.println(e);
			logger.debug("----------Can't read---------");
		}

	}
}
