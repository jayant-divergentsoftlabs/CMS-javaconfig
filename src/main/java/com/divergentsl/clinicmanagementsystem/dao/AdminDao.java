package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
/**
 * This is a Data access object class for AdminLogin class.
 * @author Jayant
 *
 */
@Repository
public class AdminDao {
	private static Logger logger = LoggerFactory.getLogger(AdminDao.class);

	@Autowired
	private  IDatabaseManager databaseManager;

	public boolean admindao(String username, String password) {
		try {
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			con = databaseManager.getConnection();
			stmt = con.createStatement();
			if (con != null) {

				rs = stmt.executeQuery(
						"select * from admin where A_username ='" + username + "' and A_password ='" + password + "'");
				if (rs.next()) {
					logger.debug("Password is correct..!!");
					logger.debug("-----Admin Login Successful-----");
					return true;
				} else {
					logger.debug("Try again..!!");
					return false;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	
}
