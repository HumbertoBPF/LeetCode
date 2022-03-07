public class SolutionLeetCode33 {
	
	public static void main(String[] args) {
		int[] nums = {1,3,5};
		System.out.println(search(nums,3));
	}
	
	public static int search(int[] nums, int target) {
		if (nums.length == 1) {	// if there is only one element, the answer is trivial
			if (nums[0] == target) {
				return 0;
			}else {
				return -1;
			}
		}
		// First step: find the pivotPosition(position of the pivot item)
		// We find the step by testing if the item in the middle of the current interval([leftBound,rightBound])
		// is greater or lower than the item at leftBound. If it is greater(expected when there is no rotation), the pivot
		// item is after the middle of the current interval. Otherwise, the pivot item is before the middle index. Hence, 
		// the bounds are change such that the new interval contains the pivot item.
		int leftBound = 0;
		int rightBound = nums.length - 1;
		int middleIndex, pivotPosition;
		while (Math.abs(leftBound-rightBound) != 1) {
			middleIndex = (rightBound + leftBound)/2;
			if (nums[leftBound] > nums[middleIndex]) {	// the pivot element is between the middleIndex and the left bound
				rightBound = middleIndex;
			}else {										// the pivot element is between the middleIndex and the right bound
				leftBound = middleIndex;
			}
		}		
		// When leftBound and rightBound are neighbors, it means that one of them is the pivot item, so we test which one
		// contains the lowest value and we say that this is the pivot position.
		if (nums[leftBound] > nums[rightBound]) {
			pivotPosition = rightBound;
		}else {
			pivotPosition = leftBound;
		}
		// Testing if there is no rotation (for such case, the algorithm above fails and the lowest item is the first one)
		if (nums[pivotPosition] > nums[0]) {
			pivotPosition = 0;
		}
		// Second step: binary search
		leftBound = 0;						// position of the lower bound when there is no rotation
		rightBound = nums.length - 1;		// position of the upper bound when there is no rotation
		// Verifying if the target element is in the bounds of the input array
		// Lower bound rotated = pivotPosition
		if (nums[pivotPosition] == target) {
			return pivotPosition;
		}
		// Upper bound rotated = pivotPosition - 1 (if it is negative, it means that the upper bound was rotated to the end
		// of the array
		if (pivotPosition - 1 < 0) {
			if (nums[nums.length + pivotPosition - 1] == target) {
				return nums.length + pivotPosition - 1;
			}
		}else {
			if (nums[pivotPosition - 1] == target) {
				return pivotPosition - 1;
			}
		}
		while (Math.abs(leftBound-rightBound) != 1) {
			// Index of the middle item considering the rotation 
			middleIndex = (rightBound + leftBound)/2 - (nums.length - pivotPosition);
			// if the index of the middle item is negative, it means that it went to the end of the array with the rotation
			if (middleIndex < 0) {
				middleIndex = nums.length + middleIndex;
			}
			if (nums[middleIndex] == target) {	// if the target was found, return its position
				return middleIndex;
			// else, continue the binary search
			}else if (nums[middleIndex] < target) {
				leftBound = (rightBound + leftBound)/2;
			}else {
				rightBound = (rightBound + leftBound)/2;
			}
		}
		// Last check (skipped due to the condition of the while loop)
		if (nums[(rightBound + leftBound)/2] == target) {
			return (rightBound + leftBound)/2;
		}
		
		return -1;
    }
	
}
