package com.divergentsl.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

public class DoctorDaoTest {
  H2DatabaseManager driverManager=null;
  Statement st=null;
  
  @BeforeEach
  void setUp() throws SQLException{
	  driverManager = new H2DatabaseManager();
	  Connection con=driverManager.getConnection();
	  st=con.createStatement();
	  
	  st.execute("Drop table if exists doctor");
	  st.execute("create table if not exists doctor(D_id varchar(10),D_name varchar(30),D_Speciality varchar(40),D_fee int)");
	  st.execute("insert into doctor values('101','MK Gandhi','Dentist','450')");
	  System.out.println("Inserted");
	  
  }
  @Test
  void DoctorCreateTest() throws SQLException {
	  DoctorDao doctorDao=new DoctorDao(driverManager);
	  assertEquals(1, doctorDao.create("101", "MK Gandhi", "Dentist", "450"));
  }
  @Test
  void DoctorReadTest() throws SQLException{
	  DoctorDao doctorDao=new DoctorDao(driverManager);
	  assertFalse(doctorDao.read().isEmpty());
  }
  @Test
  void DoctorUpdateTest() throws SQLException{
	  DoctorDao doctorDao=new DoctorDao(driverManager);
	  assertEquals(1, doctorDao.update("101","GK","fracture", "500") );
  }
	  @Test
	  void DoctorDeleteTest() throws SQLException{
	  DoctorDao doctorDao=new DoctorDao(driverManager);
	  assertEquals(1, doctorDao.delete("101"));
	  }
  }

	  

  


