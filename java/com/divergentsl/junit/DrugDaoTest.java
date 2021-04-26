package com.divergentsl.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.DrugDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

public class DrugDaoTest {
	H2DatabaseManager driverManager = null;
	Statement st = null;

	@BeforeEach
	void setUp() throws SQLException {
		driverManager = new H2DatabaseManager();
		Connection con = driverManager.getConnection();
		st = con.createStatement();

		st.execute("drop table if exists drug");
		st.execute("create table if not exists drug (Drug_id int,Drug_name varchar(50),Drug_quantity int,Drug_description varchar(100),Drug_price int)");

		st.execute("insert into drug values(12,'vicks',12,'Cough',12)");

		System.out.println("data inserted\n");

	}
	@Test
	void DrugCreateTest() throws SQLException {
		DrugDao drugDao = new DrugDao(driverManager);
		assertEquals(1, drugDao.create(12, "joy", 78, "Lotion", 1));

	}
	@Test
	void DrugReadTest() throws SQLException{
		DrugDao drugDao = new DrugDao(driverManager);
		assertFalse(drugDao.read().isEmpty());
	}
	@Test
	void DrugUpdateTest() throws SQLException{
		DrugDao drugDao = new DrugDao(driverManager);
		assertEquals(1, drugDao.update(12, "Monster", 58, "Energy", 5));
		
	}
	@Test
	void DrugDeleteTest() throws SQLException{
		DrugDao drugDao = new DrugDao(driverManager);
		assertEquals(1, drugDao.delete("12"));
	}
}
