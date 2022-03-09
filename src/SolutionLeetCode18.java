import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionLeetCode18 {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(fourSum(nums, 0));
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		// List of all the quadruplets whose sum of its items is equal to target
		List<List<Integer>> quadruplets = new ArrayList<>();
		// HashMap with each combination that was already added to the output list
	 	HashMap<List<Integer>,Boolean> map = new HashMap<>();
	 	// To find a quadruplet, we need to have at least 4 integers in the array
 		if (nums.length<4) {
 	     	return quadruplets;
 	     }
		// Since we are going to apply two pointers algorithm, we need to sort
	    // the array, which takes O(n.log n)
		Arrays.sort(nums);
		
		for (int i = 0;i<nums.length-3;i++) {
			// Skip duplicated values(all combinations concerning them were already added)
			if (i > 0) {
				if (nums[i] == nums[i-1]) {
					continue;
				}
			}
			// We apply the 3Sum algorithm to find the quadruplets such that
			// the first item is nums[i] and the last three items sum target-nums[i].
			// In other words, we are searching the triplets such that the sum of its
			// items is target-nums[i].
			List<List<Integer>> quadrupletsThreeSum = threeSum(map, i+1, nums, target-nums[i]);
			// Iterate over the result to update the map and the list of quadruplets
			for (List<Integer> quadrupletThreeSum : quadrupletsThreeSum) {
				map.put(quadrupletThreeSum, true);
				quadruplets.add(quadrupletThreeSum);
			}
		}
		
		return quadruplets;
    }
	
	// - map: HashMap with each combination that was already added to the output list
	// - startIndex: the 3Sum algorithm will be applied considering the sub-array from
	// startIndex to the end of numsOrdered
	// - numsOrdered: input array ordered
	// - targetThreeSum: the target for 3Sum algorithm
	public static List<List<Integer>> threeSum(HashMap<List<Integer>,Boolean> map, 
			int startIndex, int[] numsOrdered, int targetThreeSum) {
		// List of all the quadruplets whose sum of its last three items is equal to targetThreeSum
	    List<List<Integer>> quadruplets = new ArrayList<>();
	    // 'leftPointer' and 'rightPointer' refer to two pointers algorithm
		// 'currentSum' is the currentSum that we are looking for, which 
		// corresponds to the symmetric of the item of the current iteration
	    int leftPointer, rightPointer, currentSum;
	    
	    for (int j = startIndex;j<numsOrdered.length-2;j++) {
	    	// Skip duplicated values(all combinations concerning them were already added)
	    	if (j > startIndex) {
	    		if (numsOrdered[j] == numsOrdered[j-1]) {
	    			continue;
		    	}
	    	}
	    	// Defining the interval over which the two pointers algorithm is 
	    	// going to be applied
	     	leftPointer = j + 1;
	     	rightPointer = numsOrdered.length - 1;
	     	// Applying two pointers algorithm in order to search for two numbers 
	     	// whose sum is targetThreeSum-numsOrdered[i]
	     	while (rightPointer-leftPointer != 1) {
	     		// Compute current sum
	     		currentSum = numsOrdered[leftPointer] + numsOrdered[rightPointer];
	     		// If the current sum is lower than the target one, we need to 
	     		// increase it, so we move the left pointer to the right
	     		if (currentSum < targetThreeSum-numsOrdered[j]) {
	     			leftPointer++;
	     		// If we have already gotten the target sum, return true
	     		}else if (currentSum == targetThreeSum-numsOrdered[j]){
	     			// We only add a quadruplet to the list of quadruplets if it had not been already added 
	     			List<Integer> quadruplet = getQuadruplet(numsOrdered, startIndex, leftPointer, rightPointer, j);
	     			if (map.get(quadruplet) == null) {
		     			quadruplets.add(quadruplet);
		     			map.put(quadruplet, true);
	     			}
	     			leftPointer++;
	     		// If the current sum is greater than the target one, we need to 
	     		// decrease it, so we move the right pointer to the left
	     		}else {
	     			rightPointer--;
	     		}
	     	}
	     	// Since we did not verify the current sum right before moving the 
	     	// pointers for the last time, we need to verify it right after leaving
	     	// the while loop
	     	currentSum = numsOrdered[leftPointer] + numsOrdered[rightPointer];
	     	if (currentSum == targetThreeSum-numsOrdered[j]){
	     		// We only add a quadruplet to the list of quadruplets if it had not been already added 
	     		List<Integer> quadruplet = getQuadruplet(numsOrdered, startIndex, leftPointer, rightPointer, j);
     			if (map.get(quadruplet) == null) {
	     			quadruplets.add(quadruplet);
	     			map.put(quadruplet, true);
     			}
	     	}
	     
	    }
	     
	    return quadruplets;
    }

	// Builds the quadruplet array. The first item is the one right before startIndex and the last 
	// three ones are provided by the output of 3Sum algorithm
	public static List<Integer> getQuadruplet(int[] nums, int startIndex, int leftPointer, int rightPointer, int i) {
		List<Integer> quadruplet = new ArrayList<>();
		quadruplet.add(nums[startIndex-1]);
		quadruplet.add(nums[i]);
		quadruplet.add(nums[leftPointer]);
		quadruplet.add(nums[rightPointer]);
		return quadruplet;
	}

}
