package de.anghenfil.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import de.anghenfil.maingame.MainGame;
import de.anghenfil.sql.SqlTools;

public class Room {
	private int roomID = 0;
	private int nextRoomN = 0;
	private int nextRoomS = 0;
	private int nextRoomE = 0;
	private int nextRoomW = 0;
	private String roomDescription = "unset";
	private ArrayList<Integer> items = null;
	
	public ArrayList<Integer> getItems() {
		return items;
	}
	public void setItems(ArrayList<Integer> itemsE) {
		this.items = itemsE;
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
		String[] items = null;
		PreparedStatement query = null;
		ArrayList<Integer> itemsE = new ArrayList<Integer>();
	    try {
	    	c = SqlTools.getConnection();
	        query = c.prepareStatement("SELECT * FROM rooms WHERE roomID = ?");
	        query.setInt(1, roomID);
	        ResultSet rs = query.executeQuery();
	        while(rs.next()){
	        	room.setRoomID(rs.getInt("roomID"));
	        	room.setNextRoomE(rs.getInt("nextRoomE"));
	        	room.setNextRoomW(rs.getInt("nextRoomW"));
	        	room.setNextRoomN(rs.getInt("nextRoomN"));
	        	room.setNextRoomS(rs.getInt("nextRoomS"));
	        	room.setRoomDescription(rs.getString("roomDescription"));
	        	try{
	        		items = rs.getString("roomItems").split(","); //TODO: ADD ERROR HANDLING IF THERE ARE NO ITEMS
	        		for(int i = 0;i<items.length;i++){
	        			itemsE.add(Integer.parseInt(items[i]));
	        		}
	        	room.setItems(itemsE);
	        	}catch(Exception e){
	        		room.setItems(null);
	        	}
	        	items = null;
	        	itemsE = new ArrayList<Integer>();
	        }
	        rs.close();
	        c.close();
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	      }
	    MainGame.setRoom(room);
	    MainGame.getUser().setAct_room(room.getRoomID());
	    return room;
	}

}
