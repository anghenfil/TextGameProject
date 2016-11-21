package de.anghenfil.sql;
import java.sql.*;

import org.apache.commons.lang3.SystemUtils;

import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.room.Room;

public class RoomSQL {
	
	public static boolean roomExist(int roomID){
		boolean Roomexist = false;
		Connection c = null;
		String path = "unset";
		try{
			Class.forName("org.sqlite.JDBC");
			if(SystemUtils.IS_OS_WINDOWS == true){
	        	path = MainMenu.getPath()+"\\rooms.db";
	        }else{
	        	path = MainMenu.getPath()+"/rooms.db";
	        }
			c = DriverManager.getConnection("jdbc:sqlite:"+path);PreparedStatement ps = c.prepareStatement("SELECT * FROM rooms WHERE roomID = ?"); //Change * later to the final columns
			ps.setInt(1, roomID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Roomexist = true;
			}
		}catch(Exception e){
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
		}
		return Roomexist;
	}public static void saveRoom(int roomID, int nextRoomE, int nextRoomW, int nextRoomN, int nextRoomS, String roomDescription){
		Connection c = null;
		String path = "unset";
		try{
		Class.forName("org.sqlite.JDBC");
		
		if(SystemUtils.IS_OS_WINDOWS == true){
        	path = MainMenu.getPath()+"\\rooms.db";
        }else{
        	path = MainMenu.getPath()+"/rooms.db";
        }
		c = DriverManager.getConnection("jdbc:sqlite:"+path);
        PreparedStatement ps = c.prepareStatement("INSERT INTO rooms (roomID, nextRoomE, nextRoomW, nextRoomN, nextRoomS, roomDescription) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setInt(1, roomID);
        ps.setInt(2, nextRoomE);
        ps.setInt(3, nextRoomW);
        ps.setInt(4, nextRoomN);
        ps.setInt(5, nextRoomS);
        ps.setString(6, roomDescription);
        ps.executeQuery();
        ps.close();
        c.close();
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
      }
	}
}
