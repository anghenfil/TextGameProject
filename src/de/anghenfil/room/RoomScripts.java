package de.anghenfil.room;

import de.anghenfil.gui.Window;
import de.anghenfil.maingame.MainGame;
import de.anghenfil.textdesign.TD;

public class RoomScripts{
	
	public static void onInspection(int roomID, String[] input, Window window){
		switch(roomID){
		//ROOM 1
		case 1:
			if(input.length <= 1){
				window.addText("Was möchtest du untersuchen?");
			}else{
				switch(input[1]){
					case "Bücherregale":
					case "Bücherregal":
						window.addText("«Die gesammelten Werke meiner Bücher»");
						break;
					case "Pendeluhr":
						window.addText("«Genauigkeit ist wichtig.»");
						break;
					case "Schreibtisch":
						window.addText("«Hier muss auch mal wieder aufgeräumt werden.»");
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
					default:
						window.addText("Das kannst du hier nicht untersuchen.");
				}
			}	
		}
	}
	public static void customCode(int roomID){
		switch(roomID){
		case 1:
			if(!MainGame.getUser().hasBracket(1)){
				TD.description("Vor mir liegt der Stapel mit den Akten meiner letzten Fälle. "
						+ "Gelangweilt schaue ich auf die tickende Pendeluhr an der Wand. «Schon fünf vor acht und noch immer kein neuer Fall ...»");
			}
			break;
		}
	}
}
