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
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;
/**
 * This is data access object class for create,read,update and delete operation on doctor.
 * @author Jayant
 *
 */
@Repository
public class DoctorDao {
	@Autowired
	private IDatabaseManager databaseManager;


	public int create(String id, String name, String speciality, String fee) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate(
				"insert into doctor values (" + id + ", '" + name + "','" + speciality + "'," + fee + ")");

	}

	public List<DoctorDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from doctor");
		List<DoctorDto> doctorDtos = new ArrayList<>();
		while (rs.next()) {
			DoctorDto dto = new DoctorDto();
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setSpeciality(rs.getString(3));
			dto.setFee(rs.getString(4));
			doctorDtos.add(dto);
		}
		return doctorDtos;

	}

	public int update(String id, String name, String speciality, String fee) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery = "UPDATE doctor SET D_name ='" + name + "', D_Speciality='" + speciality + "', D_fee='"
				+ fee + "' WHERE D_id='" + id + "'";
		System.out.println(updateQuery);
		return stmt.executeUpdate(updateQuery);

	}

	public int delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("DELETE FROM doctor WHERE D_id='" + id + "'");

	}

}
