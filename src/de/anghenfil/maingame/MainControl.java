package de.anghenfil.maingame;
import java.util.Objects;
import de.anghenfil.gui.Window;
import de.anghenfil.room.Room;
import de.anghenfil.sql.RoomSQL;
import de.anghenfil.textdesign.TD;

public class MainControl {
	static boolean exit = false;
	static String rawinput;
	static String[] input;
	public static Room room;
	//User user = UserManager.loadUser();
	public static void setRoom(Room roomi){
		room = roomi;
	}
	public static void checkInputs(String rawinput){
			Window window = MainGame.getWindow();
			rawinput = rawinput.toLowerCase();
			input = rawinput.split("\\s");
			switch(input[0]){
			case "commands":
			case "hilfe":
			case "help":
				commandHelp(window);
				break;
			case "ende":
			case "exit":
				commandExit(window);
				break;
			case "gehe":
				commandGehe(window, input, room);
				break;
			default:
				//TD.error(window);
				break;
			}
	}
	private static void commandGehe(Window window, String[] input, Room room) {
		if(Objects.equals(input[1], "nach")){
			if(input.length > 2){
				switch(input[2]){
				case "norden":
					if(room.getNextRoomN() == 0){
						TD.error("In nördlicher Richtung geht es hier nicht weiter.");
					}else{
					window.addText("Gehe nach Norden ...");
					room.loadRoom(room.getNextRoomN());
					TD.description(room.getRoomDescription());
					}
					break;
				case "sueden":
					if(room.getNextRoomS() == 0){
						TD.error("In südlicher Richtung geht es hier nicht weiter.");
					}else{
					window.addText("Gehe nach SÃ¼den ...");
					room.loadRoom(room.getNextRoomS());
					TD.description(room.getRoomDescription());
					}
					break;
				case "westen":
					if(room.getNextRoomW() == 0){
						TD.error("In westlicher Richtung geht es hier nicht weiter.");
					}else{
					window.addText("Gehe nach Westen ...");
					room.loadRoom(room.getNextRoomW());
					TD.description(room.getRoomDescription());
					}
					break;
				case "osten":
					if(room.getNextRoomE() == 0){
						TD.error("In östlicher Richtung geht es hier nicht weiter.");
					}else{
					window.addText("Gehe nach Osten ...");
					room.loadRoom(room.getNextRoomE());
					TD.description(room.getRoomDescription());
					}
					break;
				default:
					TD.error();
				}
			}else{
				TD.error();
			}
		}
	}
	private static void commandExit(Window window) {
		TD.description("Du schlÃ¤fst langsam ein und verlÃ¤sst diese Welt.");
		exit = true;
	}
	public static void commandHelp(Window window){
		TD.headline("Hilfe");
		TD.description("Befehle:\ngehe nach osten/westen/sueden/norden\nexit\nende\nhelp\nhilfe");
	}
}
