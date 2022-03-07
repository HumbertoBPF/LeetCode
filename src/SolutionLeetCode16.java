import java.util.Arrays;

public class SolutionLeetCode16 {

	public static void main(String[] args) {
		int target = 0;
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSumClosest(nums, target));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
        // Sort the input array(requirement of two pointers solution for two sum problem)
		Arrays.sort(nums);
		// Pointers two solve the two pointers problem of two sum(this problem will be reduced
		// to a two sum problem)
		int leftPointer, rightPointer;
		int targetTwoSum, currentTwoSum;
		// This variables store the modulus of the  difference between the target sum and the 
		// best sum so far. It is initialized with the greatest 32-bits integer.
		int bestDiff = Integer.MAX_VALUE;
		// Closest three sum to the target one
		int bestThreeSum = nums[0] + nums[1] + nums[2];
		int numsLength = nums.length;
		
		for (int i = 0;i < numsLength-2;i++) {
			// Since three numbers have to sum target, two of them must sum the target minus
			// the third one
			targetTwoSum = target - nums[i];
			// Bounds of the two pointers problem(for two sum)
			leftPointer = i + 1;
			rightPointer = numsLength - 1;
			
			while (rightPointer - leftPointer != 0) {
				System.out.println("rightPointer = "+rightPointer);
				System.out.println("leftPointer = "+leftPointer);
				currentTwoSum = nums[leftPointer] + nums[rightPointer];
				// If the difference to the target is lower than the lowest difference so far, store
				// the best values
				if (Math.abs(targetTwoSum-currentTwoSum) < bestDiff) {
					bestThreeSum = currentTwoSum + nums[i];
					bestDiff = Math.abs(targetTwoSum-currentTwoSum);
				}
				// Solution to the two sum problem
				if (currentTwoSum > targetTwoSum) {
					rightPointer--;
				}else if (currentTwoSum == targetTwoSum) {
					return bestThreeSum;
				}else {
					leftPointer++;
				}
			}
		}
		
		return bestThreeSum;
    }

}
