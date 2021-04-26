package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;

/**
 * This is data access object class for create of prescription by doctor.
 */
@Repository
public class PrescriptionDao {
	@Autowired
	public IDatabaseManager databaseManager;

	public int create(String name, int mg, int quantity, int days, String test, String notes) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("INSERT INTO prescription values('" + name + "','" + mg + "','" + quantity + "','"
				+ days + "','" + test + "','" + notes + "')");

	}

}
