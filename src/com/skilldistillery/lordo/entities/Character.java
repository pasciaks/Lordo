package com.skilldistillery.lordo.entities;

public abstract class Character {
	protected String name;
	protected int health;

	public Character(String name, int health) {
		this.name = name;
		this.health = health;
	}

	public void takeDamage(int damage) {
		this.health = Math.max(this.health - damage, 0);
	}

	public boolean isAlive() {
		return this.health > 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", health=" + health + "]";
	}
}