package com.divergentsl.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.PrescriptionDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

public class PrescriptionDaoTest {
	H2DatabaseManager driverManager = null;
	Statement st = null;

	@BeforeEach
	void setUp() throws SQLException {
		driverManager = new H2DatabaseManager();
		Connection con = driverManager.getConnection();
		st = con.createStatement();

		st.execute("Drop table if exists prescription");
		st.execute(
				"create table if not exists prescription(drug_name varchar(30),Drug_mg int,Drug_Quanity int,Drug_days int,Lab_test varchar(30),notes varchar(100))");
		st.execute("insert into prescription values('Aciloc',350,42,21,'NA','Dont eat junk food')");
		System.out.println("Inserted");

	}

	@Test
	void prescriptionCreate() throws SQLException {
		PrescriptionDao prescriptiondao = new PrescriptionDao(driverManager);
		assertEquals(1, prescriptiondao.create("Aciloc", 350, 42, 21, "NA", "Dont eat junk food"));
	}

}
