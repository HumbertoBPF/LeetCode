
public class SolutionLeetCode81 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(search(nums, 1));
	}

	public static boolean search(int[] nums, int target) {
        int n = nums.length;
        
		if (nums[0] < nums[n-1]) {
			// BINARY SEARCH for the target value since THE ARRAY IS ORDERED
			int rightIndex = n - 1;
			int leftIndex = 0;
			int middleIndex;
			// Checking if the bound values are the target value
			if (nums[rightIndex] == target || nums[leftIndex] == target) {
				return true;
			}
			
			while (rightIndex - leftIndex > 1) {
				middleIndex = (leftIndex+rightIndex)/2;
				if (nums[middleIndex] == target) {
					return true;
				}else if (nums[middleIndex] < target) {
					leftIndex = middleIndex;
				}else {
					rightIndex = middleIndex;
				}
			}
		}else {
			// If THE ARRAY IS NOT ORDERED, we perform a LINEAR SEARCH, because we cannot 
			// find the pivot index using a binary search due to the presence of repeated items
			for (int i = 0;i < n;i++) {
				if (nums[i] == target) {
					return true;
				}
			}
		}
		
		return false;
    }
	
}
