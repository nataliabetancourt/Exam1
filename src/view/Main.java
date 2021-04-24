package view;

import controller.Controller;
import processing.core.PApplet;


public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
	
	Controller controller;
	
	@Override
	public void settings() {
		size(1200, 700);	
	}
	
	@Override
	public void setup() {
		
		controller = new Controller(this);
		
	}
	
	@Override
	public void draw() {
		background(255);
		
	}
	
	@Override
	public void keyPressed() {
		
	}
}
