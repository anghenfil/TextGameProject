package de.anghenfil.maingame;
import de.anghenfil.user.*;
import java.awt.EventQueue;

import de.anghenfil.gui.Window;
import de.anghenfil.room.Room;
import de.anghenfil.room.RoomScripts;
import de.anghenfil.textdesign.TD;
//TODO: export messages in language files -> multi lang support
public class MainGame {
	static Room room;
	static Window window;
	static User user;
	public static void play(){
		EventQueue.invokeLater(new Runnable() { //Start GUI
			public void run() {
				try {
					user = UserManager.loadUser();
					
					window = new Window();
					window.initialize();
					
					room = new Room();
					room = room.loadRoom(user.getAct_room()); //Load last visited Room from User object
					TD.headline(room.getRoomName());
					RoomScripts.customCode(room.getRoomID());
					TD.description(room.getRoomDescription()); //Show actual room Description
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Room getRoom(){
		return room;
	}
	public static void setRoom(Room room1){
		room = room1;
	}
	public static Window getWindow(){
		return window;
	}
	public static User getUser(){
		return user;
	}
	
}
