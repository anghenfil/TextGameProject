package de.anghenfil.room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.lang3.SystemUtils;
import de.anghenfil.mainmenu.MainMenu;

public class Room {
	private int roomID;
	private int nextRoomN;
	private int nextRoomS;
	private int nextRoomE;
	private int nextRoomW;
	private String roomDescription;
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public int getNextRoomN() {
		return nextRoomN;
	}
	public void setNextRoomN(int nextRoomN) {
		this.nextRoomN = nextRoomN;
	}
	public int getNextRoomS() {
		return nextRoomS;
	}
	public void setNextRoomS(int nextRoomS) {
		this.nextRoomS = nextRoomS;
	}
	public int getNextRoomE() {
		return nextRoomE;
	}
	public void setNextRoomE(int nextRoomE) {
		this.nextRoomE = nextRoomE;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	public int getNextRoomW() {
		return nextRoomW;
	}
	public void setNextRoomW(int nextRoomW) {
		this.nextRoomW = nextRoomW;
	}public Room loadRoom(int roomID){
		String path = "unset";
		Room room = new Room();
		Connection c = null;
		Statement stmt = null;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        if(SystemUtils.IS_OS_WINDOWS == true){
	        	path = MainMenu.getPath()+"\\rooms.db";
	        }else{
	        	path = MainMenu.getPath()+"/rooms.db";
	        }
			c = DriverManager.getConnection("jdbc:sqlite:"+path);
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM rooms"); //Change * later to the final columns
	        while(rs.next()){
	        	room.setRoomID(rs.getInt("roomID"));
	        	room.setNextRoomE(rs.getInt("nextRoomE"));
	        	room.setNextRoomW(rs.getInt("nextRoomW"));
	        	room.setNextRoomN(rs.getInt("nextRoomN"));
	        	room.setNextRoomS(rs.getInt("nextRoomS"));
	        	room.setRoomDescription(rs.getString("roomDescription"));
	        }
	        rs.close();
	        stmt.close();
	        c.close();
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	      }
	    return room;
	}

}
