public class SolutionLeetCode29 {

	public static void main(String[] args) {
		System.out.println(divide(7,-3));
	}
	
	public static int divide(int dividend, int divisor) {
        int sign = 1;									// variable indicating the sign of the quotient
        if ((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) {
        	sign = -1;
        }
        
        long quotientL = subDivision(Math.abs((long) dividend), Math.abs((long) divisor));	// start recursion
        
        if (sign == -1) {								// if the result should be negative
        	if (0-quotientL < Integer.MIN_VALUE) {		// testing lower bound
        		return Integer.MIN_VALUE;
        	}else {
        		return (int) (0-quotientL);
        	}
        }else {											// result should be positive
        	if (quotientL > Integer.MAX_VALUE) {		// testing upper bound
        		return Integer.MAX_VALUE;
        	}else {
        		return (int) (quotientL);
        	}
        }
    }
	
	// using longs to handle bounds(Integer.MIN_VALUE, which cannot has an absolute value when using integers)
	public static long subDivision(long dividendL, long divisorL) {
		if (dividendL < divisorL) {						//  stops the recursion when the dividend is lower than the divisor
														// (quotient is 0)
			return 0;
		}
		
		long sum = divisorL;
		long quotientL = 1;
		
		while ((sum + sum) < dividendL) {				// if it is allowed to double the sum, do it
			sum += sum;
			quotientL += quotientL;
		}
		
		return quotientL + subDivision(dividendL - sum, divisorL);
	}
	
	public static int divideSlow(int dividend, int divisor) {
        long dividendL;									// using longs to handle bounds(Integer.MIN_VALUE, which cannot has an
        												// absolute value when using integers)
		long divisorL;
		
		int sign = 1;									// variable indicating the sign of the quotient
        if ((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) {
        	sign = -1;
        } 
        int quotient = 0;
        long sum = 0;									// variable that will store quotient*divisor
        
        dividendL = Math.abs((long) dividend);			// we will work with the absolute value of the operators
        divisorL = Math.abs((long) divisor);
        
        while (dividendL - sum >= divisorL) {
        	if (sign == 1) {							// if the quotient is positive, we want to increment it
        		if (quotient == Integer.MAX_VALUE) {	// verifying upper-bound
    				return quotient;
    			}else {
    				quotient++;
    			}
        	}else {										// if the quotient is positive, we want to decrement it
        		if (quotient == Integer.MIN_VALUE) {	// verifying lower-bound
    				return quotient;
    			}else {
    				quotient--;
    			}
        	}
        	sum += divisorL;								// increment the sum by the divisor
        }
        
        return quotient;
    }

}
