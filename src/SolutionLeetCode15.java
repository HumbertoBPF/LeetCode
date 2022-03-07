import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionLeetCode15 {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums).toString());
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		// List of all the triplets whose sum of its items is equal to 0
	    List<List<Integer>> triplets = new ArrayList<>();
	    // HashMap with each combination that was already added to the output list
	 	HashMap<List<Integer>,Boolean> map = new HashMap<>();
	    // To find a triplet, we need to have at least 3 integers in the array
		if (nums.length<3) {
	     	return triplets;
	     }
		// Since we are going to apply two pointers algorithm, we need to sort
	    // the array, which takes O(n.log n)
		Arrays.sort(nums);
	    // 'leftPointer' and 'rightPointer' refer to two pointers algorithm
		// 'currentSum' is the currentSum that we are looking for, which 
		// corresponds to the symmetric of the item of the current iteration
	    int leftPointer, rightPointer, currentSum;
	    
	    for (int i = 0;i<nums.length-2;i++) {
	    	// Skip duplicated values(all combinations concerning them were already added)
	    	if (i > 0) {
	    		if (nums[i] == nums[i-1]) {
	    			continue;
		    	}
	    	}
	    	// Defining the interval over which the two pointers algorithm is 
	    	// going to be applied
	     	leftPointer = i + 1;
	     	rightPointer = nums.length - 1;
	     	// Applying two pointers algorithm in order to search for two numbers 
	     	// whose sum is -nums[i]
	     	while (rightPointer-leftPointer != 1) {
	     		// Compute current sum
	     		currentSum = nums[leftPointer] + nums[rightPointer];
	     		// If the current sum is lower than the target one, we need to 
	     		// increase it, so we move the left pointer to the right
	     		if (currentSum < -nums[i]) {
	     			leftPointer++;
	     		// If we have already gotten the target sum, return true
	     		}else if (currentSum == -nums[i]){
	     			// We only add a triplet to the list of triplets if it had not been already added 
	     			List<Integer> triplet = getTriplet(nums, leftPointer, rightPointer, i);
	     			if (map.get(triplet) == null) {
		     			triplets.add(triplet);
		     			map.put(triplet, true);
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
	     	currentSum = nums[leftPointer] + nums[rightPointer];
	     	if (currentSum == -nums[i]){
	     		// We only add a triplet to the list of triplets if it had not been already added 
	     		List<Integer> triplet = getTriplet(nums, leftPointer, rightPointer, i);
     			if (map.get(triplet) == null) {
	     			triplets.add(triplet);
	     			map.put(triplet, true);
     			}
	     	}
	     
	    }
	     
	    return triplets;
    }

	public static List<Integer> getTriplet(int[] nums, int leftPointer, int rightPointer, int i) {
		List<Integer> triplet = new ArrayList<>();
		triplet.add(nums[i]);
		triplet.add(nums[leftPointer]);
		triplet.add(nums[rightPointer]);
		return triplet;
	}
	
}
