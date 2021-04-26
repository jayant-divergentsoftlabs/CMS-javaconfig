package com.divergentsl.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.AdminDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

class AdminLoginTest {

	H2DatabaseManager driverManager = null;
	Statement st = null;
	
	@BeforeEach
	void setUp() throws SQLException {
		driverManager = new H2DatabaseManager();
		Connection con = driverManager.getConnection();
		st = con.createStatement();
		
		st.execute("drop table if exists admin");
		st.execute("create table if not exists admin (A_username varchar(30), A_password varchar(30))");
		st.execute("insert into admin values('admin', 'admin')");
		System.out.println("data inserted");

	}
	
	@Test
	void adminLoginTest() {
		
		AdminDao adminDao = new AdminDao();
		assertTrue(adminDao.adminDao("admin", "admin")); //assertequal(Expected,real);
	}
	
	
}
