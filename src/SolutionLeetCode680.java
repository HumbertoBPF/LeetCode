
public class SolutionLeetCode680 {

	public static void main(String[] args) {
		System.out.println(validPalindrome("abca"));
	}
	
	public static boolean validPalindrome(String s) {
		int leftPointer = 0;
		int rightPointer = s.length()-1;
		
		while (rightPointer-leftPointer > 0) {
			// When the symmetric char do not match
			if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
				// Check if by deleting one of the char that does not match, the string becomes a palindrome
				return isPalindrome(s,leftPointer,rightPointer-1)||isPalindrome(s,leftPointer+1,rightPointer);
			}
			
			rightPointer--;
			leftPointer++;
		}
		
		return true;
    }
	/**
	 * Simple two pointers algorithm verifying if a substring starting at <b>startingPosition</b> 
	 * and ending at <b>endingPosition</b> of the specified string is a palindrome.
	 * @param s string whose substring is being tested.
	 * @param startingPosition starting position of the substring.
	 * @param endingPosition last position of the substring.
	 * @return a boolean indicating if the specified substring is a palindrome.
	 */
	public static boolean isPalindrome(String s, int startingPosition, int endingPosition) {
		while (endingPosition-startingPosition > 0) {
			if (s.charAt(startingPosition) != s.charAt(endingPosition)) {
				return false;
			}
			
			endingPosition--;
			startingPosition++;
		}
		
		return true;
	}

}
