package de.anghenfil.maingame;
import java.util.Objects;
import de.anghenfil.gui.Window;
import de.anghenfil.messages.Messages;
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
			input = rawinput.split("\\s"); //$NON-NLS-1$
			
			String string = input[0];
			if (Messages.getString("MainControl.commands").equals(string) || Messages.getString("MainControl.help").equals(string)) {
				commandHelp(window);
			} else if (Messages.getString("MainControl.end").equals(string) || Messages.getString("MainControl.exit").equals(string)) {
				commandExit(window);
			} else if (Messages.getString("MainControl.go").equals(string)) {
				commandGehe(window, input, room);
			} else if (Messages.getString("MainControl.inspect").equals(string)) {
				RoomScripts.onInspection(room.getRoomID(), input, window);
			} else if ("devcsethp".equals(string)){
				MainGame.getUser().setHealth(Integer.parseInt(input[1]));
				
				window.addText("Changed HP.");
			}else {
				TD.error();
			}
	}
	private static void commandGehe(Window window, String[] input, Room room) {
		if(input.length <= 2){
			TD.error(Messages.getString("MainControl.wheretogo")); //$NON-NLS-1$
		}else{
		if(Objects.equals(input[1], Messages.getString("MainControl.to"))){ //$NON-NLS-1$
				String string = input[2];
				if (Messages.getString("MainControl.north").equals(string)) {
					if(room.getNextRoomN() == 0){
						TD.error(Messages.getString("MainControl.nowaynorth")); //$NON-NLS-1$
					}else{
						window.addText(Messages.getString("MainControl.gotonorth")); //$NON-NLS-1$
						room = room.loadRoom(room.getNextRoomN());
						MainGame.setRoom(room); //Sync room
						//Execute CustomCode from RoomScripts
						RoomScripts.customCode(room.getRoomID());
						TD.headline(room.getRoomName());
						TD.description(room.getRoomDescription());
					}
				} else if (Messages.getString("MainControl.south").equals(string) || "süden".equals(string)) {
					if(room.getNextRoomS() == 0){
						TD.error(Messages.getString("MainControl.nowaysouth")); //$NON-NLS-1$
					}else{
						window.addText(Messages.getString("MainControl.gotosouth")); //$NON-NLS-1$
						room = room.loadRoom(room.getNextRoomS());
						MainGame.setRoom(room);
						//Execute CustomCode from RoomScripts
						RoomScripts.customCode(room.getRoomID());
						TD.headline(room.getRoomName());
						TD.description(room.getRoomDescription());
					}
				} else if (Messages.getString("MainControl.west").equals(string)) {
					if(room.getNextRoomW() == 0){
						TD.error(Messages.getString("MainControl.nowaywest")); //$NON-NLS-1$
					}else{
						window.addText(Messages.getString("MainControl.gotowest")); //$NON-NLS-1$
						room = room.loadRoom(room.getNextRoomW());
						MainGame.setRoom(room);
						//Execute CustomCode from RoomScripts
						TD.headline(room.getRoomName());
						RoomScripts.customCode(room.getRoomID());
						TD.description(room.getRoomDescription());
					}
				} else if (Messages.getString("MainControl.east").equals(string)) {
					if(room.getNextRoomE() == 0){
						TD.error(Messages.getString("MainControl.nowayeast")); //$NON-NLS-1$
					}else{
						window.addText(Messages.getString("MainControl.gotoeast")); //$NON-NLS-1$
						room = room.loadRoom(room.getNextRoomE());
						MainGame.setRoom(room);
						//Execute CustomCode from RoomScripts
						RoomScripts.customCode(room.getRoomID());
						TD.headline(room.getRoomName());
						TD.description(room.getRoomDescription());
					}
				} else {
					TD.error();
				}
		}else{
			TD.error();
		}
		}
	}
	private static void commandExit(Window window) {
		TD.description(Messages.getString("MainControl.sleep")); //$NON-NLS-1$
		window.exit();
	}
	public static void commandHelp(Window window){
		TD.headline(Messages.getString("MainControl.helpheadline")); //$NON-NLS-1$
		TD.description(Messages.getString("MainControl.commandslist")); //$NON-NLS-1$
	}
}
