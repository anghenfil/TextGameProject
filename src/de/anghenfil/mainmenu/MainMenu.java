package de.anghenfil.mainmenu;
import de.anghenfil.user.*;
import de.anghenfil.editor.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import de.anghenfil.textdesign.*;

public class MainMenu {

	public static void main(String[] args) {
		boolean createnew; //True if no save file exists
		String decision;
		String path = System.getProperty("user.home")+"/AppData/Roaming/TextGameProject";
		Path save = Paths.get(path);
		Scanner sc = new Scanner(System.in);
		File srcDir = new File("/data/");
		File destDir = new File(System.getProperty("user.home")+"/AppData/Roaming/TextGameProject");
		FileUtils.copyDirectory(srcDir, destDir);
		if(Files.exists(save)){
			System.out.println("Test");
		}else{
			new File(path).mkdirs();
		}
		//Maybe later Swing GUI for starting game?
		TD.input_question("Editor oder Spiel starten?");
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
				UserManager.loadUser(); //Load  User data (from User Creation) and start game
			}else if(createnew == false){
				UserManager.loadUser(); //Load User data and starts game
			}
			break;
		default:
			main(args);
		}
		sc.close();
	}

}
