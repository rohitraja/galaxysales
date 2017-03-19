package com.rohit.salesmen;


/**
 * @author Rohit Raja
 * <p>Enum to store value for each Roman character </p>
 */
public enum RomanEnum {
	
	I(1) , V(5), X(10), L(50), C(100), D(500), M(1000);
	
	private int value;
	
	RomanEnum(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}

}
