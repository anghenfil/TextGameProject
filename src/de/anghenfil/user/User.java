package de.anghenfil.user;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import de.anghenfil.mainmenu.MainMenu;

public class User implements Serializable{

	private static final long serialVersionUID = -6159905496838092464L;
	String name; //Character Name
	String profession; //Character Class
	String race; //Character race
	int healthPoints; //Actual Health
	int bonusHealth;
	int maxHealthPoints = 0;
	int actionPoints; //Action Points -> = mana
	int bonusActionPoints;
	int maxActionPoints = 0;
	int actRoom = 1; //Room where the player is
	int speed; //Characters speed
	int bonusSpeed;
	int eloquence;
	int bonusEloquence;
	int charm;
	int bonusCharm;
	int intelligence;
	ArrayList<Integer> items = new ArrayList<Integer>();
	ArrayList<Integer> brackets = new ArrayList<Integer>();
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getRace() {
		return race;
		
	}
	public void setRace(String race) {
		this.race = race;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBonusHealth() {
		return bonusHealth;
	}
	public void setBonusHealth(int bonusHealth) {
		this.bonusHealth = bonusHealth;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getActionPoints() {
		return actionPoints;
	}
	public int getMaxHealthPoints() {
		return maxHealthPoints;
	}
	public void setMaxHealthPoints(int maxHealthPoints) {
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.maxHealthPoints = maxHealthPoints;
	}
	public int getMaxActionPoints() {
		return maxActionPoints;
	}
	public void setMaxActionPoints(int maxActionPoints) {
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.maxActionPoints = maxActionPoints;
	}
	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBonusActionPoints() {
		return bonusActionPoints;
	}
	public void setBonusActionPoints(int bonusActionPoints) {
		this.bonusActionPoints = bonusActionPoints;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getActRoom() {
		return actRoom;
	}
	public void setActRoom(int actRoom) {
		this.actRoom = actRoom;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBonusSpeed() {
		return bonusSpeed;
		
	}
	public void setBonusSpeed(int bonusSpeed) {
		this.bonusSpeed = bonusSpeed;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getEloquence() {
		return eloquence;
	}
	public void setEloquence(int eloquence) {
		this.eloquence = eloquence;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBonusEloquence() {
		return bonusEloquence;
	}
	public void setBonusEloquence(int bonusEloquence) {
		this.bonusEloquence = bonusEloquence;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getCharm() {
		return charm;
	}
	public void setCharm(int charm) {
		this.charm = charm;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBonusCharm() {
		return bonusCharm;
	}
	public void setBonusCharm(int bonusCharm) {
		this.bonusCharm = bonusCharm;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) { //TODO: Save user every time, something changed
		this.name = name;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBonus_health() {
		return bonusHealth;
	}
	public void setBonus_health(int bonus_health) {
		this.bonusHealth = bonus_health;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBonus_ap() {
		return bonusActionPoints;
	}
	public void setBonus_ap(int bonus_ap) {
		this.bonusActionPoints = bonus_ap;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getHealth() {
		return healthPoints;
	}
	public void setHealth(int health) {
		this.healthPoints = health;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getAp() {
		return actionPoints;
	}
	public void setAp(int ap) {
		this.actionPoints = ap;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getAct_room() {
		return actRoom;
	}
	public void setAct_room(int actRoom) {
		this.actRoom = actRoom;
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveUser() throws IOException{
		OutputStream savedata = null;
		  savedata = new FileOutputStream(new File(MainMenu.getPath(),"user"));
		  ObjectOutputStream saveobject = new ObjectOutputStream(savedata);
		  saveobject.writeObject(this);
		  saveobject.close();
		  savedata.close();
	}
	public boolean hasItem(int itemID){
		boolean contains;
		if(this.items.contains(itemID)){
			contains = true;
		}else{
			contains = false;
		}
		return contains;
	}
	public void addItem(int itemID){
		this.items.add(itemID);
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeItem(int itemID){
		this.items.remove(itemID);
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean hasBracket(int bracketID){
		boolean contains;
		if(this.items.contains(bracketID)){
			contains = true;
		}else{
			contains = false;
		}
		return contains;
	}
	public void addBracket(int bracketID){
		this.items.add(bracketID);
		try {
			saveUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}