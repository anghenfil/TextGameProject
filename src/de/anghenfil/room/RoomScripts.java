	package de.anghenfil.room;

import de.anghenfil.gui.Window;
import de.anghenfil.maingame.MainGame;
import de.anghenfil.messages.Messages;
import de.anghenfil.textdesign.TD;

public class RoomScripts{
	
	public static void onInspection(int roomID, String[] input, Window window){
		switch(roomID){
		//ROOM 1
		case 1:
			if(input.length <= 1){
				TD.error((Messages.getString("Error.whattoinspect"))); //$NON-NLS-1$
			}else{
				String string = input[1];
				if (Messages.getString("RoomScript.Bookshelf").toLowerCase().equals(string) || Messages.getString("RoomScript.Bookshelfs").toLowerCase().equals(string)) {
					window.addText(Messages.getString("RoomScript.Bookshelfdescription")); //$NON-NLS-1$
				} else if (Messages.getString("RoomScript.pendulumclock").toLowerCase().equals(string) || Messages.getString("RoomScript.clock").toLowerCase().equals(string)) {
					window.addText(Messages.getString("RoomScript.pendulumclockdescription")); //$NON-NLS-1$
				} else if (Messages.getString("RoomScript.desk").toLowerCase().equals(string)) {
					window.addText(Messages.getString("RoomScript.deskdescription")); //$NON-NLS-1$
				} else {
					TD.error(Messages.getString("Error.cantinspect")); //$NON-NLS-1$
				}
			}
			break;
			
		//ROOM 2
		case 2:
		}
	}
	public static void customCode(int roomID){
		switch(roomID){
		case 1:
			if(!MainGame.getUser().hasBracket(1)){
				TD.description(Messages.getString("RoomScript.Bracket1.description") //$NON-NLS-1$
						+ Messages.getString("RoomScript.Bracket1.description2")); //$NON-NLS-1$
			}
			break;
		case 2:
			if(!MainGame.getUser().hasBracket(1)){
				MainGame.getUser().addBracket(1);
			}
			break;
		}
	}
}
