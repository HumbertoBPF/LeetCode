
public class SolutionLeetCode50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(0.00001,2147483647));
	}

	public static double myPow(double x, int n) {
		if (n == 0) {		// base case
			return 1;
		}
		
		if (n < 0) {		// negative exponent, invert the base	
			x=1/x;
		}
		
		int i = 1;			// power computed so far
		double factor = x;	// number that will be progressively multiplied by itself
		
		// if allowed, compute the double of the current power
		while ((2*i <= n) && (i < Integer.MAX_VALUE-i)) {		
			i*=2;
			factor*=factor;
		}
		
		// recursive call to compute the "remaining power"(|n|-i) and return
		return factor*myPow(x,Math.abs(n)-i);
    }
	
}
