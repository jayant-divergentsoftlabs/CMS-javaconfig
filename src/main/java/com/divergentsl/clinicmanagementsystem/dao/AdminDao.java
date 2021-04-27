package com.divergentsl.clinicmanagementsystem.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This is a Data access object class for AdminLogin class.
 * @author Jayant
 *
 */
@Repository
public class AdminDao {
	private static Logger logger = LoggerFactory.getLogger(AdminDao.class);


@Autowired
private JdbcTemplate jdbcTemplate;

	public boolean admindao(String username, String password) {
		try {
			List<Map<String,Object>> list	=jdbcTemplate.queryForList("select * from admin where A_username ='" + username + "' and A_password ='" + password + "'");
				if (list.isEmpty()) {
					logger.info("Try again..!!");
					return false;
				} else {
					logger.debug("Password is correct..!!");
					logger.info("-----Admin Login Successful-----");
					
					return true;
				}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	
}
