
public class SolutionLeetCode35 {

	public static void main(String[] args) {
		int[] nums = {1,3};
		System.out.println(searchInsert(nums,0));
	}
	
	public static int searchInsert(int[] nums, int target) {
        int lowerBound = 0;
        int upperBound = nums.length - 1;
        int middleIndex;
        int targetIndex = -1;
        // If the target item is greater then the greatest item, it must be inserted after it
        if (target > nums[upperBound]) {
        	return upperBound+1;
        }
        // If the target item is lower then the lowest item, it must be inserted at its position
        if (target < nums[lowerBound]) {
        	return lowerBound;
        }
        // Verifying if the target item is at the bounds
        if (nums[lowerBound] == target) {
        	return lowerBound;
        }
        if (nums[upperBound] == target) {
        	return upperBound;
        }
        // Binary search to try to find the target item
        while (Math.abs(upperBound-lowerBound) != 1) {
        	middleIndex = (upperBound + lowerBound)/2;
        	if (nums[middleIndex] == target) {
        		targetIndex = middleIndex;
        		break;
        	}else if (nums[middleIndex] > target) {
        		upperBound = middleIndex;
        	}else {
        		lowerBound = middleIndex;
        	}
        }
        // If it is not found, return the upperBound, which is the position where it would be inserted
        if (targetIndex == -1) {
        	return upperBound;
        }
        
        return targetIndex;
    }

}
