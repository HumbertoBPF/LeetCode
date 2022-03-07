
public class SolutionLeetCode38 {

	public static void main(String[] args) {
		System.out.println(countAndSay(8));
	}
	
	public static String countAndSay(int n) {
        // if n = 1, the answer is immediate
		if (n==1) {
        	return "1";
        }
		// we need the current output of the recursion to count its numbers
        String previousOutput = countAndSay(n-1);
        // we are going to build progressively the current output of the recursion
        String currentOutput = "";
        // char representing the number that is progressively being counted
        char currentNumber = previousOutput.charAt(0);
        // since we have already taken into account the first char, we initialize the current quantity with 1
        int currentQtt = 1;
        
        for (int i=1;i<previousOutput.length();i++) {
        	// while the currenNumber keeps the same, we increment its quantity
        	if (currentNumber == previousOutput.charAt(i)) {
        		currentQtt++;
        	// when the currentNumber changes, we update the currentOutput and update currentNumber and currentQtt
        	}else {
        		currentOutput+=(currentQtt+String.valueOf(currentNumber));
        		currentNumber = previousOutput.charAt(i);
                currentQtt = 1;
        	}
        }
        // take into account the number that was being counted lastly
        currentOutput+=(currentQtt+String.valueOf(currentNumber));
        
        return currentOutput;
    }

}
