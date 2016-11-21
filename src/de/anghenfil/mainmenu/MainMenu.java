package de.anghenfil.mainmenu;
import de.anghenfil.user.*;
import de.anghenfil.editor.*;
import de.anghenfil.gui.Window;
import de.anghenfil.maingame.MainGame;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import de.anghenfil.textdesign.*;

public class MainMenu {
	static String path = System.getProperty("user.home")+"/AppData/Roaming/TextGameProject";
	static File destDir = new File(System.getProperty("user.home")+"/AppData/Roaming/TextGameProject");
	static Window window;
	static boolean createnew; //True if no save file exists
	
	public static boolean getCreatenew() {
		return createnew;
	}
	public static void setCreatenew(boolean createnew) {
		MainMenu.createnew = createnew;
	}
	public static void main(String[] args) {
		String decision = null;
		Path save = Paths.get(path);
		Scanner sc = new Scanner(System.in);
		File srcDir = new File("data/");
		
		if(!Files.exists(save)){
			try{
				FileUtils.copyDirectory(srcDir, destDir);
			}catch(IOException e){
					TD.error("Fatal Error. Can't copy Data Files."+e);
					System.exit(0);
			}
		}
		EventQueue.invokeLater(new Runnable() { //Start GUI
			public void run() {
				try {
					window = new Window();
					window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//TODO: Integrate Starting in GUI
		System.out.println("Editor oder Spiel starten?");
		decision = sc.next();
		decision = decision.toLowerCase(); //Making input lower case
		switch(decision){
		case "editor":
			Editor.editor();
			break;
		case "spiel":
			createnew = UserManager.checkUserData(); //Check if User file already exists
			if(createnew){ //If new user needed
				UserManager.userCreation(); //Start User Creation
				MainGame.play(window);//Start game
			}else if(createnew == false){
				MainGame.play(window); //Starts game
			}
			break;
		default:
			main(args);
		}
		sc.close();
	}
	public static File getPath(){
		return destDir;
	}	
	public static Window getWindow(){
		return window;
	}

}
