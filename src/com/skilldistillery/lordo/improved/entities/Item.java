package com.skilldistillery.lordo.improved.entities;

public abstract class Item implements Usable {

	@Override
	public abstract void use();

	@Override
	public abstract void grab();

	@Override
	public abstract void drop();

}
