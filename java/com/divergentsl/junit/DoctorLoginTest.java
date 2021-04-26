package com.divergentsl.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.DoctorloginDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

public class DoctorLoginTest {
	H2DatabaseManager drivermanager = null;
	Statement st = null;

	@BeforeEach
	void setUp() throws SQLException {
		drivermanager = new H2DatabaseManager();
		Connection con = drivermanager.getConnection();
		st = con.createStatement();
		st.execute("drop table if exists doctorlogin");
		st.execute(
				"create table if not exists doctorlogin (D_username varchar(20),D_password varchar(10),D_id varchar(10)) ");
		st.execute("insert into doctorlogin values('doctor','doctor','1')");
		System.out.println("\nDoctor Inserted");

	}

	@Test
	void doctorLoginTest() {
		DoctorloginDao doctorloginDao = new DoctorloginDao(drivermanager);
		assertTrue(doctorloginDao.doctorDao("doctor", "doctor"));

	}

	@Test
	void doctorLoginTestfail() {
		DoctorloginDao doctorloginDao = new DoctorloginDao(drivermanager);
		assertFalse(doctorloginDao.doctorDao("fjikw", "kenddm"));
		

	}
}