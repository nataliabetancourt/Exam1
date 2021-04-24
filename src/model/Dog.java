package model;

import processing.core.PApplet;

public class Dog {
	
	private PApplet app;
	private int posX, posY;
	private String id, name, breed, date;
	private String [] text;

	public Dog(PApplet app, String id, String name, String breed, String date) {
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
