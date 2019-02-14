package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.utils.Utils;

public class Challenge06Extra {
    public static String splitAndReverse(String i, int positions) {
    	String staticPart = i.substring(0,positions);
    	String reversePart = Utils.reverse(i.substring(positions,i.length()));
        return reversePart+staticPart;
    }
}
