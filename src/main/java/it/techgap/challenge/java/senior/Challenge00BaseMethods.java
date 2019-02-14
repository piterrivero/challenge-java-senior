package it.techgap.challenge.java.senior;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import it.techgap.challenge.java.utils.Utils;

public class Challenge00BaseMethods {
	
	public static int round(double d) {
		return Math.toIntExact(Math.round(d));
	}
	
	public static int round(String d) {
		DecimalFormat decimalFormat = new DecimalFormat("#");
		long number = 0;
		try {
		   // it is used the DecimalFormat class to parse a possible value with decimals into a long	
		   number = decimalFormat.parse(d).longValue();
		} catch (ParseException e) {
		   System.out.println(d + " is not a valid number");
		}
		return Math.toIntExact(Math.round(number));
	}
	
	public static int bitNeeded(int i) {
		return BigInteger.valueOf(i).bitLength();
	}
	
	public static boolean palindromic(int num){
		String numString = Integer.toString(num);
		String numStringReverse = Utils.reverse(numString);
		if (numString.equals(numStringReverse)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int hex(String i){
		return Integer.parseInt(i, 16);
	}
	
	public static String swapXY(String i){
		char[] arrayLetters = i.toCharArray();
		String finalSwappedWord = "";
		String letter = null;
		for (char l : arrayLetters) {
			letter = String.valueOf(l);
			if (letter.equalsIgnoreCase("X")) {
				letter = "y";
			}else if (letter.equalsIgnoreCase("Y")) {
				letter = "x";
			}
			finalSwappedWord += letter;
		}
		return finalSwappedWord;
	}
	
	public static Number[] findNumbers(String i){
		String number = null;
		
		List<Number> list = new ArrayList<>();
		
		int j = 0;
		boolean endNumber = false;
		
		do {
			if (Character.isDigit(i.charAt(j)) || (Character.toString(i.charAt(j)).equals("."))) {
				if (number == null)
					number = String.valueOf(i.charAt(j));
				else
					number = number + i.charAt(j);
				
				if (j==i.length()-1) {
					endNumber = true;
				}
							
			} else {
				if (number != null) {
					endNumber = true;
				}
			}	
				
			if (endNumber) {
				if (number != null) {
					if (number.contains(".")){
						if (Utils.isNumeric(number)) {
							list.add(Double.parseDouble(number));
						}
					}else {
						list.add(Integer.parseInt(number));
					}
					number = null;
					endNumber = false;
				}
			}
			j++;
		} while (j<i.length());
				
		Number[] numberArray = new Number[list.size()];
		numberArray = list.toArray(numberArray);
		return numberArray;
	}

}
