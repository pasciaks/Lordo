package com.skilldistillery.lordo.app;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.skilldistillery.lordo.entities.Enemy;
import com.skilldistillery.lordo.entities.Location;
import com.skilldistillery.lordo.entities.Player;
import com.skilldistillery.lordo.entities.Weapon;

public class LordoApp {

	Player player;
	int KILLS_NEEDED = 3;

	List<Weapon> weapons;
	List<Enemy> enemies;
	List<Location> locations;

	LordoUtils lordoUtils = new LordoUtils();
	int countOfEnemiesKilled = 0;

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

	public static void main(String[] args) {

		LordoApp app = new LordoApp();
		app.run();
	}

	private void run() {

		gameSetup();

		Scanner keyboard = new Scanner(System.in);

		welcomeMessage();

		String chosenname = playerSetup(keyboard);

		Weapon randomWeapon;
		randomWeapon = this.pickRandomWeapon(weapons);
		player = new Player(chosenname, 20, randomWeapon.getName(), randomWeapon.getAttackPower());

		beginMessage();

		int currentLocation = 0;

		int lastLocation = locations.size() - 1;

		do {

			System.out.println(blue + "\nYou are at location # " + (currentLocation + 1) + reset);
			System.out.println(locations.get(currentLocation));

			for (Enemy enemy : enemies) {

				if (enemy.getCurrentLocation() == currentLocation) {
					System.out.println(red + "\nYou encounter an enemy at location # " + (currentLocation + 1) + reset);
					if (fight(player, enemy, keyboard)) {
						countOfEnemiesKilled++;
					}
				}
			}

			// battles scenes based on if enemy is at this currentLocation

			if (countOfEnemiesKilled >= KILLS_NEEDED) {
				System.out.println("You win.");
				break;
			}

			if (!player.isAlive()) {
				System.out.println("You died.");
				break;
			}

			String choice;
			do {
				displayWins();
				System.out.print("Your command? 1. To move forward, 2. To move back: ");
				choice = keyboard.nextLine();

				switch (choice) {
				case "1":
					currentLocation++;
					break;
				case "2":
					currentLocation--;
					break;

				default:
					System.out.println("Invalid Choice.");
					break;
				}
			} while (!choice.equals("1") && !choice.equals("2"));

			if (currentLocation < 0) {
				System.out.println("You are at the start and cannot go back. Please move forward. ");
				currentLocation = 0;
			}
			if (currentLocation > lastLocation) {
				currentLocation = lastLocation;
				System.out.println("You are at the end of the map. Please move back and fight more enemies. ");
			}

		} while (player.isAlive());
		// end of game
	}

	public int pickRandomLocation(List<Location> locations) {
		Random random = new Random();
		int chosenIndex = random.nextInt(locations.size());
		return chosenIndex;
	}

	public Weapon pickRandomWeapon(List<Weapon> weapons) {
		Random random = new Random();
		int chosenIndex = random.nextInt(weapons.size());
		Weapon selectedWeapon = weapons.remove(chosenIndex);
		return selectedWeapon;
	}

	public void beginMessage() {
		System.out.println(green + "Good luck " + player.getName() + "\n" + reset);
	}

	public void displayWins() {
		System.out.println("----------------------------");
		System.out.println("|   Enemies killed: " + countOfEnemiesKilled + "      |");
		System.out.println("|   Goal: " + countOfEnemiesKilled + " of " + KILLS_NEEDED + "           |");
		System.out.println("----------------------------");
	}

	public void welcomeMessage() {

		System.out.println(
				"\n <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<(Welcome to treasure hunter 2000)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
		System.out.println(
				"\n                                              Game Rules                                   ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		System.out.println(
				"             You are on a magical journey through an enchanted forest in search of hidden treasure!\n");
		System.out.println("              As you venture through the forest you will encounter \n "
				+ "                               three different enemies who wish you dead.");
		System.out.println("                 Every enemy you happen upon will provoke you to battle!\n");
		System.out.println("               Losing to an enemy will result in your depleted health levels\n");
		System.out.println("               On your journey you may also find yourself among a forest witch");
		System.out.println(
				"              If found the witch will provide you with a potion that restores some of your health\n");
		System.out.println("                    When your health level reaches 0 you will die: \n "
				+ "                                        No Treasure for you :(\n");
		System.out.println("                   If you defeat all three enemies you win the treasure!");
	}

	public void gameSetup() {
		locations = lordoUtils.loadLocations();
		weapons = lordoUtils.loadWeapons();
		enemies = lordoUtils.loadEnemies();

		Random random = new Random();
		for (Enemy enemy : enemies) { // for each enemy of the list of enemies is here at app level
			int randomLocation = random.nextInt(locations.size());
			enemy.setCurrentLocation(randomLocation);
		}
	}

	public String playerSetup(Scanner keyboard) {
		System.out.print("\n                                   What is your character's name: ");
		String playerName = keyboard.nextLine().trim();
		while (playerName.equals("")) {
			System.out.println("\nThat is not a valid name, try again");
			System.out.print("\nWhat is your character's name: ");
			playerName = keyboard.nextLine().trim();
		}

		return playerName;
	}

	private boolean fight(Player player, Enemy enemy, Scanner keyboard) {

		do {

			// fight scene

			System.out.println(enemy);

			System.out.println("****************************");
			System.out.println("*      Menu Options  	   *");
			System.out.println("****************************");
			System.out.println("|       1. Fight           |");
			System.out.println("|       2. Retreat         |");
			System.out.println("----------------------------");
			System.out.println("What is your choice: ");
			String choice = keyboard.nextLine();

			switch (choice) {
			case "1":
				player.useWeapon();
				player.attack(enemy);
				if (enemy.isAlive()) {
					enemy.useWeapon();
					enemy.attack(player);
					if (!player.isAlive()) {
						System.err.println("You were defeated by the enemy.");
					}
				} else {
					enemy.setCurrentLocation(-1);
					System.err.println("You defeated the enemy.");
					return true;
				}
				break;
			case "2":
				return false;
			default:
				break;
			}
			displayWins();

		} while (player.isAlive() && enemy.isAlive() && countOfEnemiesKilled < KILLS_NEEDED);

		return false;
	}
}
