package com.rohit.salesmen;

/**
 * @author Rohit Raja
 * <p>This class is for Roman Number calculation<br></p>
 * 
 */
public class RomanNumbers {
	
	public static String romanNumberRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
	
	/**
	 * Gives value of each Roman character
	 * @param String
	 * @return String
	 */
	private static int valueOfRomanChar(char romanChar)
	{
		int value = -1;
		switch(romanChar)
		{
			case 'I' : value = RomanEnum.I.getValue();
						break;
			case 'V' : value = RomanEnum.V.getValue();
						break;
			case 'X' : value = RomanEnum.X.getValue();
						break;
			case 'L' : value = RomanEnum.L.getValue();
						break;
			
			case 'C' : value = RomanEnum.C.getValue();
						break;
			
			case 'D' : value = RomanEnum.D.getValue();
						break;
			
			case 'M' : value = RomanEnum.M.getValue();
						break;
			
		}
		
		return value;
	}
	
	/**
	 * Converts valid roman to its value
	 * @param String
	 * @return String
	 */
	public static String romanToNumber(String roman)
	{
		String result="";
		
		if(validateRomanString(roman))
		{
			result = convertToNumber(roman);
		}else{
				
			result = ErrorMessageCode.INVALID.getMessage();
		}
		
		return result;
	}
	
	
	/**
	 * validate if the string is Roman
	 * @param String
	 * @return Boolean
	 */
	public static Boolean validateRomanString(String roman)
	{
		Boolean validation = false;
		
		if(roman.matches(romanNumberRegex))
		{
			validation = true;
		}
		else{
			validation = false;
		}
		
		return validation;
	}
	
	/**
	 * Converts roman no to is value
	 * @param String
	 * @return String
	 */
	private static String convertToNumber(String romanString)
	{
		int decimal = 0;
        int lastNumber = 0;
        char ch;
        
		for(int i=romanString.length()-1;i>=0;i--)
		{
			ch = romanString.charAt(i);
			if(lastNumber>valueOfRomanChar(ch)){
				decimal = decimal-valueOfRomanChar(ch);
			}else{
				decimal = decimal+valueOfRomanChar(ch);

			}
            lastNumber = valueOfRomanChar(ch);
		}
		return decimal+"";
	}
	
	
}