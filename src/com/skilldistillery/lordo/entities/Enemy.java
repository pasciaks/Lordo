package com.skilldistillery.lordo.entities;

public class Enemy extends Character {

	Weapon currentWeapon;
	int currentLocation;
	String enemyQuote = "";

	// List<Weapon> weapons; // Stretch goal, future implementation

	public static final String reset = "\u001B[0m";
	public static final String bold = "\u001B[1m";
	public static final String underline = "\u001B[4m";

	public static final String black = "\u001B[30m";
	public static final String red = "\u001B[31m";
	public static final String green = "\u001B[32m";
	public static final String yellow = "\u001B[33m";
	public static final String blue = "\u001B[34m";
	public static final String magenta = "\u001B[35m";
	public static final String cyan = "\u001B[36m";
	public static final String white = "\u001B[37m";

	public Enemy(String name, int health, String weaponName, int weaponStrength) {
		super(name, health);
		this.currentWeapon = new Weapon(weaponName, weaponStrength);
	}

	public void pickupWeapon() {
		// stretch goal
	}

	public void dropWeapon() {
		// stretch goal
	}

	public void useWeapon() {
		this.currentWeapon.use();
	}

	public void attack(Character player) {
		System.out.println("-------------------");
		System.out.println("Enemy attacks with..." + currentWeapon);
		System.out.println("-------------------");

		int damageToDo = currentWeapon.getAttackPower();
		// Randomize if attack is successful
		if (Math.random() > 0.25) {
			System.err.println("Enemy Attack failed.");
		} else {
			System.err.println("Enemy Attacks successfully.");
			System.err.println("Damage done:" + damageToDo);
			player.takeDamage(damageToDo);
		}

		System.out.println(player);
		System.out.println(this);
	}

	@Override
	public String toString() {
		return cyan + "\nEnemy: " + name + "\n ENEMY HEALTH: " + health + "\n WEAPON: " + this.currentWeapon + "\n"
				+ this.enemyQuote + reset;
	}

	public int getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(int currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getEnemyQuote() {
		return enemyQuote;
	}

	public void setEnemyQuote(String enemyQuote) {
		this.enemyQuote = enemyQuote;
	}

}