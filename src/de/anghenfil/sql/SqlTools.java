package de.anghenfil.sql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import de.anghenfil.mainmenu.MainMenu;

public class SqlTools {
	public static Connection getConnection() throws Exception{
		Connection c = null;
		File path;
		
		Class.forName("org.sqlite.JDBC");
		path = new File(MainMenu.getPath(), "rooms.db");
		c = DriverManager.getConnection("jdbc:sqlite:"+path);
		return c;
	}
}
