package de.anghenfil.user;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import de.anghenfil.maingame.MainGame;
import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.messages.Messages;

public class User implements Serializable{

	private static final long serialVersionUID = -6159905496838092464L;
	String name = "unset"; //Character Name
	String profession; //Character Class
	String race; //Character race
	int healthPoints; //Actual health
	int bonusHealth = 0;
	int maxHealthPoints; //Max health
	int actionPoints; //Action Points -> = mana
	int bonusActionPoints = 0;
	int maxActionPoints;
	int actRoom = 1; //Room where the player is
	int speed; //Characters speed
	int bonusSpeed = 0;
	int eloquence;
	int bonusEloquence = 0;
	int charm = 100;
	int bonusCharm = 0;
	int intelligence = 100;
	int xp = 0;
	int xpborder = 1000;
	int level = 1;
	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
		checkLevel();
	}

	public int getLevel() {
		return level;
	}

	public void checkLevel() {
		if(xp >= xpborder){
			while(xp>= xpborder){
				xp = xp - xpborder;
				level ++;
			}
		}
	}
	ArrayList<Integer> items = new ArrayList<Integer>();
	ArrayList<Integer> brackets = new ArrayList<Integer>();
	
	public User(String name, String profession, String race){
		this.name = name;
		this.profession = profession;
		this.race = race;
		
		if(profession == Messages.getString("CharCre.author")){
			maxHealthPoints = 80;
			maxActionPoints = 100;
			speed = 80;
			eloquence = 150;
		}else if(profession == Messages.getString("CharCre.student")){
			maxHealthPoints = 80;
			maxActionPoints = 80;
			speed = 150;
			eloquence = 120;
		}else if(profession == Messages.getString("CharCre.doc")){
			maxHealthPoints = 100;
			maxActionPoints = 120;
			speed = 80;
			eloquence = 80;
		}else{
			//TODO: Error Message
		}
		healthPoints = maxHealthPoints;
		actionPoints = maxActionPoints;
	}
	
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
		MainGame.getWindow().updateHpBar(health);
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
		MainGame.getWindow().updateApBar(ap);
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