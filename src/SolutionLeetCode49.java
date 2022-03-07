import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionLeetCode49 {

	public static void main(String[] args) {
		String[] strs = {"a"};
		System.out.println(groupAnagrams(strs));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		// HashMap: 
		//	- key: String corresponding to the anagrams sorted
		//	- value: list of anagrams
        HashMap<String,List<String>> map = new HashMap<>();
        // List of list of anagrams to be returned at the end
        List<List<String>> anagramsGrouped = new ArrayList<>();
        
        for (String str : strs) {
        	// Current String sorted
        	String strSorted = sortCharsOfString(str);
        	// List of anagrams of corresponding to the sorted String key 
        	List<String> currentValueMap = map.get(strSorted);
        	// If the key is not present in the map, add an array with a single item  
        	// list with the String associated to such key(key = sorted String)
        	if (currentValueMap == null) {
        		List<String> newValue = new ArrayList<>();
        		newValue.add(str);
        		map.put(strSorted, newValue);
        	// If the map has a list of anagrams associated to this sorted String,
        	// add the current String to this list
        	}else {
        		currentValueMap.add(str);
        		map.put(strSorted, currentValueMap);
        	}
        }
        // Iterate over the map to get all the lists of anagrams
        map.forEach((key,value)->anagramsGrouped.add(value));
        
        return anagramsGrouped;
    }
	
	// Function that returns the specified String sorted
	public static String sortCharsOfString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		
		return String.valueOf(chars);
	}

}
