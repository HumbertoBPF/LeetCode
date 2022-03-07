
public class SolutionLeetCode66 {

	public static void main(String[] args) {
		int[] nums = {4,3,2,1};
		for (int i: plusOne(nums)) {
			System.out.print(i+" ");
		}
	}

	public static int[] plusOne(int[] digits) {
        // Array returned if it is necessary an extra decimal place
		int[] sum = new int[digits.length+1];
        int digit;
        // Number added to the next decimal place if necessary
        int add = 1;
        
        for (int i = digits.length-1;i>=0;i--) {
        	digit = digits[i];
        	// Sum the current digit with the contribution of the previous decimal place
        	// (add variable), modify the original array and update the contribution
        	digits[i] = (digit+add)%10;
        	add = (digit+add)/10;
        	// We insert the result in the other array
        	sum[i+1] = digits[i];
            // If it is not necessary to add to the next decimal place, return the original array modified
        	if (add == 0) {
        		return digits;
        	}
        }
        // If it is necessary to add a decimal place to the original array, do it and 
        // return the new array
        sum[0] = add;
        return sum;
    }
}
