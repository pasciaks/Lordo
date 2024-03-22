package com.skilldistillery.lordo.entities;

public class Player extends Character {

	Weapon currentWeapon;

	// List<Weapon> weapons; // stretch goal, future implementation

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

	public Player(String name, int health, String weaponName, int weaponStrength) {
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

	public void attack(Character enemy) {
		System.out.println("-------------------");
		System.out.println("Player attacks with..." + currentWeapon);
		System.out.println("-------------------");

		int damageToDo = currentWeapon.getAttackPower();
		// Randomize if attack is successful
		if (Math.random() > 0.75) {
			System.err.println("Your Attack failed.");
		} else {
			System.err.println("You Attack successfully.");
			System.err.println("Damage done:" + damageToDo);
			enemy.takeDamage(damageToDo);
		}
		System.out.println(enemy);
		System.out.println(this);
	}

	@Override
	public String toString() {
		return magenta + "\nPlayer:  " + name + "\n PLAYER HEALTH: " + health + "\n" + " WEAPON: " + this.currentWeapon
				+ reset;
	}

}