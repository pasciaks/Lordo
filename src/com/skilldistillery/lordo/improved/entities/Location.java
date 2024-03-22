package com.skilldistillery.lordo.improved.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.skilldistillery.lordo.entities.Enemy;
import com.skilldistillery.lordo.entities.Item;

public class Location {

	private UUID id = UUID.randomUUID();

	private int xPostion;
	private int yPostion;
	private int zPostion;

	private String name;

	List<Exit> exits;

	List<Item> itemsAtLocation;

	List<NonPlayerCharacter> npcsAtLocation;

	List<PlayerCharacter> playersAtLocation;

	List<Enemy> enemiesAtLocation;

	public Location(int xPostion, int yPostion, int zPostion, String name) {
		super();

		this.xPostion = xPostion;
		this.yPostion = yPostion;
		this.zPostion = zPostion;

		this.name = name;

		itemsAtLocation = new ArrayList<>();
		npcsAtLocation = new ArrayList<>();
		playersAtLocation = new ArrayList<>();
		exits = new ArrayList<>();
		enemiesAtLocation = new ArrayList<>();

		System.out.println("Location created: " + id);
	}

	void addItem(Item item) {
		itemsAtLocation.add(item);
	}

	void removeItem(Item item) {
		itemsAtLocation.remove(item);
	}

	void addNPC(NonPlayerCharacter npc) {
		npcsAtLocation.add(npc);
	}

	void removeNPC(NonPlayerCharacter npc) {
		npcsAtLocation.remove(npc);
	}

	void addPlayer(PlayerCharacter player) {
		playersAtLocation.add(player);
	}

	void removePlayer(PlayerCharacter player) {
		playersAtLocation.remove(player);
	}

	void addExit(Exit exit) {
		exits.add(exit);
	}

	void removeExit(Exit exit) {
		exits.remove(exit);
	}

	void addEnemy(Enemy enemy) {
		enemiesAtLocation.add(enemy);
	}

	void removeEnemy(Enemy enemy) {
		enemiesAtLocation.remove(enemy);
	}

	public List<Item> getItemsAtLocation() {
		return itemsAtLocation;
	}

	public List<NonPlayerCharacter> getNpcsAtLocation() {
		return npcsAtLocation;
	}

	public List<PlayerCharacter> getPlayersAtLocation() {
		return playersAtLocation;
	}

	public List<Exit> getExits() {
		return exits;
	}

	public List<Enemy> getEnemiesAtLocation() {
		return enemiesAtLocation;
	}

}
