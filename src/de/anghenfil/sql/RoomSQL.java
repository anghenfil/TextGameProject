package de.anghenfil.sql;
import java.sql.*;
import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.room.Room;

public class RoomSQL {
	
	public static boolean roomExist(int roomID){
		boolean Roomexist = false;
		Connection c = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+MainMenu.getPath()+"\\rooms.db");
			PreparedStatement ps = c.prepareStatement("SELECT * FROM rooms WHERE roomID = ?"); //Change * later to the final columns
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
		
		try{
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:"+MainMenu.getPath()+"\\rooms.db");
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
