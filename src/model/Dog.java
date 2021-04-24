package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Dog implements Comparable<Dog>{
	
	private PApplet app;
	private PImage img;
	private String id, name, breed, date;
	private ArrayList<String> variables;

	public Dog(PApplet app, String id, String name, String breed, String date, String img) {
		this.app = app;
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.date = date;
		
		//Loading the image based on the string received in the parameter
		this.img = app.loadImage(img);
		
		variables = new ArrayList<>();
		addVariables();
		
	}
	
	private void addVariables() {
		variables.add(id);
		variables.add(name);
		variables.add(breed);
		variables.add(date);

	}
	
	public void draw(int posY, PFont font) {
		//Painting the information
		for (int i = 0; i < variables.size(); i++) {
			int xTemp = 145;
			app.textSize(14);
			app.text(variables.get(i), (i*230)+xTemp, posY);
		}
		
		//Add the picture of the dog
		app.image(img, 1010, posY-40, 100, 80);

	}

	@Override
	public int compareTo(Dog otherDog) {
		return this.id.compareTo(otherDog.getId());
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public String getDate() {
		return date;
	}
	
	

}
