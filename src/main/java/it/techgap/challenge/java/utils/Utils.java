package it.techgap.challenge.java.utils;

public class Utils {
	
	/**
	 * Method that check if the value of a String is a Number correctly formatted 
	 */
	public static boolean isNumeric(String number) {
	    try {
	        double d = Double.parseDouble(number);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Method to reverse a word
	 */
	public static String reverse(String word) {
		String reverse="";
		for (int i=word.length()- 1; i >= 0; i--) {
			reverse += word.charAt(i);
		}
		return reverse;
	}
}
