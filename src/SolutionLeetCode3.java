import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionLeetCode3 {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbbbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		char[] charArray = s.toCharArray();
		Queue<String> substringQueue = new LinkedList<>();
		// key: char that has appeared in the current substring, value: always True
		HashMap<String,Boolean> substringMap = new HashMap<>();
		int maxLength = 0;
		
		for (int i=0;i<charArray.length;i++) {
			String charString = String.valueOf(charArray[i]);
			// it is a repeated char, save the size of the current HashMap if  
			// it is greater than the max so far and remove the chars before the
			// repeated char from the Queue and from the HashMap
			if (substringMap.get(charString) != null) {
				int currentLength = substringMap.size();
				if (maxLength < currentLength) {
					maxLength = currentLength;	
				}
				
				String charPooled = substringQueue.poll();
				while (!charPooled.equals(charString)) {
					substringMap.remove(charPooled);
					charPooled = substringQueue.poll();
				}
				substringMap.remove(charPooled);
			}
			// add the current char to the substring HashMap and to the queue
			substringQueue.add(charString);
			substringMap.put(charString, true);	
		}
		
		// checking the maxLength for the case when a substring was being built right
		// before the end of the for loop
		int currentLength = substringMap.size();
		if (maxLength < currentLength) {
			maxLength = currentLength;	
		}
		
		return maxLength;
    }
	
}
