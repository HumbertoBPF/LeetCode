import java.util.HashMap;
import java.util.Stack;

public class SolutionLeetCode316 {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
	}

	public static String removeDuplicateLetters(String s) {
		int n = s.length();
		// The monotonic stack that saves the result
		Stack<Character> monotonicStack = new Stack<>();
		
		// The HashMap that records the frequency of a character
		HashMap<Character,Integer> frequencyMap = new HashMap<>();
		// Fill the HashMap
		for (int i = 0;i < n;i++) {
			char currentChar = s.charAt(i);
			Integer value = frequencyMap.get(currentChar);
			frequencyMap.put(currentChar, value==null?1:value+1);
		}
		
		// HashMap to inform if a given item has already been used in the sequence
		HashMap<Character,Boolean> isUsedMap = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			char currentChar = s.charAt(i);
			// Decrement the frequency since we are checking one of the occurrences of the char
			frequencyMap.put(currentChar, frequencyMap.get(currentChar)-1);
			// Skip this step if the char has already been used
			if (isUsedMap.get(currentChar) != null) {
				continue;
			}
			// Place the lowest item the closest that we can to the bottom(sometimes is not
			// possible to place at the bottom due to the existence of a char that is not going to be 
			// available for the next positions of the string, i.e. whose current frequency is 0)
			while (!monotonicStack.isEmpty() && currentChar < monotonicStack.peek() && 
					frequencyMap.get(monotonicStack.peek()) > 0) {
				isUsedMap.remove(monotonicStack.pop());
			}
			// Add the item to the sequence(i.e. add to the stack and mark as used)
			monotonicStack.add(currentChar);
			isUsedMap.put(currentChar, true);
		}
		
		String output = "";
		// Building the output
		while (!monotonicStack.isEmpty()) {
			output = monotonicStack.pop() + output;
		}
		
		return output;
	}
	
}
