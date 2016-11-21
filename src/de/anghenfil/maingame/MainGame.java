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
					room = room.loadRoom(user.getAct_room());
					window = new Window();
					window.initialize();
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
