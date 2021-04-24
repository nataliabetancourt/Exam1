package model;

import processing.core.PApplet;

public class Dog {
	
	private PApplet app;
	private int id, posX, posY;
	private String name, breed, date;

	public Dog(PApplet app, int id, String name, String breed, String date) {
		this.app = app;
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.date = date;
	}
	
	public void draw(int posY) {
		this.posY = posY;

	}

}
