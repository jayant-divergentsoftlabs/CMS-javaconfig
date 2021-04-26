package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
/**
 * This is data access object class for doctor login.
 * @author Jayant
 *
 */
@Repository
public class DoctorloginDao {
	static final Logger myLogger = Logger
			.getLogger("DoctorloginDao.java");
	
	@Autowired
	private IDatabaseManager databaseManager;
	

	public  boolean doctorDao(String username, String password) {
		try {
			myLogger.setLevel(Level.FINE);
			Connection con = null;
			Statement stmt = null;
			con = databaseManager.getConnection();
			stmt = con.createStatement();
			if (con != null) {

				ResultSet rs=stmt.executeQuery("select *from doctorlogin where D_username ='" + username + "' and D_password ='" + password + "'");
				if (rs.next()) {
					myLogger.info("Password is correct..!!");
					myLogger.info("-----Doctor Login Successful-----");
					return true;
				} else {
					myLogger.info("Try again..!!");
				}
			} else {
				myLogger.info("Connection error..!!");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}
	

}
