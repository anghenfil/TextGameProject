package de.anghenfil.maingame;
import de.anghenfil.user.*;
import java.awt.EventQueue;

import de.anghenfil.gui.Window;
import de.anghenfil.room.Room;
import de.anghenfil.sql.RoomSQL;

public class MainGame {
	static Window window;
	static Room room;
	public static void play(){
		User user = UserManager.loadUser();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					room = new Room();
					window = new Window();
					
					room = room.loadRoom(user.getAct_room()); //Load last visited Room from User object
					window.initialize();
					window.addText("Willkommen!"); //Welcome message
					window.addText(room.getRoomDescription()); //Show actual room Description
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Window getWindow() {
		return window;
	}
	public static Room getRoom(){
		return room;
	}
	
}
