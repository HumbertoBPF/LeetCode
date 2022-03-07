public class SolutionLeetCode34 {

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int[] targetBounds = searchRange(nums,6);
		System.out.println("lowerBound = "+targetBounds[0]);
		System.out.println("upperBound = "+targetBounds[1]);
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int[] targetBounds = {-1,-1};
		// Empty array, return {-1,-1}
		if (nums.length == 0) {
			return targetBounds;
		// Single item array, check unique item and depending on its value modify or not targetBounds and return
		}else if (nums.length == 1) {
			if (nums[0] == target) {
				targetBounds[0] = 0;
				targetBounds[1] = 0;
			}
			return targetBounds;
		}
		// Binary search to find a double closer to the target value than to its neighbors. Since the function responsible
		// for the binary search returns the index of the item which holds the closest value to target, if the target value
		// is in the array, its bounds will be returned. Else, both bounds will hold another value(by verifying if the returned
		// indexes really hold the target value, we conclude if it exists in the array)
		int lowerBound = binarySearch(nums,target - 0.1);
		int upperBound = binarySearch(nums,target + 0.1);
		
		if (nums[upperBound] != target) {	// if one of the bounds does not contain the target value, it does not exist
			return targetBounds;
		}
		
		targetBounds[0] = lowerBound;
		targetBounds[1] = upperBound;
		
		return targetBounds;
    }

	// This function executes a binary search, returning the index of the searched value. If the value is not found
	// it returns the index of the closest value.
	public static int binarySearch(int[] nums, double target) {
		int targetIndex = -1; 
		int middleIndex = -1;
		int lowerBound = 0;
		int upperBound = nums.length - 1;
		
		if (nums[lowerBound] == target) {					// verify if the lowerBound contains the target item
			targetIndex = lowerBound;
		}else if (nums[upperBound] == target) {				// verify if the upperBound contains the target item
			targetIndex = upperBound;
		}else {												// if the value is not found at the bounds, execute the binary search
			while (Math.abs(upperBound-lowerBound) != 1) {
				middleIndex = (upperBound+lowerBound)/2;
				if (nums[middleIndex] == target) {
					targetIndex = middleIndex;
					break;
				}else if (nums[middleIndex] > target) {
					upperBound = middleIndex;
				}else {
					lowerBound = middleIndex;
				}
			}
		}
		// If the value is not found, return the closest value in the array
		if (targetIndex == -1) {
			if (nums[upperBound] - target < target - nums[lowerBound]) {
				return upperBound;
			}else {
				return lowerBound;
			}
		}
		
		return targetIndex;
	}
	
}
