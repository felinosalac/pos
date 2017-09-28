package com.fsalac.form.util;

import java.util.HashSet;
import java.util.Set;

public class NameGenerator {

	// class variable
	private static final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

	private static final java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
	private static final Set<String> identifiers = new HashSet<String>();

	public static String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(randomIdentifier());
	}

}
