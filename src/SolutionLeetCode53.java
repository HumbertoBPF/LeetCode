
public class SolutionLeetCode53 {

	public static void main(String[] args) {
		int[] nums = {-2,-3,-1,-5};
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		// Solution using Kadane's algorithm
		// Maximum sum considering the subarrays ended with the current item of the for each loop
		int localMaximum = nums[0];
		// Maximum sum considering all the subarrays seen so far
		int globalMaximum = nums[0];
		
		for (int i = 1;i<nums.length;i++) {
			// The local maximum will be always between the array composed of only the current item
			// and the subarray correspondent to the last local maximum appended of the current item
			localMaximum = Math.max(localMaximum+nums[i], nums[i]);
			// Check if it is necessary to update the global maximum
			globalMaximum = Math.max(localMaximum, globalMaximum);
		}
		
		return globalMaximum;
    }
	
}
