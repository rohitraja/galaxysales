package com.rohit.salesmen;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Rohit Raja
 * <p>Evaluate input by application<p>
 *
 */
public class LineCalculation {
	
	private HashMap<String, String> symboleAndRoman ;
	private HashMap<String, Metal> metalesValue;
	private ArrayList<String> answers;
	private ArrayList<LineInputType> inputTypes;
	private ArrayList<String> conversations;
	
	
	public ArrayList<String> interprate(){
		setHowMuchAns(this.inputTypes);
		setHowManyAns(this.inputTypes);
		return answers;
	}
	
	
	/*
	 * @author Rohit Raja
	 * <p> constructor initialize all its required intlegence based<br>
	 * list of conversation happned<br>
	 * </p>
	 */
	public LineCalculation(ArrayList<String> conversations) {
		this.answers = new ArrayList<String>();
		this.conversations = conversations;
		this.inputTypes = interpretateTypeOfConversation(conversations);
		this.symboleAndRoman = getSyboleAndItsRoman(this.inputTypes);
		this.metalesValue = setMetalesValue(this.inputTypes);
		
	}


	/*
	 * @author Rohit Raja
	 * <p> Interpret and initialize the list of its conversation </p>
	 */
	public ArrayList<LineInputType> interpretateTypeOfConversation(ArrayList<String> conversations){
		ArrayList<LineInputType> inputTypes = new ArrayList<LineInputType>();
		for(String line : conversations){
			inputTypes.add(new LineInputType(InputMining.checkType(line), line));
		}
		return inputTypes;
	}
	
	/*
	 * @author Rohit Raja
	 * <p> create hashmap to the symbols and the Roman<br>
	 * Numbers which can be used while answering the question</p>
	 */
	public HashMap<String, String> getSyboleAndItsRoman( ArrayList<LineInputType> inputTypes){
		HashMap<String, String> symboleAndRoman = new HashMap<String, String>();
		for(LineInputType input: inputTypes){
			if(input.getType().equals(TypeOfInput.ASSIGNED)){
				String[] splitInput = input.getInput().trim().split(" ");
				
				try {
					symboleAndRoman.put(splitInput[0], splitInput[2]);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.err.println(ErrorMessageCode.INCORRECT_CONVERSATION_TYPE.getMessage());
				}
			}
		}
		return symboleAndRoman;
	}
	
	/*
	 * @author Rohit Raja
	 * <p> store metal and its cost infromation</p>
	 */
	public HashMap<String, Metal> setMetalesValue( ArrayList<LineInputType> inputTypes){
		HashMap<String, Metal> metals = new HashMap<String, Metal>();
		
		for(LineInputType input: inputTypes){
			if(input.getType().equals(TypeOfInput.CREDITS)){
				Metal metal = calculateMetalValue(input.getInput());
				metals.put(metal.getMetalName(), metal);
			}
		}
		return metals;
		
	}
	
	/*
	 * @author Rohit Raja
	 * <p> calculate metal value</p>
	 */
	public Metal calculateMetalValue(String lineInput){
		Double metalValue=0.0;
		Metal metal=null;
		
		try
		{
			String[] splits = lineInput.split(" ");
			
//			glob prok Gold is 57800 Credits
			String metalname = splits[splits.length-4];
			Double value = Double.parseDouble(splits[splits.length-2]);
			
			String romanString="";
			
			for(int i=0;i<splits.length-4;i++)
			{
				romanString += symboleAndRoman.get(splits[i]);
			}
			int romanNumber = Integer.parseInt(RomanNumbers.romanToNumber(romanString));
			metalValue = (Double)(value/romanNumber);
			metal = new Metal(metalname, metalValue);
		}
		catch(Exception e)
		{
			System.err.println("Exception: "+e);
		}
		
		return metal;
	}
	
	
	/*
	 * @author Rohit Raja
	 * <p> Answer List of How Much questions</p>
	 */
	public void setHowMuchAns( ArrayList<LineInputType> inputTypes){
		
		for(LineInputType input: inputTypes){
			if(input.getType().equals(TypeOfInput.HOW_MUCH)){
				this.answers.add(ansHowMuchQuestion(input.getInput()));
			}
		}
		
	}
	
	/*
	 * @author Rohit Raja
	 * <p> used by setHowMuchAns to set and calculate the <br>
	 * the answers for the given input</p>
	 */
	public String ansHowMuchQuestion(String question){
		String ans=ErrorMessageCode.NO_IDEA.getMessage();
		String[] splits = question.split(" ");
		String romanNo="";
		String prefixAns="";
		String romanValue="";
		if (splits.length>=5) {
			try {
				for(int i=3;i<=splits.length-2;i++){
					if(!this.symboleAndRoman.containsKey(splits[i])){
						return ErrorMessageCode.NO_IDEA.getMessage();
					}else{
						romanNo = romanNo+this.symboleAndRoman.get(splits[i]);
						prefixAns = prefixAns+" "+splits[i];
					}
				}
				romanValue = RomanNumbers.romanToNumber(romanNo);
				if(romanValue.equals(ErrorMessageCode.INVALID.getMessage())){
					return ErrorMessageCode.NO_IDEA.getMessage();
				}else{
					
					ans = prefixAns.trim()+" is "+RomanNumbers.romanToNumber(romanNo);
				}
			} catch (Exception e) {
				ans = ErrorMessageCode.NO_IDEA.getMessage();
			} 
		}else{
			ans = ErrorMessageCode.NO_IDEA.getMessage();
		}
		return ans;
	}

	/*
	 * @author Rohit Raja
	 * <p> Answer List of How Many questions</p>
	 */
	public void setHowManyAns( ArrayList<LineInputType> inputTypes){
		
		for(LineInputType input: inputTypes){
			if(input.getType().equals(TypeOfInput.HOW_MANY)){
				this.answers.add(ansHowManyQuestions(input.getInput()));
			}else if(input.getType().equals(TypeOfInput.NOMATCH)){
				this.answers.add(ErrorMessageCode.NO_IDEA.getMessage());

			}
		}
		
	}
	
	/*
	 * @author Rohit Raja
	 * <p> used by setHowManyAns to set and answer the How many question</p>
	 */
	
	public String ansHowManyQuestions(String question){
		
		String ans=ErrorMessageCode.NO_IDEA.getMessage();
		String[] splits = question.split(" ");
		String romanNo="";
		String prefixAns="";
		String romanValue="";
		Double totalValue =0.0;
		//how many Credits is glob prok Gold ?
		if(splits.length>=7){
			try{
				for(int i=4;i<=splits.length-3;i++){
					if(!this.symboleAndRoman.containsKey(splits[i])){
						return ErrorMessageCode.NO_IDEA.getMessage();
					}else{
						romanNo = romanNo+this.symboleAndRoman.get(splits[i]);
						prefixAns = prefixAns+" "+splits[i];
					}
				}
				romanValue = RomanNumbers.romanToNumber(romanNo);
				if(romanValue.equals(ErrorMessageCode.INVALID.getMessage())){
					return ErrorMessageCode.NO_IDEA.getMessage();
				}else{
					totalValue= Integer.parseInt(romanValue)* this.metalesValue.get(splits[splits.length-2]).getMetalValue();
					ans = prefixAns.trim()+" "+splits[splits.length-2] +" is "+totalValue+" Credits";
				}
			}catch(Exception e){
				System.out.println("Error");
				ans = ErrorMessageCode.NO_IDEA.getMessage();

			}
			
		}else{
			ans = ErrorMessageCode.NO_IDEA.getMessage();
		}
		
		return ans;
		
	}
}
