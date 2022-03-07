
public class SolutionLeetCode28 {

	public static void main(String[] args) {
		System.out.println(strStr("bacde","cd"));
	}

	public static int strStrTrivialSolution(String haystack, String needle) {
		return haystack.indexOf(needle);
    }
	
	public static int strStr(String haystack, String needle) {
       if (needle.isEmpty()) {										// if needle is "", return 0
    	   return 0;
       }
       
       for (int i = 0;i < haystack.length()+1-needle.length();i++) {
    	   if (haystack.charAt(i) == needle.charAt(0)) {			// if a potential match is found
    		   int j = 0;
    		   while (haystack.charAt(i+j) == needle.charAt(j)) {	// checking all the chars of needle with the substring
    			   if (j == needle.length() - 1) {
    				   return i;
    			   }
    			   j++;
    		   }
    	   }
       }
       
       return -1;
    }
	
}
