import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionLeetCode47 {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permuteUnique(nums));
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
        // Hash Table containing the number of occurrences of each number in the input array
		HashMap<Integer, Integer> numsOccurrences = new HashMap<>();
        for (int num : nums) {
        	Integer value= numsOccurrences.get(num);
        	if (value == null) {
        		numsOccurrences.put(num,1);
        	}else {
        		numsOccurrences.put(num,value+1);
        	}
        }
        // Sort the input(will be used to avoid repeated permutations)
        Arrays.sort(nums);
        
        return getPermutation(nums, numsOccurrences, new ArrayList<>(), new ArrayList<>());
    }
	
	public static List<List<Integer>> getPermutation(int[] nums, HashMap<Integer,Integer> numsOccurrences,
			List<Integer> permutation, List<List<Integer>> permutations){
		// If the size of the permutation list matches the length of the input array, all 
		// the items have been used and then we add the permutation to the permutation list
		if (permutation.size() == nums.length) {
			permutations.add(permutation);
			return permutations;
		}
		// Track the number of the previous iteration(avoids repeated permutations)
		Integer lastNum = Integer.MIN_VALUE;
		for (int num : nums) {
			Integer value = numsOccurrences.get(num);
			// If we do not have used all the occurrences of the current number in the current
			// permutation list and if the num is not lastNum, add it to the permutation array
			if (value != 0 && lastNum != num) {
				numsOccurrences.put(num, value-1);
				List<Integer> permutationCopy = new ArrayList<>(permutation);
				permutationCopy.add(num);
				getPermutation(nums, numsOccurrences, permutationCopy, permutations);
				// Increment the value corresp to num when returning from recursion
				value = numsOccurrences.get(num);
				numsOccurrences.put(num, value+1);
			}
			lastNum = num;
		}
		
		return permutations;
	}

}
