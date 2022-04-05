import java.util.Stack;

public class SolutionLeetCode581 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		/*int[] nums = {2,6,4,8,10,9,15};*/ 
		System.out.println(findUnsortedSubarray(nums));
	}

	public static int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		Stack<Integer> monotonicStack = new Stack<>();
		// Indices that mark the boundaries of the shortest unsorted subarray
		int lowerIndex = n+1, upperIndex = -1;
		// Looking for the correct position of the lowest item out of order
		// Iterate from the start to the end of the input array		
		for (int i = 0;i < n;i++) {
			// When an item out of order is found, look for its correct position
			while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] > nums[i]) {
				// Pick the lowest item out of order
				lowerIndex = Math.min(lowerIndex, monotonicStack.pop());
			}
			monotonicStack.push(i);
		}
		// When no item out of order is found, return the length of an empty array
		if (lowerIndex == n+1) {
			return 0;
		}
		
		monotonicStack.clear();
		// Looking for the correct position of the greatest item out of order
		// Iterate from the end to the start of the input array
		for (int i = n-1;i >= 0;i--) {
			// When an item out of order is found, look for the correct position
			while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] < nums[i]) {
				// Pick the greatest item out of order
				upperIndex = Math.max(upperIndex, monotonicStack.pop());
			}
			monotonicStack.push(i);
		}
		
		return upperIndex - lowerIndex + 1;
    }
	
}
