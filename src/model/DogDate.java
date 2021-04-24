package model;

import java.util.Comparator;

public class DogDate implements Comparator <Dog>{

	@Override
	public int compare(Dog dog1, Dog dog2) {
		//The substring is used to compare the year (from oldest to youngest)
		return dog1.getDate().substring(7).compareTo(dog2.getDate().substring(7));
	}

}
