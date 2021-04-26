package com.divergentsl.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

public class AppointmentDaoTest {
	H2DatabaseManager driverManager = null;
	Statement st = null;

	@BeforeEach
	void setUp() throws SQLException {
		driverManager = new H2DatabaseManager();
		Connection con = driverManager.getConnection();
		st = con.createStatement();

		st.execute("drop table if exists appointment");
		st.execute("create table if not exists appointment(appointment_id varchar(10),patient_name varchar(45),Dr_id varchar(10),Problem varchar(80),appointment_date varchar(10),appointment_time varchar(10))");

		st.execute("insert into appointment values('450','joy','78','stomach','28april','7AM')");

		System.out.println("data inserted\n");

	}
@Test
void createAppointment() throws SQLException {
	AppointmentDao appointmentDao=new AppointmentDao(driverManager);
	assertEquals(1, appointmentDao.create("450","joy","78","stomach","28april","7AM"));
}
	
@Test
void readAppointment() throws SQLException{
	AppointmentDao appointmentDao=new AppointmentDao(driverManager);
	 assertFalse(appointmentDao.read().isEmpty());
}
@Test
void bookedAppointment() throws SQLException{
	AppointmentDao appointmentDao=new AppointmentDao(driverManager);
	assertFalse(appointmentDao.read().isEmpty());
}
}
