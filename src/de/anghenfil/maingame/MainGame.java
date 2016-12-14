package de.anghenfil.maingame;
import de.anghenfil.user.*;
import java.awt.EventQueue;

import de.anghenfil.gui.Window;
import de.anghenfil.room.Room;

public class MainGame {
	static Room room;
	static Window window;
	public static void play(){
		EventQueue.invokeLater(new Runnable() { //Start GUI
			public void run() {
				try {
					window = new Window();
					window.initialize();
					User user = UserManager.loadUser();
					room = new Room();
					room = room.loadRoom(user.getAct_room()); //Load last visited Room from User object
					
					window.addText(room.getRoomDescription()); //Show actual room Description
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Room getRoom(){
		return room;
	}
	public static Window getWindow(){
		return window;
	}
	
}
