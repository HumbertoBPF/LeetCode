
public class SolutionLeetCode67 {

	public static void main(String[] args) {
		System.out.println(addBinary("11","1"));
	}

	public static String addBinary(String a, String b) {
		int i = a.length() - 1;
        int j = b.length() - 1;
        // Boolean indicating if we are carrying the result of the last binary sum
        boolean carry = false;
        // Char corresponding to the current binary place of A and B
        char currentBinA, currentBinB;
        // Char corresponding to the current binary place of the binary sum
        int currentIndex = (i>j?i:j);
        char[] sum = new char[currentIndex + 1];
        // Each for loop corresponds to a binary place sum
        while (i>=0 || j>=0) {
        	currentBinA = (i>=0)?a.charAt(i):'0';
        	currentBinB = (j>=0)?b.charAt(j):'0';
        	// The if statements contains all the possible cases of a binary sum
        	if (currentBinA == '1' && currentBinB == '1') {
        		sum[currentIndex] = carry?'1':'0';
        		// Carry is always true for this case, no matters its previous state
        		carry = true;
        	}else if (currentBinA == '0' && currentBinB == '0') {
        		sum[currentIndex] = carry?'1':'0';
        		// Carry is always false for this case, no matters its previous state
        		carry = false;
        	}else {
        		// Carry keeps the same of the previous loop
        		sum[currentIndex] = carry?'0':'1';
        	}
        	i--;
        	j--;
        	currentIndex--;
        }
        // If the sum of the previous binary place had an exceeding result, add it to 
        // the current decimal place
        if (carry) {
        	return "1"+String.valueOf(sum);
        }
        
        return String.valueOf(sum);
    }
	
}
