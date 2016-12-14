package de.anghenfil.mainmenu;
import de.anghenfil.user.*;
import de.anghenfil.gui.CharacterCreation;
import de.anghenfil.maingame.MainGame;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import de.anghenfil.textdesign.*;

public class MainMenu {
	public static final String PATH = System.getProperty("user.home")+"/AppData/Roaming/TextGameProject";
	static File destDir = new File(PATH);
	static boolean createnew; //True if no save file exists
	
	public static void main(String[] args) {
		Path save = Paths.get(PATH);
		File srcDir = new File("data/");
		
		if(!Files.exists(save)){
			try{
				FileUtils.copyDirectory(srcDir, destDir);
			}catch(IOException e){
					TD.error("Fatal Error. Can't copy Data Files."+e);
					System.exit(0);
			}
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

}
