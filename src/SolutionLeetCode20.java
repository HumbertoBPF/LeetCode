import java.util.HashMap;
import java.util.Stack;

public class SolutionLeetCode20 {

	public static void main(String[] args) {
		System.out.println(isValid(")"));
	}
	
	public static boolean isValid(String s) {
        Stack<Character> openBrackets = new Stack<>();
        // HashMap : key -> closing bracket/value -> opening bracket
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')', '(');						
        map.put(']', '[');
        map.put('}', '{');
        
        char currentChar;
        for (int i=0;i<s.length();i++) {
        	currentChar = s.charAt(i);
        	// if a new bracket was opened, add it to the stack
        	if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
        		openBrackets.push(currentChar);
        	// if a bracket was closed and the stack is not empty
        	}else if (!openBrackets.isEmpty()){
        		// if it closes the char on the top of the stack, we pop the stack
        		if (map.get(currentChar) == openBrackets.peek()) {					
        			openBrackets.pop();
        		// if it does not match the item on the top of the stack, we return false
        		}else {																
        			return false;
        		}
        	// if the stack is empty, it is not necessary to close anything and then the string is not valid
        	}else {
        		return false;
        	}
        }
        // returns true if and only if all the brackets were correctly closed
        return openBrackets.size() == 0;
    }

}
