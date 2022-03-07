import java.util.HashMap;
import java.util.LinkedList;

class SolutionLeetCode1 {
	
	public static void main(String[] args) {
		int[] output = twoSum(new int[]{2,7,11,15},9);
		for (int i = 0;i<output.length;i++) {
			System.out.println(output[i]);
		}
		System.out.println();
	}
	
    public static int[] twoSum(int[] nums, int target) {
        
    	int[] output = new int[2];
    	// map : keys - values of the array nums, values - index of the value in nums
    	HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();
    	
    	for (int i=0;i<nums.length;i++) {
    		LinkedList<Integer> indexList = map.get(nums[i]);
    		// verifying if the value of the array is already in the map keys
    		if (indexList == null) {
    			indexList = new LinkedList<>();	// if it is not in the map, initialize the LinkedList value
    		}
    		indexList.add(i);
    		map.put(nums[i], indexList);
    	}
    	
    	for (int i=0;i<nums.length;i++) {
    		LinkedList<Integer> indexes = map.get(target-nums[i]);	// we check if the complement of nums[i] 
    																// appeared in the array
    		if (indexes != null) {
    			if (target-nums[i] == nums[i]) {	// if the complement of the current element of nums is 
    												// itself, it needs to appear twice in the input
    				if (indexes.size() >= 2) {
    					output[0] = indexes.get(0);
        				output[1] = indexes.get(1);	
    				}else {
    					continue;
    				}
    			}else {
    				output[0] = i;
    				output[1] = indexes.get(0);
    			}
				return output;
    		}
    	}
        
    	return new int[2];
    }
}