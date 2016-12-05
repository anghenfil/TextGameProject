package de.anghenfil.user;
import java.io.*;
import java.util.ArrayList;

import org.apache.commons.lang3.SystemUtils;

import de.anghenfil.mainmenu.MainMenu;

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
			loadObject.close();
		}
		catch ( IOException e ) { System.err.println( e ); }
		catch ( ClassNotFoundException e ) { System.err.println( e ); }
		finally { try { loaddata.close(); } catch ( Exception e ) { } }
		return user;
	}
	public static ArrayList<String> checkInput(String name, int fpunkte, String race, String klasse) {
		ArrayList<String> errorsrc = new ArrayList<String>(); //If input is not correct, return source of error (name, free points, race or class)
		
		if(name.isEmpty()){ //Chek if name inserted. If not, add name to errorsrc arraylist
			errorsrc.add("name");
		}
		
		if(fpunkte != 0){ //Check if fpunkte is 0. If not, add fpunkte to errorsrc arrayList
			errorsrc.add("fpunkte");
		}
		if(race.isEmpty()){ //Chek if race selected. If not, add race to errorsrc arraylist
			errorsrc.add("race");
		}
		if(klasse.isEmpty()){ //Chek if race selected. If not, add klasse to errorsrc arraylist
			errorsrc.add("klasse");
		}
		return errorsrc;
		
		
	}
}
