package com.skilldistillery.lordo.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.lordo.entities.Enemy;
import com.skilldistillery.lordo.entities.Location;
import com.skilldistillery.lordo.entities.Weapon;

public class LordoUtils {

	private List<Weapon> weaponsList = new ArrayList<Weapon>();
	private List<Location> locationsList = new ArrayList<Location>();
	private List<Enemy> enemyList = new ArrayList<Enemy>();

	public List<Weapon> loadWeapons() {

		List<String> weapons = new ArrayList<>();
		weapons = readFile("weapons.csv");

		for (String weaponLine : weapons) {
			String[] parts = weaponLine.trim().split(",");
			String weaponName = parts[0].trim();
			String strengthOfWeaponAsString = parts[1].trim();
			int strengthOfWeapon = Integer.parseInt(strengthOfWeaponAsString);
			Weapon currentWeapon = new Weapon(weaponName, strengthOfWeapon);
			this.weaponsList.add(currentWeapon);
		}

		return new ArrayList<Weapon>(weaponsList);
	}

	public List<Location> loadLocations() {

		List<String> locations = new ArrayList<>();
		locations = readFile("locations.csv");

		for (String locationLine : locations) {
			String locationName = locationLine.trim();
			Location currentLocation = new Location(locationName);
			locationsList.add(currentLocation);
		}

		return new ArrayList<Location>(locationsList);
	}

	public List<Enemy> loadEnemies() {
		List<String> enemies = new ArrayList<>();
		enemies = readFile("enemies.csv");

		for (String enemyLine : enemies) {
			String[] parts = enemyLine.trim().split(",");
			String enemyName = parts[0].trim();
			String enemyHitPoints = parts[1].trim();
			int hitPoints = Integer.parseInt(enemyHitPoints);
			String weaponName = parts[2].trim();
			String weaponStrengthStr = parts[3].trim();
			int weaponStrength = Integer.parseInt(weaponStrengthStr);
			Enemy currentEnemy = new Enemy(enemyName, hitPoints, weaponName, weaponStrength);
			String enemySaying = "Time to DIE!!!";

			try {
				enemySaying = parts[4].trim();
			} catch (Exception e) {

			}
			currentEnemy.setEnemyQuote(enemySaying);
			this.enemyList.add(currentEnemy);
		}

		return new ArrayList<Enemy>(enemyList);
	}

	private List<String> readFile(String fileName) {

		String line = null;
		boolean hasError = false;
		Error error = null;
		List<String> arrayListOfStrings = new ArrayList<>();
		// NOTE: Auto-closable try-with-resources
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			while ((line = in.readLine()) != null) {
				arrayListOfStrings.add(line);
			}
		} catch (FileNotFoundException e) { // Catch file not found exceptions
			System.err.println(e);
			error = new Error("File not found: " + fileName);
			hasError = true;
		} catch (IOException e) { // Catch IO exceptions
			System.err.println(e);
			error = new Error("IO Exception: " + e.getMessage());
			hasError = true;
		} catch (Exception e) { // Catch all other exceptions
			System.err.println(e);
			error = new Error("Exception: " + e.getMessage());
			hasError = true;
		} finally {
			// NOTE: No close() method to call, try-with-resources does it for us
		}

		if (hasError) {
			// consider early return of new empty ArrayList<>();
			System.err.println(error);
			System.err.println(error.getMessage());
		}

		return arrayListOfStrings;

	}

}
