import java.util.HashMap;

public class SolutionLeetCode409 {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("humbertoborges"));
	}
	
	public static int longestPalindrome(String s) {
		int n = s.length();
		int lengthLongestPalindrome = 0;
		// Stores a character and the number one when the number of times that this number has appeared so far is odd 
		HashMap<Character,Integer> map = new HashMap<>();
		// We are going to check each time that pair of chars happens and then add this pair to the palindrome since
		// they can occupy symmetric positions
		for (int i = 0;i < n;i++) {
			char currentChar = s.charAt(i);
			Integer value = map.get(currentChar);
			// If this char appeared an even number of times so far, the number of this occurrence is an odd one,
			// so we add the key corresponding to this char to the map with value equal to 1
			if (value == null) {
				map.put(currentChar, 1);
			// If this char appeared an odd number of times so far, the number of this occurrence is an even one, 
			// so the pair (key,value) corresponding to this number is removed
			}else if (value == 1) {
				map.remove(currentChar);
				lengthLongestPalindrome += 2;
			}
		}
		// If the map of chars that happen an odd number of times is not empty, the longest palindrome has an additional
		// char at the middle which does not have a symmetric one since the number of chars will be odd
		return map.isEmpty()?lengthLongestPalindrome:lengthLongestPalindrome+1;
    }

}
