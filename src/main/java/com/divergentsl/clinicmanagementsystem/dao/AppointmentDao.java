package com.divergentsl.clinicmanagementsystem.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This is data access object class for create and read appointment
 * 
 * @author Jayant
 *
 */
@Repository
public class AppointmentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(String appointmentId, String patientName, String doctorId, String problem, String appointmentDate,
			String appointmentTime) throws SQLException {

		return this.jdbcTemplate.update("INSERT INTO appointment values('" + appointmentId + "','" + patientName + "','"
				+ doctorId + "','" + problem + "','" + appointmentDate + "','" + appointmentTime + "')");

	}

	public List<Map<String, Object>> read() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from appointment");
		return list;

	}
}
