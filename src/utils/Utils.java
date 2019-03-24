package utils;

import model.Position;

public class Utils {

	public static double distanceLessThan(Position position1,  Position position2) {
		return Math.sqrt(Math.pow(position1.getAbcisse() - position2.getAbcisse(), 2.0) 
				+ Math.pow(position1.getOrdonnee() - position2.getOrdonnee(), 2.0));
	}
}
