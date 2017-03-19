package com.rohit.salesmen;

public class LineInputType {
	
	private TypeOfInput type;
	private String input;
	
	
	public LineInputType(TypeOfInput type, String input) {
		super();
		this.type = type;
		this.input = input;
	}
	public TypeOfInput getType() {
		return type;
	}
	public String getInput() {
		return input;
	}
	@Override
	public String toString() {
		return "LineInputType [type=" + type + ", input=" + input + "]";
	}
	
	

}
