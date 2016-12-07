package de.anghenfil.maingame;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import de.anghenfil.gui.Window;
import de.anghenfil.room.Room;
import de.anghenfil.room.RoomListener;
import de.anghenfil.textdesign.TD;

public class MainControl {
	static boolean exit = false;
	static String rawinput;
	static String[] input;
	private static List<RoomListener> listeners = new ArrayList<RoomListener>();
	
	public static void addListener(RoomListener toAdd) {
        listeners.add(toAdd);
    }
	public static void checkInputs(String rawinput){
			Window window = MainGame.getWindow();
			Room room = MainGame.getRoom();
			
			
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
			case "untersuche":
				for (RoomListener rl : listeners)
		            rl.onInspection();
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
						TD.error("In n�rdlicher Richtung geht es hier nicht weiter.");
					}else{
					window.addText("Gehe nach Norden ...");
					room.loadRoom(room.getNextRoomN());
					TD.description(room.getRoomDescription());
					}
					break;
				case "sueden":
					if(room.getNextRoomS() == 0){
						TD.error("In s�dlicher Richtung geht es hier nicht weiter.");
					}else{
					window.addText("Gehe nach Süden ...");
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
						TD.error("In �stlicher Richtung geht es hier nicht weiter.");
					}else{
					window.addText("Gehe nach Osten ...");
					room.loadRoom(room.getNextRoomE());
					TD.description(room.getRoomDescription());
					}
					break;
				default:
					TD.error();
				}
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
