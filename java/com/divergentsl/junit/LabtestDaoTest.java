package com.divergentsl.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

public class LabtestDaoTest {
	H2DatabaseManager driverManager = null;
	Statement st = null;

	@BeforeEach
	void setUp() throws SQLException {
		driverManager = new H2DatabaseManager();
		Connection con = driverManager.getConnection();
		st = con.createStatement();

		st.execute("drop table if exists labtest");
		st.execute("create table if not exists labtest (Test_id int,Test_name varchar(50),Test_price int)");

		st.execute("insert into labtest values(11,'Blood',78)");

		System.out.println("data inserted\n");

	}
@Test
void LabtestCreate() throws SQLException {
	LabtestDao labtestDao=new LabtestDao(driverManager);
	assertEquals(1, labtestDao.create(11, "Blood", 78));
	
}
@Test
void LabtestRead() throws SQLException{
	LabtestDao labtestDao=new LabtestDao(driverManager);
	assertFalse(labtestDao.read().isEmpty());
}
	
	@Test
	void LabtestUpdate() throws SQLException{
		LabtestDao labtestDao=new LabtestDao(driverManager);
		assertEquals(1, labtestDao.update(11, "X-Ray", 58));
	}
	@Test
	void LabtestDelete() throws SQLException{
		LabtestDao labtestDao=new LabtestDao(driverManager);
		assertEquals(1, labtestDao.delete("11"));
	}
}

