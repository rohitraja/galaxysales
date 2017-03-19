package com.rohit.salesmen;


/**
 * @author Rohit Raja
 *<p> Error code and its message</p>
 */
public enum ErrorMessageCode {
	
	SUCCESS("Success"),
	INVALID("Invalid"),
	INVALID_ROMAN_CHAR("Invalid Roman Character"),
	INVALID_ROMAN_STRING("Invalid Roman String"),
	INCORRECT_CONVERSATION_TYPE("Incorrect conversation type"),
	NO_IDEA("I have no idea what you are talking about");
	
	private String message;

	
	ErrorMessageCode(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return this.message;
	}

}
