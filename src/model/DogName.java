package model;

import java.util.Comparator;

public class DogName implements Comparator <Dog>{
	
	@Override
	public int compare(Dog dog1, Dog dog2) {
		return dog1.getName().compareTo(dog2.getName());
	}

}
