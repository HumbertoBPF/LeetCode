
public class SolutionLeetCode69 {

	public static void main(String[] args) {
		int x = 2147483647;
		System.out.println(x == Integer.MAX_VALUE);
		System.out.println(Math.sqrt(x));
		System.out.println(mySqrt(x));
	}

	public static int mySqrt(int x) {
		// Trivial case since 0 is the unique integer number whose integer part of
		// its square root is 0
		if (x == 0) {
        	return x;
        }
        // The variables upperBound and lowerBound will store the bounds that are going
		// to be used in an eventual binary search for the sqrt(x)
        int upperBound = 1;
        int lowerBound = 0;
        // Variables to be used for intermediary calculations
        int sqrtX, power2;
        // When we leave this while loop, upperBound is greater or equal to the sqrt(x)
        while ((upperBound*upperBound < x)) {
        	// We keep track on the last upperBound value, since it will be the last value
        	// whose square is lower than x, i.e. the lower bound of sqrt(x)
        	lowerBound = upperBound;
        	upperBound *= 2;
        	// The maximum square root value is 46340 since it corresponds to the sqrt of
        	// 2^31-1. So, in order not to have calculations problems due to the bounds of
        	// 32-bits integers, we have to be sure that we are in the bounds
        	if ((upperBound <= 46340 - upperBound)) {
        		upperBound = 46340;
        		break;
        	}
        }
        // We verify if sqrt(x) is equal to upper bound and if yes, return it
        if (upperBound*upperBound == x) {
        	return upperBound;
        }
        // If upperBound is not equal to sqrt(x), we do a binary search in the given interval
        // to find this value
        while (upperBound - lowerBound > 1) {
        	sqrtX = (upperBound+lowerBound)/2;
        	power2 = sqrtX*sqrtX;
        	if (power2 > x) {
        		upperBound = sqrtX;
        	}else if (power2 == x) {
        		return sqrtX;
        	}else {
        		lowerBound = sqrtX;
        	}
        }
        // For the bound case(sqrt(x) = 46340), we have both upper and lower bounds lower than
        // the actual square root. Therefore, when the square of the upper bound is lower than x, 
        // we return its value
        if (upperBound*upperBound < x) {
        	return upperBound;
        }
        // After the binary search, we return the lowerBound since the sqrt(x) must be the
        // integer part of the actual value
        return lowerBound;
    }
	
}
