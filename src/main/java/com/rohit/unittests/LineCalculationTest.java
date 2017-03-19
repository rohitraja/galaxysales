package com.rohit.unittests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.rohit.salesmen.ErrorMessageCode;
import com.rohit.salesmen.LineCalculation;
import com.rohit.salesmen.Metal;

public class LineCalculationTest {
	
	@Test
	public void TestAssignment(){
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
		LineCalculation calculation = new LineCalculation(conversations);
		Metal metal1 = new Metal("Silver", 17.00);
		assertEquals(metal1,calculation.calculateMetalValue("glob glob Silver is 34 Credits"));
		assertEquals("pish tegj glob glob is 42",calculation.ansHowMuchQuestion("how much is pish tegj glob glob ?"));
		assertEquals(ErrorMessageCode.NO_IDEA.getMessage(),calculation.ansHowMuchQuestion("how much is glob pish tegj glob glob ?"));
		assertEquals("glob prok Gold is 57800.0 Credits",calculation.ansHowManyQuestions("how many Credits is glob prok Gold ?"));
		assertEquals(ErrorMessageCode.NO_IDEA.getMessage(),calculation.ansHowManyQuestions("how many Credits is glob tegj Gold ?"));
//		
		

	}

}
