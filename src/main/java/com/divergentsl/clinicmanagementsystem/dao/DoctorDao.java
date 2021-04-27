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
 * on doctor.
 * 
 * @author Jayant
 *
 */
@Repository
public class DoctorDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(String id, String name, String speciality, String fee) throws SQLException {

		return this.jdbcTemplate
				.update("insert into doctor values (" + id + ", '" + name + "','" + speciality + "'," + fee + "'");

	}

	public List<Map<String, Object>> read() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from doctor");
		return list;
	}

	public int update(String id, String name, String speciality, String fee) throws SQLException {

		return this.jdbcTemplate.update("UPDATE doctor SET D_name ='" + name + "', D_Speciality='" + speciality
				+ "', D_fee='" + fee + "' WHERE D_id='" + id + ")");

	}

	public int delete(String id) throws SQLException {

		return this.jdbcTemplate.update("DELETE FROM doctor WHERE D_id='" + id + "'");

	}

}
