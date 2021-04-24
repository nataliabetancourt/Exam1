package model;

import java.util.Comparator;

public class DogBreed implements Comparator <Dog>{

	@Override
	public int compare(Dog dog1, Dog dog2) {
		return dog1.getBreed().compareTo(dog2.getBreed());
	}

}
