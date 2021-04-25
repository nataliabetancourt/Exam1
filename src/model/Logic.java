package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class Logic {
	
	private PApplet app;
	private String [] text1, text2, saveIDOrder, saveNameOrder, saveBreedOrder, saveDateOrder;
	private LinkedList<Dog> listOfDogs;
	private ArrayList<String> firstVariables, secondVariables, id, names, breeds, date, dogImg;
	private PFont fontBold, fontRegular;
	
	//Classes of variables of the dogs
	private DogName dogName;
	private DogBreed dogBreed;
	private DogDate dogDate;

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
		dogImg = new ArrayList<>();

		
		//Classes
		dogName = new DogName();
		dogBreed = new DogBreed();
		dogDate = new DogDate();
		
		//Text
		addImgList();
		loadText();
		textToVariables();
		addDog();
		
		//Fonts
		fontBold = app.createFont("./data/fonts/Poppins-Bold.ttf", 32);
		fontRegular = app.createFont("./data/fonts/Poppins-Regular.ttf", 22);
		
		//Arrays
		saveIDOrder = new String [listOfDogs.size()];
		saveNameOrder = new String [listOfDogs.size()];
		saveBreedOrder = new String [listOfDogs.size()];
		saveDateOrder = new String [listOfDogs.size()];
		
	}

	private void loadText() {
		//Loading the texts from data imports
		text1 = app.loadStrings("./data/imports/TXT 1.txt");
		text2 = app.loadStrings("./data/imports/TXT 2.txt");
	}

	private void addImgList() {
		/*This method is used to add the information necessary for a loadImage to a list of strings. 
		 * The parameters receive the string and use it to load the image of the corresponding dog*/
		dogImg.add("./data/img/labrador.jpg");				
		dogImg.add("./data/img/germanshepherd.jpg");	
		dogImg.add("./data/img/bulldog.jpg");								
		dogImg.add("./data/img/rottweiler.jpg");
		dogImg.add("./data/img/husky.jpg");

	}
	
	private void textToVariables() {
		/*This method is to grab each text and assign it to a certain list based on the variable of the dog
		 * so that we can create dogs as objects. */
		
		//The first text has the ID and the name, so we split it, than assign it to a list (the list provides easier access to the values)
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
			//Then splitting it to get: ID, breed and date of birth
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
		//Going through one list to add the attributes to the dog (because all the lists have 5 elements)
		for (int i = 0; i < 5; i++) {
			String numID = id.get(i);
			String name = names.get(i);
			String breed = breeds.get(i);
			String dateBirth = date.get(i+1);
			String img = dogImg.get(i);
						
			//Adding the dogs to the list
			listOfDogs.add(new Dog(app, numID, name, breed, dateBirth, img));
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
			app.text("ID", 145, 135);						app.text("Nombre", 380, 135);		
			app.text("Raza", 600, 135);					app.text("Nacimiento", 820, 135);
			app.text("Foto", 1060, 135);	
			//Instructions to organize
			app.textSize(12);
			app.text("(Tecla I)", 145, 155);				app.text("(Tecla N)", 380, 155);
			app.text("(Tecla R)", 600, 155);				app.text("(Tecla F)", 820, 155);				
			
		//INFORMATION OF THE DOGS
			for (int i = 0; i < listOfDogs.size(); i++) {
				int yTemp = 210;
				listOfDogs.get(i).draw((i*100)+yTemp, fontRegular);
			}
			
	}
	
	public void sortLists(char key) {
		switch (key) {
		case 'i':
			Collections.sort(listOfDogs);
			for (int i = 0; i < listOfDogs.size(); i++) {
				//Adding the variables together (through a method in dog) to an array that will later be saved
				saveIDOrder[i]= listOfDogs.get(i).variablesTogether();
			}
			break;
		case 'n':
			Collections.sort(listOfDogs, dogName);
			for (int i = 0; i < listOfDogs.size(); i++) {
				//Adding the variables together (through a method in dog) to an array that will later be saved
				saveNameOrder[i]= listOfDogs.get(i).variablesTogether();
			}
			break;	
		case 'r':
			Collections.sort(listOfDogs, dogBreed);
			for (int i = 0; i < listOfDogs.size(); i++) {
				//Adding the variables together (through a method in dog) to an array that will later be saved
				saveBreedOrder[i]= listOfDogs.get(i).variablesTogether();
			}
			break;	
		case 'f':
			Collections.sort(listOfDogs, dogDate);
			for (int i = 0; i < listOfDogs.size(); i++) {
				//Adding the variables together (through a method in dog) to an array that will later be saved
				saveDateOrder[i]= listOfDogs.get(i).variablesTogether();
			}
			break;
		default:
			break;
		}
		
		saveText();
	}
	
	public void saveText() {
		//SAVING THE DIFFERENT ORDERS
			//Saving the new ID text
			app.saveStrings("./data/exports/ID_Order.txt", saveIDOrder);
			//Saving the new name text
			app.saveStrings("./data/exports/Name_Order.txt", saveNameOrder);
			//Saving the new breed text
			app.saveStrings("./data/exports/Breed_Order.txt", saveBreedOrder);
			//Saving the new date text
			app.saveStrings("./data/exports/Date_Order.txt", saveDateOrder);
		
	}
	
}
