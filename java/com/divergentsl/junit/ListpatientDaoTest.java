package com.divergentsl.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.ListpatientDao;

import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

public class ListpatientDaoTest {
	H2DatabaseManager driverManager = null;
	Statement st = null;

	@BeforeEach
	void setUp() throws SQLException {
		driverManager = new H2DatabaseManager();
		Connection con = driverManager.getConnection();
		st = con.createStatement();

		st.execute("drop table if exists patient");
		st.execute(
				"create table if not exists patient(P_id varchar(10),P_name varchar(30),P_age int,P_Gender char(1),P_contactnumber varchar(10),P_weight int);");

		st.execute("insert into patient values('450','joy',78,'M','7772972825',85)");

		System.out.println("data inserted\n");

	}
	@Test
	void PatientReadTest() throws SQLException {
		ListpatientDao patientDao = new ListpatientDao(driverManager);
		assertFalse(patientDao.read().isEmpty());

	}

}
