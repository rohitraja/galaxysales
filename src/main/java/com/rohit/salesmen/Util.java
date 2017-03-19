package com.rohit.salesmen;

public class Util {
	
	public static Boolean isNumaric(String input){
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
