package de.anghenfil.maingame;
import java.util.Objects;
import java.util.Scanner;

import de.anghenfil.gui.Window;
import de.anghenfil.room.Room;
import de.anghenfil.sql.RoomSQL;
import de.anghenfil.textdesign.TD;

public class MainControl {
	static boolean exit = false;
	static String rawinput;
	static String[] input;
	public static Room room;
	public static void setRoom(Room roomi){
		room = roomi;
	}
	public static void checkInputs(String rawinput){
			rawinput = rawinput.toLowerCase();
			input = rawinput.split("\\s");
			switch(input[0]){
			case "commands":
			case "hilfe":
			case "help":
				window.addText("Test");
				commandHelp();
				break;
			case "ende":
			case "exit":
				commandExit();
				break;
			case "gehe":
				commandGehe(input, room);
				break;
			case "character":
				commandCharacterGUI();
				break;
			default:
				TD.error();
				break;
			}
	}
	private static void commandCharacterGUI(){
		System.out.println("Test");
	}
	private static void commandGehe(String[] input, Room room) {
		if(Objects.equals(input[1], "nach")){
			switch(input[2]){
			case "norden":
				if(room.getNextRoomN() == 0){
					TD.error("In n�rdlicher Richtung geht es hier nicht weiter.");
				}else{
				System.out.println("Gehe nach Norden ...");
				RoomSQL.loadRoom(room.getNextRoomN());
				TD.description(room.getRoomDescription());
				}
				break;
			case "sueden":
				if(room.getNextRoomS() == 0){
					TD.error("In s�dlicher Richtung geht es hier nicht weiter.");
				}else{
				System.out.println("Gehe nach Süden ...");
				RoomSQL.loadRoom(room.getNextRoomS());
				TD.description(room.getRoomDescription());
				}
				break;
			case "westen":
				if(room.getNextRoomW() == 0){
					TD.error("In westlicher Richtung geht es hier nicht weiter.");
				}else{
				System.out.println("Gehe nach Westen ...");
				RoomSQL.loadRoom(room.getNextRoomW());
				TD.description(room.getRoomDescription());
				}
				break;
			case "osten":
				if(room.getNextRoomE() == 0){
					TD.error("In �stlicher Richtung geht es hier nicht weiter.");
				}else{
				System.out.println("Gehe nach Osten ...");
				RoomSQL.loadRoom(room.getNextRoomE());
				TD.description(room.getRoomDescription());
				}
				break;
			default:
				TD.error();
			}
		}
	}
	private static void commandExit() {
		TD.description("Du schläfst langsam ein und verlässt diese Welt.");
		exit = true;
	}
	public static void commandHelp(){
		TD.headline("Hilfe");
		TD.description("Befehle:\ngehe nach osten/westen/sueden/norden\nexit\nende\nhelp\nhilfe");
	}
}
