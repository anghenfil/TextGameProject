package de.anghenfil.maingame;
import java.util.Objects;
import de.anghenfil.gui.Window;
import de.anghenfil.room.Room;
import de.anghenfil.room.RoomScripts;
import de.anghenfil.textdesign.TD;

public class MainControl {
	static boolean exit = false;
	static String rawinput;
	static String[] input;
	public static void checkInputs(String rawinput){
			Window window = MainGame.getWindow();
			Room room = MainGame.getRoom();
			
			//Handle input
			rawinput = rawinput.toLowerCase();
			input = rawinput.split("\\s");
			
			switch(input[0]){
				case "commands":
				case "hilfe":
					commandHelp(window);
					break;
				case "ende":
				case "exit":
					commandExit(window);
					break;
				case "gehe":
					commandGehe(window, input, room);
					break;
				case "untersuche":
					RoomScripts.onInspection(room.getRoomID(), input, window);
					break;
				default:
					TD.error();
					break;
			}
	}
	private static void commandGehe(Window window, String[] input, Room room) {
		if(input.length <= 2){
			TD.error("Wohin möchtest du gehen?");
		}else{
		if(Objects.equals(input[1], "nach")){
				switch(input[2]){
				case "norden":
					if(room.getNextRoomN() == 0){
						TD.error("In nördlicher Richtung geht es hier nicht weiter.");
					}else{
						window.addText("Gehe nach Norden ...");
						room = room.loadRoom(room.getNextRoomN());
						//Execute CustomCode from RoomScripts
						RoomScripts.customCode(room.getRoomID());
						TD.headline(room.getRoomName());
						TD.description(room.getRoomDescription());
					}
					break;
				case "sueden":
					if(room.getNextRoomS() == 0){
						TD.error("In südlicher Richtung geht es hier nicht weiter.");
					}else{
						window.addText("Gehe nach Süden ...");
						room = room.loadRoom(room.getNextRoomS());
						//Execute CustomCode from RoomScripts
						RoomScripts.customCode(room.getRoomID());
						TD.headline(room.getRoomName());
						TD.description(room.getRoomDescription());
					}
					break;
				case "westen":
					if(room.getNextRoomW() == 0){
						TD.error("In westlicher Richtung geht es hier nicht weiter.");
					}else{
						window.addText("Gehe nach Westen ...");
						room = room.loadRoom(room.getNextRoomW());
						//Execute CustomCode from RoomScripts
						TD.headline(room.getRoomName());
						RoomScripts.customCode(room.getRoomID());
						TD.description(room.getRoomDescription());
					}
					break;
				case "osten":
					if(room.getNextRoomE() == 0){
						TD.error("In östlicher Richtung geht es hier nicht weiter.");
					}else{
						window.addText("Gehe nach Osten ...");
						room = room.loadRoom(room.getNextRoomE());
						//Execute CustomCode from RoomScripts
						RoomScripts.customCode(room.getRoomID());
						TD.headline(room.getRoomName());
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
		TD.description("Du schläfst langsam ein und verlässt diese Welt.");
		window.exit();
	}
	public static void commandHelp(Window window){
		TD.headline("Hilfe");
		TD.description("Befehle:\ngehe nach osten/westen/sueden/norden\nexit\nende\nhelp\nhilfe");
	}
}
