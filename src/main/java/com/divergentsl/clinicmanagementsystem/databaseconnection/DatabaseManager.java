package com.divergentsl.clinicmanagementsystem.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * This class DatabaseManager implements IDatabaseManager interface and
 * establish connection for database.
 * 
 * @author Jayant
 *
 */

@Component
public class DatabaseManager implements IDatabaseManager {

	@Autowired
	Environment env;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.exit(100);
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(env.getProperty(URL), env.getProperty(USERNAME), env.getProperty(PASSWORD));
	}}
