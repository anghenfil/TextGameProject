package de.anghenfil.user;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import de.anghenfil.mainmenu.MainMenu;

public class User implements Serializable{

	private static final long serialVersionUID = -6159905496838092464L;
	String name; //Character Name
	String profession; //Character Class
	String race; //Character race
	int healthPoints; //Actual Health
	int bonusHealth;
	int actionPoints; //Action Points -> = mana
	int bonusActionPoints;
	int actRoom = 1; //Room where the player is
	int speed; //Characters speed
	int bonusSpeed;
	int eloquence;
	int bonusEloquence;
	int charm;
	int bonusCharm;
	int intelligence;
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getBonusHealth() {
		return bonusHealth;
	}
	public void setBonusHealth(int bonusHealth) {
		this.bonusHealth = bonusHealth;
	}
	public int getActionPoints() {
		return actionPoints;
	}
	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}
	public int getBonusActionPoints() {
		return bonusActionPoints;
	}
	public void setBonusActionPoints(int bonusActionPoints) {
		this.bonusActionPoints = bonusActionPoints;
	}
	public int getActRoom() {
		return actRoom;
	}
	public void setActRoom(int actRoom) {
		this.actRoom = actRoom;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getBonusSpeed() {
		return bonusSpeed;
	}
	public void setBonusSpeed(int bonusSpeed) {
		this.bonusSpeed = bonusSpeed;
	}
	public int getEloquence() {
		return eloquence;
	}
	public void setEloquence(int eloquence) {
		this.eloquence = eloquence;
	}
	public int getBonusEloquence() {
		return bonusEloquence;
	}
	public void setBonusEloquence(int bonusEloquence) {
		this.bonusEloquence = bonusEloquence;
	}
	public int getCharm() {
		return charm;
	}
	public void setCharm(int charm) {
		this.charm = charm;
	}
	public int getBonusCharm() {
		return bonusCharm;
	}
	public void setBonusCharm(int bonusCharm) {
		this.bonusCharm = bonusCharm;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) { //TODO: Save user every time, something changed
		this.name = name;
	}
	public String getKlasse() {
		return profession;
	}
	public int getBonus_health() {
		return bonusHealth;
	}
	public void setBonus_health(int bonus_health) {
		this.bonusHealth = bonus_health;
	}
	public int getBonus_ap() {
		return bonusActionPoints;
	}
	public void setBonus_ap(int bonus_ap) {
		this.bonusActionPoints = bonus_ap;
	}
	public void setKlasse(String klasse) {
		this.profession = klasse;
	}
	public String getRasse() {
		return race;
	}
	public void setRasse(String rasse) {
		this.race = rasse;
	}
	public int getHealth() {
		return healthPoints;
	}
	public void setHealth(int health) {
		this.healthPoints = health;
	}
	public int getAp() {
		return actionPoints;
	}
	public void setAp(int ap) {
		this.actionPoints = ap;
	}
	public int getAct_room() {
		return actRoom;
	}
	public void setAct_room(int actRoom) {
		this.actRoom = actRoom;
	}
	public void saveUser() throws IOException{
		OutputStream savedata = null;
		  savedata = new FileOutputStream(new File(MainMenu.getPath(),"user"));
		  ObjectOutputStream saveobject = new ObjectOutputStream(savedata);
		  saveobject.writeObject(this);
		  saveobject.close();
		  savedata.close();
	}
	
}