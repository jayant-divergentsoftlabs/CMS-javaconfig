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
 * on drug.
 * 
 * @author Jayant
 *
 */
@Repository
public class DrugDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(int id, String name, int quantity, String description, int price) throws SQLException {

		return this.jdbcTemplate.update("insert into drug values (" + id + ", '" + name + "'," + quantity + ",'"
				+ description + "'," + price + ")");

	}

	public List<Map<String, Object>> read() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from drug");
		return list;
	}

	public int update(int id, String name, int quantity, String description, int price) throws SQLException {

		return this.jdbcTemplate.update("UPDATE drug SET Drug_name ='" + name + "', Drug_quantity='" + quantity
				+ "', Drug_description='" + description + "', Drug_price='" + price + "'WHERE Drug_id='" + id + "'");

	}

	public int delete(String id) throws SQLException {

		return this.jdbcTemplate.update("DELETE FROM drug WHERE Drug_id='" + id + "'");

	}

}
