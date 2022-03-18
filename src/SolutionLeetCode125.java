
public class SolutionLeetCode125 {

	public static void main(String[] args) {
		String s = "";
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
		// Converting all uppercase letters into lowercase
		s = s.toLowerCase();
		// Removing all non-alphanumeric characters
		s = s.replaceAll("[^a-zA-Z0-9]", "");
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        // Using two pointers placed at symmetric positions to verify chars in 
        // opposite extremities
        while (rightPointer-leftPointer > 0) {
        	if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
        		return false;
        	}
        	leftPointer++;
        	rightPointer--;
        }
        
        return true;
    }

}
