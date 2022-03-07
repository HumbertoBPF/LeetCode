public class SolutionLeetCode8 {

	public static void main(String[] args) {
		System.out.println(myAtoi("-91283472332"));
	}

	public static int myAtoi(String s) {
        int i = 0;
        int arrayLength = s.length();
        
        while ((i < arrayLength) && (s.charAt(i) == ' ')) {	// ignore white spaces
        	i++;
        }
        
        if (i >= arrayLength) {			// verifies if the end of the array was reached
        	return 0;
        }
        
        int sign = 1;
        
        if (s.charAt(i) == '-') {		// verifying whether sign was informed
        	sign = -1;
        	i++;
        }else if (s.charAt(i) == '+') {
        	i++;
        }
        
        int output = 0;
        
        while ((i < arrayLength) && (Character.isDigit(s.charAt(i)))) {
        	if ((sign > 0) && (output > 2147483647/10)) {	// verifies bounds
        		return 2147483647;
        	}
        	if ((sign < 0) && (output < -2147483648/10)) {
        		return -2147483648;
        	}
    		output*=10;			// skips one decimal place
    		
    		int valueAdded = Integer.parseInt(String.valueOf(s.charAt(i)));
    		if ((sign > 0) && (output > 2147483647 - valueAdded)) {	// verifies bounds
        		return 2147483647;
        	}
        	if ((sign < 0) && (output < -2147483648 + valueAdded)) {
        		return -2147483648;
        	}
        	output+=sign*valueAdded;	// adds the digit of the current position of charArray to the output	
        	i++;
        }
        
        return output;
    }
	
}
