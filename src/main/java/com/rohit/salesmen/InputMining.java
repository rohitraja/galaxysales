package com.rohit.salesmen;


/**
 * @author Rohit Raja
 * <p> Extract information from the input given<br>
 * Input are decided into 5 parts<br>
 * Categorize the inputs<br>
 * based on which the conclusions will be made</p>
 *
 */
public class InputMining {
	
	/*
	 * @author Rohit Raja
	 * <p> check what kind of input was provided</p>
	 */
	
	public static TypeOfInput checkType(String input){
		if(checkAssigned(input))
			return TypeOfInput.ASSIGNED;
		if(checkCredits(input))
			return TypeOfInput.CREDITS;
		if(checkHowMany(input))
			return TypeOfInput.HOW_MANY;
		if(checkHowMuch(input))
			return TypeOfInput.HOW_MUCH;
		
		return TypeOfInput.NOMATCH;
	}

	/*
	 * @author Rohit Raja
	 * <p> check if the statement is of assignment type</p>
	 */
	private static Boolean checkAssigned(String input){
		input = input.trim();
		String inputArray[];
		if(input!=null && input.length()>4){
			inputArray = input.split(" ");
			if(inputArray.length==3 && RomanNumbers.validateRomanString(inputArray[2]) && inputArray[1].equalsIgnoreCase("is")){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * @author Rohit Raja
	 * <p> check if the statement is of Credit type</p>
	 */
	
	private static Boolean checkCredits(String input){
		
		// glob glob Silver is 34 Credits
		input = input.trim();

		String inputArray[];
		if(input!=null && input.length()>0){
			Integer length ;
			inputArray = input.split(" ");
			length = inputArray.length;
			if(length >=4 && Util.isNumaric(inputArray[length -2]) && inputArray[length-3].equalsIgnoreCase("is")
					&& inputArray[length-1].equalsIgnoreCase("Credits")){
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * @author Rohit Raja
	 * <p> check if the statement is of How Much of question type</p>
	 */
	private static Boolean checkHowMuch(String input){
		//how much is pish tegj glob glob ?
		input = input.trim();
		String inputArray[];
		if(input!=null && input.length()>0){
			Integer length ;
			inputArray = input.split(" ");
			length = inputArray.length;
			if(length>5 && input.startsWith("how much is") && input.endsWith("?")){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * @author Rohit Raja
	 * <p> check if the statement is of "How many" of question type</p>
	 */
	private static Boolean checkHowMany(String input){
		//how much is pish tegj glob glob ?
		input = input.trim();
		String inputArray[];
		if(input!=null && input.length()>0){
			Integer length ;
			inputArray = input.split(" ");
			length = inputArray.length;
			if(length>5 && input.startsWith("how many Credits is") && input.endsWith("?")){
				return true;
			}
		}
		return false;
	}
	
	
}
