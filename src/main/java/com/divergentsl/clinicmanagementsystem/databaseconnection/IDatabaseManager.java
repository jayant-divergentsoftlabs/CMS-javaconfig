package com.divergentsl.clinicmanagementsystem.databaseconnection;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * This interface i.e. IDatabaseManager will give a defined username,password  and path of database. 
 * @author Jayant
 *
 */
public interface IDatabaseManager {
	String USERNAME = "spring.datasource.username";

	String PASSWORD = "spring.datasource.password";

	String URL = "spring.datasource.url";

	public Connection getConnection() throws SQLException ;
	
	}


