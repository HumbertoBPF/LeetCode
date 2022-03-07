import java.util.HashMap;

public class SolutionLeetCode13 {

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}

	public static int romanToInt(String s) {
		HashMap<String,Integer> dictionary = new HashMap<>();	// build HashMap (key: Roman numbers/value: Arabic numbers)
        dictionary.put("I",1);
        dictionary.put("IV",4);
        dictionary.put("V",5);
        dictionary.put("IX",9);
        dictionary.put("X",10);
        dictionary.put("XL",40);
        dictionary.put("L",50);
        dictionary.put("XC",90);
        dictionary.put("C",100);
        dictionary.put("CD",400);
        dictionary.put("D",500);
        dictionary.put("CM",900);
        dictionary.put("M",1000);
        
        if (s.length() == 1) {	// if there is a unique letter, the result is immediate
        	return dictionary.get(String.valueOf(s.charAt(0)));
        }
        
        int currentPosition = 0;
        int output = 0;
        char currentChar;
        char nextChar;
        
        while (currentPosition < s.length()-1) {
        	currentChar = s.charAt(currentPosition);
        	nextChar = s.charAt(currentPosition+1);
        	
        	// Roman number composed of two letters
        	if ( ((currentChar == 'I') && (nextChar == 'V' || nextChar == 'X')) ||
        			((currentChar == 'X') && (nextChar == 'L' || nextChar == 'C')) ||
        				((currentChar == 'C') && (nextChar == 'D' || nextChar == 'M'))) {
        		output += dictionary.get(String.valueOf(currentChar)+String.valueOf(nextChar));
        		currentPosition += 2;
        	// Roman number composed of a unique letter
        	}else {
        		output += dictionary.get(String.valueOf(currentChar));
        		currentPosition++;
        	}
        	
        }
        
        if (currentPosition == s.length()-1) {	// verifying if the last letter was still not checked
        	currentChar = s.charAt(currentPosition);
        	output += dictionary.get(String.valueOf(currentChar));
        }
        
        return output;
    }

}
