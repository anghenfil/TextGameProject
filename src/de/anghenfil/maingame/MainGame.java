package de.anghenfil.maingame;
import de.anghenfil.user.*;
import de.anghenfil.textdesign.*;
import de.anghenfil.gui.Window;
import de.anghenfil.room.Room;
import de.anghenfil.sql.*;

public class MainGame {
	public static void play(User user){
		//TD.headline("The TextGame Project V0.1");
		Window.main(null);
		Room room = new Room();
		room = RoomSQL.loadRoom(1); //Later load last room from user
		MainControl.setRoom(room);
	}
}
