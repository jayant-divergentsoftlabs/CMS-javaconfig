package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;

/**
 * This is data access object class for create and read appointment
 * 
 * @author Jayant
 *
 */
@Repository
public class AppointmentDao {
	@Autowired
	private IDatabaseManager databaseManager;


	public int create(String appointmentId, String patientName, String doctorId, String problem, String appointmentDate,
			String appointmentTime) throws SQLException {

		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery = ("INSERT INTO appointment values('" + appointmentId + "','" + patientName + "','"
				+ doctorId + "','" + problem + "','" + appointmentDate + "','" + appointmentTime + "')");
		return stmt.executeUpdate(updateQuery);
	}

	public List<AppointmentDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from appointment");
		List<AppointmentDto> appointmentDtos = new ArrayList<>();
		AppointmentDto dto = new AppointmentDto();
		while (rs.next()) {
			dto.setAppointmentId(rs.getString(1));
			dto.setPatientname(rs.getString(2));
			dto.setDrId(rs.getString(3));
			dto.setProblem(rs.getString(4));
			dto.setAppointmentDate(rs.getString(5));
			dto.setAppointmentTime(rs.getString(6));
			appointmentDtos.add(dto);
		}
		return appointmentDtos;
	}

}
