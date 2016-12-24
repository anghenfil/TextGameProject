package de.anghenfil.user;
import java.io.*;
import java.util.ArrayList;


import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.textdesign.TDError;

public class UserManager {
	public static boolean checkUserData(){
		boolean createnew = false;
		File datafile1;
		
		datafile1 = new File(MainMenu.getPath(), "user");
		if(datafile1.exists() && !datafile1.isDirectory()){
			createnew = false;
		}else{
			createnew = true;
		}
		return createnew;
	}public static User loadUser(){
		InputStream loaddata = null;
		File path = null;
		User user = null;
		
		path = new File(MainMenu.getPath(), "user");
		try{
			loaddata = new FileInputStream(path);
			ObjectInputStream loadObject = new ObjectInputStream(loaddata);
			user = (User) loadObject.readObject();
			loadObject.close();
		}
		catch ( IOException e ) { TDError.outError("Error: "+e); }
		catch ( ClassNotFoundException e ) { TDError.outError("Error: Userfile corrupted."); }
		finally { try { loaddata.close(); } catch ( Exception e ) { } }
		return user;
	}
	public static ArrayList<String> checkInput(String name, int fpunkte, String race, String profession) {
		ArrayList<String> errorsrc = new ArrayList<String>(); //If input is not correct, return source of error (name, free points, race or class)
		
		if(name.isEmpty()){ //Chek if name inserted. If not, add name to errorsrc arraylist
			errorsrc.add("name");
		}
		
		if(fpunkte != 0){ //Check if fpunkte is 0. If not, add fpunkte to errorsrc arrayList
			errorsrc.add("fpunkte");
		}
		if(race == null){ //Chek if race selected. If not, add race to errorsrc arraylist
			errorsrc.add("race");
		}
		if(profession == null){ //Chek if race selected. If not, add klasse to errorsrc arraylist
			errorsrc.add("profession");
		}
		return errorsrc;
		
		
	}
}
