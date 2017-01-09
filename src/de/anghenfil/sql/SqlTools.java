package de.anghenfil.sql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlTools {
	public static Connection getConnection() throws Exception{
		Connection c = null;
		File path;
		
		Class.forName("org.sqlite.JDBC").newInstance();
		path = new File("data/rooms.db");
		c = DriverManager.getConnection("jdbc:sqlite::resource:rooms.db");
		return c;
	}
}
