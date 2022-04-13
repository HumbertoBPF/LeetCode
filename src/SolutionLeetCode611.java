import java.util.Arrays;

public class SolutionLeetCode611 {

	public static void main(String[] args) {
		int[] nums = {2,2,3,4};
		triangleNumber(nums);
	}
	
	public static int triangleNumber(int[] nums) {
		int n = nums.length;
		
		if (n < 3) {
			return 0;
		}
		
		Arrays.sort(nums);
		
		int aIndex = 0, bIndex = 1;
		
		while (bIndex < n - 1) {
			int min = nums[bIndex] - nums[aIndex];
			int max = nums[bIndex] + nums[aIndex];
			
			int middleIndex;
			int lowerIndex = bIndex + 1;
			int upperIndex = n - 1;
			
			int nbItemsLowerOrEqToMin, nbItemsLowerThanMax;
			// Finding items lower or equal to |b-a|
			if (nums[upperIndex] <= min) {
				nbItemsLowerOrEqToMin = upperIndex + 1 - lowerIndex;
			}else if (nums[lowerIndex] > min) {
				nbItemsLowerOrEqToMin = 0;
			}else {
				while (upperIndex - lowerIndex > 1){
					middleIndex = (upperIndex + lowerIndex)/2;
					if (nums[middleIndex] <= min) {
						lowerIndex = middleIndex;
					}else {
						upperIndex = middleIndex;
					}
				}
				
				nbItemsLowerOrEqToMin = (nums[upperIndex]<=min)?upperIndex:lowerIndex;
			}
			// Finding items lower than a+b
			lowerIndex = bIndex + 1;
			upperIndex = n - 1;
			
			if (nums[upperIndex] < max) {
				nbItemsLowerThanMax = upperIndex + 1 - lowerIndex;
			}else if (nums[lowerIndex] >= max) {
				nbItemsLowerThanMax = 0;
			}else {
				while (upperIndex - lowerIndex > 1){
					middleIndex = (upperIndex + lowerIndex)/2;
					if (nums[middleIndex] < max) {
						lowerIndex = middleIndex;
					}else {
						upperIndex = middleIndex;
					}
				}
				
				nbItemsLowerThanMax = (nums[upperIndex]<max)?upperIndex:lowerIndex;
			}
			
			System.out.println("Items in the desired interval for a = "+nums[aIndex]+
					" and b = "+nums[bIndex]+" are the ones from "+nbItemsLowerOrEqToMin+" to "+nbItemsLowerThanMax);
			
			bIndex++;
		}
		
		return 0;
    }

}
