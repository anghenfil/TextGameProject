package de.anghenfil.room;

import de.anghenfil.gui.Window;

public class RoomScripts{
	
	public static void onInspection(int roomID, String[] input, Window window){
		switch(roomID){
		//ROOM 1
		case 1:
			if(input.length <= 1){
				window.addText("Was möchtest du untersuchen?");
			}else{
				switch(input[1]){
					case "boden":
						window.addText("Auf dem Boden liegt ein goldener Schlüssel.");
						break;
					default:
						window.addText("Das kannst du hier nicht untersuchen.");
				}
			}
			break;
			
		//ROOM 2
		case 2:
			if(input.length <= 1){
				window.addText("Was möchtest du untersuchen?");
			}else{
				switch(input[1]){
					case "boden":
						window.addText("Auf dem Boden liegt ein goldener Schlüssel.");
						break;
					default:
						window.addText("Das kannst du hier nicht untersuchen.");
				}
			}	
		}
	}
	public static void customCode(int roomID){
		switch(roomID){
		//Custom Room Code comes here
		}
	}
	
}
