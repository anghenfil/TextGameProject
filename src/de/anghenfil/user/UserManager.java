package de.anghenfil.user;
import java.io.*;
import java.util.Scanner;

import org.apache.commons.lang3.SystemUtils;

import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.textdesign.TD;

public class UserManager {
	public static boolean checkUserData(){
		boolean createnew = false;
		String path;
		if(SystemUtils.IS_OS_WINDOWS == true){
        	path = MainMenu.getPath()+"\\user";
        }else{
        	path = MainMenu.getPath()+"/user";
        }
		File datafile1 = new File(path);
		if(datafile1.exists() && !datafile1.isDirectory()){
			createnew = false;
		}else{
			createnew = true;
		}
		return createnew;
	}public static User loadUser(){
		InputStream loaddata = null;
		User user = null;
		String path;
		if(SystemUtils.IS_OS_WINDOWS == true){
        	path = MainMenu.getPath()+"\\user";
        }else{
        	path = MainMenu.getPath()+"/user";
        }
		try{
			File dir = new File("TextGameProject");
			dir.mkdir();
			loaddata = new FileInputStream(path);
			ObjectInputStream loadObject = new ObjectInputStream(loaddata);
			user = (User) loadObject.readObject();
		}
		catch ( IOException e ) { System.err.println( e ); }
		catch ( ClassNotFoundException e ) { System.err.println( e ); }
		finally { try { loaddata.close(); } catch ( Exception e ) { } }
		return user; //Please confirm if its working
	}static void createUser(String name, String rasse, String klasse){
		User user = new User();
		user.name = name;
		user.rasse = rasse;
		user.klasse = klasse;
		
		switch(klasse){
		case "Magier":
			user.health = 70;
			user.ap = 100;
			break;
		case "Priester":
			user.health = 150;
			user.ap = 70;
			break;
		case "Ritter":
			user.health = 100;
			user.ap = 50;
			break;
		}
		user.saveUser();
		
	}
	public static void userCreation(){
		userCreation(null);
	}
	public static void userCreation(String content){
		/*String name = null;
		String klasse = null;
		String rasse = null;
		String rasse_eingabe;
		String klasse_eingabe;
		String choise;
		String all_correct_eingabe;
		boolean all_correct = false;
		boolean choise_valid = false;
		boolean rasse_valid = false;
		boolean klasse_valid = false;
		
		TD.description("Langsam �ffnest du die Augen und siehst dich um. Du liegst auf einem Bett und an der gegenüberliegenden Seite des Zimmers siehst du einen alten Mann an einer Feuerstelle stehen. Er dreht sich um und lächelt dich an. <br> <<Ah, du bist aufgewacht! Nun, wer bist du?>>");
		TD.headline("Charaktererstellung");
		TD.input_question("Wie hei�t du?");
		
		TD.input_question("Hallo "+name+"! Bist du Mensch, Elf oder Halbelf?");
		while(rasse_valid != true){
			rasse_eingabe = inputs.next();
			switch(rasse_eingabe){
			case "Mensch":
			case "mensch":
				rasse = "Mensch";
				rasse_valid = true;
				break;
			case "Elf":
			case "elf":
				rasse = "Elf";
				rasse_valid = true;
				break;
			case "Halbelf":
			case "halbelf":
				rasse = "Halbelf";
				rasse_valid = true;
				break;
			default: TD.error();
				break;
			}
		}
		rasse_eingabe = null;
		
		TD.input_question("Alter Mann: <<Wie du ja sicher wei�t, gibt es 3 verschiedene Klassen: Die Magier, die Priester und die Ritter. Jede Klasse hat besondere Eigenschaften und Vorteile. M�chtest du mehr dar�ber Wissen?>>");
		while(choise_valid != true){
			choise = inputs.next();
			switch(choise){
			case "Ja":
			case "ja":
				choise_valid = true;
				TD.headline("Der Magier");
				TD.description("");
				TD.headline("Der Priester");
				TD.description("");
				TD.headline("Der Ritter");
				TD.description("");
				break;
			case "Nein":
			case "nein":
				choise_valid = true;
				break;
			default: TD.error();
				break;
			}
		}
		TD.input_question("Nun, welcher Klasse geh�rst du an?");
		while(klasse_valid != true){
			klasse_eingabe = inputs.next();
			switch(klasse_eingabe){
			case "Magier":
			case "magier":
				klasse = "Magier";
				klasse_valid = true;
				break;
			case "Priester":
			case "priester":
				klasse = "Priester";
				klasse_valid = true;
				break;
			case "Ritter":
			case "ritter":
				klasse = "Ritter";
				klasse_valid = true;
				break;
			default: TD.error();
			break;
			}
		}
		TD.input_question("Sind diese Angaben korrekt?\nName: "+name+"\nRasse: "+rasse+"\nKlasse: "+klasse);
		all_correct_eingabe = inputs.next();
		switch(all_correct_eingabe){
		case "Ja":
		case "ja":
			all_correct = true;
			break;
		case "Nein":
		case "nein":
			break;
		}
		}
		inputs.close();
		createUser(name, rasse, klasse); //Create the User and Userfile with name, rasse, klasse
		*/
	}
	public static void checkInput() {
		// TODO Auto-generated method stub
		
	}
}
