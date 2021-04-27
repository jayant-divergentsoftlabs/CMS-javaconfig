package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This is data access object class for create,read,update and delete operation
 * on patient.
 * 
 * @author Jayant
 *
 */
@Repository
public class PatientDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public int create(String id, String name, int age, String gender, String contactnumber, int weight)
			throws SQLException {

		return this.jdbcTemplate.update("insert into patient values ( '" + id + "' , '" + name + "' , " + age + " , '"
				+ gender + "' , '" + contactnumber + "' , " + weight + ")");

	}

	public List<Map<String, Object>> read() throws SQLException {

		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from patient");
		return list;

	}

	public int update(String id, String name, int age, String gender, String contactnumber, int weight)
			throws SQLException {
		return this.jdbcTemplate.update("UPDATE patient SET P_name  ='" + name + "', P_age= " + age + ", P_Gender= '"
				+ gender + "', P_contactnumber ='" + contactnumber + "', P_weight =" + weight + " WHERE P_id='" + id
				+ ")");

	}

	public int delete(String id) throws SQLException {

		return this.jdbcTemplate.update("DELETE FROM patient WHERE P_id='" + id + "'");

	}

}
