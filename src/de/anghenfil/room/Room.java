package de.anghenfil.room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.SystemUtils;
import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.sql.SqlTools;

public class Room {
	private int roomID = 0;
	private int nextRoomN = 0;
	private int nextRoomS = 0;
	private int nextRoomE = 0;
	private int nextRoomW = 0;
	private String roomDescription = "unset";
	private int[] items = null;
	
	public int[] getItems() {
		return items;
	}
	public void setItems(int[] items) {
		this.items = items;
	}
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
		Room room = new Room();
		Connection c = null;
		Statement stmt = null;
		String[] items = null;
		ArrayList<Integer> itemsE = new ArrayList<Integer>();
	    try {
	    	c = SqlTools.getConnection();
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM rooms"); //Change * later to the final columns
	        while(rs.next()){
	        	room.setRoomID(rs.getInt("roomID"));
	        	room.setNextRoomE(rs.getInt("nextRoomE"));
	        	room.setNextRoomW(rs.getInt("nextRoomW"));
	        	room.setNextRoomN(rs.getInt("nextRoomN"));
	        	room.setNextRoomS(rs.getInt("nextRoomS"));
	        	room.setRoomDescription(rs.getString("roomDescription"));
	        	items = rs.getString("roomItems").split(","); //TODO: ADD ERROR HANDLING IF THERE ARE NO ITEMS
	        	System.out.println(rs.getString("roomItems"));
	        	for(int i = 0;i<=items.length;i++){
	        		itemsE.add(Integer.parseInt(items[i]));
	        	}
	        	System.out.println(itemsE);
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
