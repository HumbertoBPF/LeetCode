import java.util.HashMap;

public class SolutionLeetCode128 {

	public static void main(String[] args) {
		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));
	}

	public static int longestConsecutive(int[] nums) {
		// Map contains pairs (n,m). Each pair represents a collection of numbers {m,m+1,...,n-2,n-1}
		// Keys : values of the input array
		// Values : upper bound of the collection(not included)
		HashMap<Integer,Integer> map = new HashMap<>();
		int maxLength = 0;
		// Initialize the map. Each collection has initially only one number, which means that all
		// the items of the map are like (n,n-1)
		for (int key : nums) {
			if (map.get(key) == null) {
				map.put(key, key-1);
			}
		}
		// Merges the collections of map and simultaneously takes the max length
		for (int key : nums) {
			Integer neededKey = map.get(key);
			Integer value = map.get(neededKey);
			while (value != null) {
				map.put(key, value);
				map.remove(neededKey);
				neededKey = map.get(key);
				value = map.get(neededKey);
			}
			if (neededKey != null && key-neededKey>maxLength) {
				maxLength = key - neededKey;
			}
		}
		
		return maxLength;
    }
	
}
