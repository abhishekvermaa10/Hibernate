package com.scaleupindia.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author abhishekvermaa10
 *
 */
public class DatabaseConfig {
	private static final String DATABASE_DRIVER = "database.driver";
	private static final String DATABASE_URL = "database.url";
	private static final String DATABASE_USERNAME = "database.username";
	private static final String DATABASE_PASSWORD = "database.password";

	private DatabaseConfig() {
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		PropertiesConfig propertiesConfig = PropertiesConfig.getInstance();
		String url = propertiesConfig.getProperty(DATABASE_URL);
		String username = propertiesConfig.getProperty(DATABASE_USERNAME);
		String password = propertiesConfig.getProperty(DATABASE_PASSWORD);
		Class.forName(propertiesConfig.getProperty(DATABASE_DRIVER));
		return DriverManager.getConnection(url, username, password);
	}
}