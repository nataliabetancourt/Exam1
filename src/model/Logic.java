package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Logic {
	
	private PApplet app;
	private LinkedList<Dog> listOfDogs;
	private String [] text1, text2;
	private ArrayList<String> firstVariables, secondVariables, id, names, breeds, date;
	private PFont fontBold, fontRegular;

	public Logic(PApplet app) {
		this.app = app;
		
		//Lists
		listOfDogs = new LinkedList<>();
		id = new ArrayList<>();
		names = new ArrayList<>();
		breeds = new ArrayList<>();
		date = new ArrayList<>();
		firstVariables = new ArrayList<>();
		secondVariables = new ArrayList<>();
		
		//Text
		loadText();
		textToVariables();
		addDog();

		
		//Fonts
		fontBold = app.createFont("./data/fonts/Poppins-Bold.ttf", 32);
		fontRegular = app.createFont("./data/fonts/Poppins-Regular.ttf", 22);
		
	}

	private void loadText() {
		//Loading the texts from data imports
		text1 = app.loadStrings("./data/imports/TXT 1.txt");
		text2 = app.loadStrings("./data/imports/TXT 2.txt");
	}
	
	private void textToVariables() {
		/*This method is to grab each text and assign it to a certain list based on the variable of the dog
		 * so that we can create dogs as objects. */
		
		//The first text has the ID and the name, so we split it, than assign it to a list
		for (int i = 0; i < text1.length; i++) {
			String [] variables = app.split(text1[i], " ");
			for (int j = 0; j < variables.length; j++) {
				firstVariables.add(variables[j]);
			}
		}
		
		for (int i = 0; i < firstVariables.size(); i++) {
			//Variable
			String word = firstVariables.get(i);
			
			//Assigning the variables based on their position in the list (odd and even numbers)
			if (i%2 == 0) {
				id.add(word); 
			} else {
				names.add(word);
			}	
		}
		
		for (int i = 0; i < text2.length; i++) {
			//Sorting the array to make sure that it corresponds with the ID and name from the first text
			Arrays.sort(text2);
			String [] variables = app.split(text2[i], " ");
			for (int j = 0; j < variables.length; j++) {
				secondVariables.add(variables[j]);
			}
		}
		
		for (int i = 0; i < secondVariables.size(); i++) {
			//Variable
			String word = secondVariables.get(i);
			
			//Removing the ID from the list, because it's already in order
			secondVariables.remove("1");			secondVariables.remove("2");
			secondVariables.remove("3");			secondVariables.remove("4");
			secondVariables.remove("5");
			
			//Assigning the variables based on their position in the list (odd and even numbers)
			if (i%2 == 0) {
				date.add(word);
			} else {
				breeds.add(word);
			}	
		}
	}
	
	private void addDog() {
		//Going through one list to add the attributes to the dog
		for (int i = 0; i < id.size(); i++) {
			String numID = id.get(i);
			String name = names.get(i);
			String breed = breeds.get(i);
			String dateBirth = date.get(i);
						
			//Adding the dogs to the list
			listOfDogs.add(new Dog(app, numID, name, breed, dateBirth));
		}		
	}
	
	public void draw() {
		//BACKGROUND OF APP
			app.background(208, 248, 252);
			//Title
			app.fill(255);
			app.rect(40, 20, 1120, 60);
			app.fill(96);
			app.textAlign(PConstants.CENTER);
			app.textFont(fontBold);
			app.text("PELUDITOS SIN HOGAR", 600, 60);
			//Rectangles for each category
			for (int i = 0; i < 5; i++) {
				app.fill(255);
				app.stroke(96);
				app.strokeWeight(2);
				app.rect((i*225)+40, 105, 225, 570);
			}
			//Titles of the categories
			app.textFont(fontBold);
			app.textSize(18);
			app.fill(96);
			app.text("ID", 160, 135);						app.text("Nombre", 380, 135);		
			app.text("Raza", 600, 135);					app.text("Nacimiento", 820, 135);
			app.text("Foto", 1060, 135);	
			//Instructions to organize
			app.textSize(12);
			app.text("(Tecla I)", 160, 155);				app.text("(Tecla N)", 380, 155);
			app.text("(Tecla R)", 600, 155);				app.text("(Tecla F)", 820, 155);				
			app.text("(Tecla J)", 1060, 155);
			
	}
	
	public void sortLists() {
		

	}
	
	public void saveText() {
		

	}
	
}
