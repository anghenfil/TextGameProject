package de.anghenfil.mainmenu;
import de.anghenfil.user.*;
import de.anghenfil.gui.CharacterCreation;
import de.anghenfil.maingame.MainGame;
import java.awt.EventQueue;
import java.io.File;
import java.util.Locale;

public class MainMenu {
	public static final String PATH = System.getProperty("user.home")+"/AppData/Roaming/TextGameProject"; //$NON-NLS-1$ //$NON-NLS-2$
	static File destDir = new File(PATH);
	static boolean createnew; //True if no save file exists
	static Locale locale = new Locale("de", "DE"); //CHANGE LANGUAGE HERE //$NON-NLS-1$ //$NON-NLS-2$
	
	public static void main(String[] args) {
		if(!destDir.exists()){
		destDir.mkdir();
		}
			createnew = UserManager.checkUserData(); //Check if User file already exists
			if(createnew){ //If new user needed
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CharacterCreation window = new CharacterCreation();
							window.frmTheTextgameproject.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}else if(createnew == false){
				MainGame.play(); //Start game
			}
	}
	public static boolean getCreatenew() {
		return createnew;
	}
	public static void setCreatenew(boolean createnew) {
		MainMenu.createnew = createnew;
	}
	public static File getPath(){
		return destDir;
	}
	public static Locale getLocale(){
		return locale;
	}

}
