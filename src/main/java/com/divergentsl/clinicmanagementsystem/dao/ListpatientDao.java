package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;
/**
 * This is data access object class for read patient list.
 * @author Jayant
 *
 */
@Repository
public class ListpatientDao {
	
	public IDatabaseManager databaseManager;

	

	public List<PatientDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from patient");
		List<PatientDto> patientDtos = new ArrayList<>();
		while (rs.next()) {
			PatientDto dto = new PatientDto();
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getInt(3));
			dto.setGender(rs.getString(4));
			dto.setContactnumber(rs.getString(5));
			dto.getWeight();
			patientDtos.add(dto);
		}
		return patientDtos;

	}

}
