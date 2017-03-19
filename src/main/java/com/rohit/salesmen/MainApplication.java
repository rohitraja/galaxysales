package com.rohit.salesmen;

import java.util.ArrayList;

public class MainApplication {
	
	public static void main(String arg[]){
		ArrayList<String> conversations = new ArrayList<String>();
		conversations.add("glob is I");
		conversations.add("prok is V");
		conversations.add("pish is X");
		conversations.add("tegj is L");
		conversations.add("glob glob Silver is 34 Credits");
		conversations.add("glob prok Gold is 57800 Credits");
		conversations.add("pish pish Iron is 3910 Credits");
		conversations.add("how much is pish tegj glob glob ?");
		conversations.add("how many Credits is glob prok Silver ?");
		conversations.add("how many Credits is glob prok Gold ?");
		conversations.add("how many Credits is glob prok Iron ?");
		conversations.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");

		ArrayList<String> ans = new ArrayList<String>();
		LineCalculation calculation = new LineCalculation(conversations);
		ans = calculation.interprate();
		
		for(String answers: ans){
			System.out.println(answers);
		}
	}

}
