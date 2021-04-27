package com.divergentsl.clinicmanagementsystem.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This is data access object class for doctor login.
 * 
 * @author Jayant
 *
 */
@Repository
public class DoctorloginDao {
	static final Logger myLogger = LoggerFactory.getLogger(DoctorloginDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean doctorDao(String username, String password) {
		try {

			List<Map<String, Object>> list = jdbcTemplate.queryForList(
					"select *from doctorlogin where D_username ='" + username + "' and D_password ='" + password + "'");
			if (list.isEmpty()) {
				myLogger.info("Try again..!!");
				return false;
			} else {
				myLogger.debug("Password is correct..!!");
				myLogger.info("-----Doctor Login Successful-----");
				return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;

	}

}
