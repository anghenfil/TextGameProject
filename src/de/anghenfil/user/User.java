package de.anghenfil.user;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6159905496838092464L;
	String name; //Character Name
	String klasse; //Character Class
	String rasse; //Character race
	int health; //Actual Health
	int ap; //Action Points -> = mana
	int act_room = 1; //Room where the player is
	//Get and Set Methods:
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKlasse() {
		return klasse;
	}
	public String getRasse() {
		return rasse;
	}
	public void setRasse(String rasse) {
		this.rasse = rasse;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getAp() {
		return ap;
	}
	public void setAp(int ap) {
		this.ap = ap;
	}
	public int getAct_room() {
		return act_room;
	}
	public void setAct_room(int act_room) {
		this.act_room = act_room;
	}
	public void saveUser(){
		OutputStream savedata = null;

		try
		{
		  File dir = new File("TextGameProject");
		  dir.mkdir();
		  savedata = new FileOutputStream("TextGameProject/user");
		  ObjectOutputStream saveobject = new ObjectOutputStream(savedata);
		  saveobject.writeObject(this);
		  saveobject.close();
		}
		catch ( IOException e ) { System.err.println( e ); }
		finally { try { savedata.close(); } catch ( Exception e ) { e.printStackTrace(); } }
	}
	
}