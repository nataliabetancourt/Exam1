package controller;

import model.Logic;
import processing.core.PApplet;
import processing.core.PFont;

public class Controller {
	
	private PApplet app;
	private Logic logic;
	
	public Controller(PApplet app) {
		this.app = app;
		
		logic = new Logic(app);
	}
	
	public void draw() {
		logic.draw();
	}
	
	public void sortLists(char key) {
		logic.sortLists(key);

	}

}
