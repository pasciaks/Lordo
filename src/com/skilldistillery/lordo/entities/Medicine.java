package com.skilldistillery.lordo.entities;

public class Medicine implements Item {

	private String name;
	private int medicineStrength = (int) (Math.random() * 20);

	public Medicine(String name, int healPower) {
		this.name = name;
		this.medicineStrength = healPower;
	}

	@Override
	public void use() {
		heal();
	}

	public int heal() {

		System.out.println("You have encountered the witch of the mannor!");
		System.out.println(
				"She gives you a potion to drink and your health is restored " + medicineStrength + " points!");

		return medicineStrength;

	}

	public int getMedicineStrength() {
		return medicineStrength;
	}

	public void setMedicineStrength(int medicineStrength) {
		this.medicineStrength = medicineStrength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}