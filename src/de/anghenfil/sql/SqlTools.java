package de.anghenfil.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlTools {
	public static Connection getConnection() throws Exception{
		Connection c = null;
		
		Class.forName("org.sqlite.JDBC").newInstance();
		c = DriverManager.getConnection("jdbc:sqlite::resource:rooms.db");
		return c;
	}
}
