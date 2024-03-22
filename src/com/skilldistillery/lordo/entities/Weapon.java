package com.skilldistillery.lordo.entities;

public class Weapon implements Item {

	private String name;
	private int attackPower;

	public Weapon(String name, int attackPower) {
		this.name = name;
		this.attackPower = attackPower;
	}

	@Override
	public void use() {
		System.out.println("Weapon of choice: " + this.name);
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "\n WEAPON AttackPower: " + attackPower + "\n";
	}

}