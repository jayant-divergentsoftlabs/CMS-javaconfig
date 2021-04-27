package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This is data access object class for read patient list.
 * 
 * @author Jayant
 *
 */
@Repository
public class ListpatientDao {

	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> read() throws SQLException {

		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from patient");
		return list;

	}
}
