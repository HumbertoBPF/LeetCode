
public class SolutionLeetCode9 {

	public static void main(String[] args) {
		System.out.println(isPalindrome(0));
	}

	public static boolean isPalindrome(int x) {
        String xString = String.valueOf(x);			// converting int into a String
        for (int i=0;i<xString.length()/2;i++) {	// comparing chars of the String in symmetric positions  
        	if (xString.charAt(i) != xString.charAt(xString.length() - 1 - i)) {
        		return false;						// return false if chars in symmetric positions are different
        	}
        }
        return true;
    }
	
}
