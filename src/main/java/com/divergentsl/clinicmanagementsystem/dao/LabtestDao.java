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
 * on labtest.
 * 
 * @author Jayant
 *
 */
@Repository
public class LabtestDao {
	@Autowired
	 JdbcTemplate jdbcTemplate;

	public int create(int id, String name, int price) throws SQLException {

		return this.jdbcTemplate.update("insert into labtest values ('" + id + "', '" + name + "','" + price + "')");

	}

	public List<Map<String, Object>> read() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from labtest");
		return list;
	}

	public int update(int id, String name, int price) throws SQLException {

		return this.jdbcTemplate.update(
				"UPDATE labtest SET Test_name ='" + name + "',Test_price='" + price + "' WHERE Test_id='" + id + "'");

	}

	public int delete(String id) throws SQLException {

		return this.jdbcTemplate.update("DELETE FROM labtest WHERE Test_id='" + id + "'");

	}

}
