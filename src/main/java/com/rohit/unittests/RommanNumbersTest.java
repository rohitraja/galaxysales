package com.rohit.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rohit.salesmen.RomanNumbers;

public class RommanNumbersTest {
	
	@Test
	public void TestromanToNumber(){
		assertEquals("1",RomanNumbers.romanToNumber("I"));
		assertEquals("5",RomanNumbers.romanToNumber("V"));
		assertEquals("10",RomanNumbers.romanToNumber("X"));
		assertEquals("50",RomanNumbers.romanToNumber("L"));
		assertEquals("100",RomanNumbers.romanToNumber("C"));
		assertEquals("500",RomanNumbers.romanToNumber("D"));
		assertEquals("1000",RomanNumbers.romanToNumber("M"));
		assertEquals("1500",RomanNumbers.romanToNumber("MD"));
		assertEquals("Invalid",RomanNumbers.romanToNumber("DM"));

	}

}
