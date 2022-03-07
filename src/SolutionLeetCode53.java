
public class SolutionLeetCode53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		// The two pointers algorithm is going to be used with each pointer
		// stating at one extremity of the array
		int leftPointer = 0;
		int rightPointer = nums.length-1;
		// relativeSum: when an item is removed from [leftPointer,rightPointer],
		// it is subtracted from this variable. Hence, this variable stands for
		// the relative effect that this remotion has over the sum of the items
		// of the array, whichever it is. 
		int relativeSum = 0; 
		// We are interested in the lowest relative sum, because at the end of 
		// the code, some value of relativeSum variable has to be summed to the
		// actual sum so as to maximize the absoluteSum.
		int maxRelativeSum = 0;
		// It is the real sum of the array items. It is going to be computed while
		// the array is iterated by the pointers.
		int absoluteSum = 0;
		
		// Iteration of the pointers through the array.
		while (Math.abs(rightPointer-leftPointer) != 0) {
			// In order to decide which pointer(s) will move, we compare the values pointed by them. Because
			// the value of the moving pointer is removed from [leftPointer,rightPointer], we move the pointer
			// pointing to the lowest value.
			if (nums[leftPointer] < nums[rightPointer]) {
				relativeSum -= nums[leftPointer];
				absoluteSum += nums[leftPointer];
				leftPointer++;
			}else if (nums[leftPointer] > nums[rightPointer]) {
				relativeSum -= nums[rightPointer];
				absoluteSum += nums[rightPointer];
				rightPointer--;
			// If the pointed values are equal, we look to the item to be pointed after moving both pointers.
			// For this case, we move the pointer that will pointer to the lowest item.
			}else {
				if (Math.abs(rightPointer-leftPointer) > 1) {
					if (nums[leftPointer+1] < nums[rightPointer-1]) {
						relativeSum -= nums[leftPointer];
						absoluteSum += nums[leftPointer];
						leftPointer++;
					}else if (nums[leftPointer+1] > nums[rightPointer-1]) {
						relativeSum -= nums[rightPointer];
						absoluteSum += nums[rightPointer];
						rightPointer--;
					// If both pointers are going to point to the same value (but hold by 
					// different items), we move both pointers. 
					}else {
						relativeSum -= nums[leftPointer];
						absoluteSum += nums[leftPointer];
						leftPointer++;
						// Updates the maxRelativeSum here, because two moves are going to be performed
						if (maxRelativeSum < relativeSum) {
							maxRelativeSum = relativeSum;
						}
						relativeSum -= nums[rightPointer];
						absoluteSum += nums[rightPointer];
						rightPointer--;
					}
				//If both of them are going to point to the same item(there is only one 
				//item remaining in the interval when both move), we move anyone of them.
				}else {
					relativeSum -= nums[rightPointer];
					absoluteSum += nums[rightPointer];
					rightPointer--;
				}
			}
			// Updates the maxRelativeSum
			if (maxRelativeSum < relativeSum) {
				maxRelativeSum = relativeSum;
			}
			System.out.println("maxRelativeSum = "+maxRelativeSum);
			System.out.println("relativeSum = "+relativeSum);
		}
		
		// Adds the last element to the absolute sum
		absoluteSum += nums[rightPointer];
		
		return absoluteSum+maxRelativeSum;
    }
	
}
