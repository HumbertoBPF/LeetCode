
public class SolutionLeetCode581MemoryOptimized {

	public static void main(String[] args) {
		int[] nums = {1,3,2,3,3};
		/*int[] nums = {2,6,4,8,10,9,15};*/ 
		System.out.println(findUnsortedSubarray(nums));
	}

	public static int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		boolean isUnsortedPortion = false;
		int minUnsortedArray = 0, maxUnsortedArray = 0;
		// Find the lowest item that is in the wrong position
		for (int i = 1;i < n;i++) {
			// Detect that the unsorted subarray has startet 
			if (!isUnsortedPortion && nums[i] < nums[i-1]) {
				isUnsortedPortion = true;
				minUnsortedArray = nums[i];
			}
			// Find the lowest item
			if (isUnsortedPortion && minUnsortedArray > nums[i]) {
				minUnsortedArray = nums[i];
			}
		}
		// If the array is sorted, the length of the shortest unsorted subarray is 0
		if (!isUnsortedPortion) {
			return 0;
		}
		
		isUnsortedPortion = false;
		// Find the greatest item that is in the wrong position
		for (int i = n-2;i >= 0;i--) {
			// Detect that the unsorted subarray has startet
			if (!isUnsortedPortion && nums[i] > nums[i+1]) {
				isUnsortedPortion = true;
				maxUnsortedArray = nums[i];
			}
			// Find the greatest item
			if (isUnsortedPortion && maxUnsortedArray < nums[i]) {
				maxUnsortedArray = nums[i];
			}
		}
		
		int lowerIndex = 0, upperIndex = 0;
		int i = 0;
		// Looking for the correct position of the lowest item of the unsorted array
		while (nums[i] <= minUnsortedArray) {
			i++;
		}
		lowerIndex = i;
		
		i = n-1;
		// Looking for the correct position of the greatest item of the unsorted array
		while (nums[i] >= maxUnsortedArray) {
			i--;
		}
		upperIndex = i;
		
		return upperIndex - lowerIndex + 1;
    }
	
}
