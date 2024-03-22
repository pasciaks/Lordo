package com.skilldistillery.lordo.improved.app;

import com.skilldistillery.lordo.improved.entities.Game;

public class LordoApp {

	public Game lordoGame = new Game();

	public static void main(String[] args) {

		System.out.println("Hello, Lordo!");

		LordoApp app = new LordoApp();
		app.run();
	}

	private void run() {

		boolean setupResult = lordoGame.setupGame();

		System.out.println("Running..." + setupResult);

	}

}
