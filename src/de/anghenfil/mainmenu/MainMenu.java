package de.anghenfil.mainmenu;
import de.anghenfil.user.*;
import de.anghenfil.editor.*;
import de.anghenfil.maingame.MainGame;

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
	
	public static void main(String[] args) {
		boolean createnew; //True if no save file exists
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
		//Maybe later Swing GUI for starting game?
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
				MainGame.play();//Start game
			}else if(createnew == false){
				MainGame.play(); //Starts game
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

}
