package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This is data access object class for create of prescription by doctor.
 */
@Repository
public class PrescriptionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(String name, int mg, int quantity, int days, String test, String notes) throws SQLException {
		return this.jdbcTemplate.update("INSERT INTO prescription values('" + name + "','" + mg + "','" + quantity
				+ "','" + days + "','" + test + "','" + notes + "')");

	}

}
