
public class SolutionLeetCode334 {

	public static void main(String[] args) {
		int[] nums = {10,13,11,12,5,14};
		int[] nums2 = {20,100,10,12,5,13};
		System.out.println(increasingTriplet(nums2));
	}

	public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        // It is necessary to have at least 3 items
		if (n < 3) {
			return false;
		}
        
		int firstItemIndex = 0;
		int secondItemIndex = -1;
		// Searching for two items such that nums[firstItemIndex] < nums[secondItemIndex] and firstItemIndex < secondItemIndex
		int i = 1;
		
		while (secondItemIndex == -1 && i < n) {
			if (nums[firstItemIndex] >= nums[i]) {
				firstItemIndex = i;
				i++;
			}else {
				secondItemIndex = i;
			}
		}
		
		// Search the third item of the triplet
		int betterFirstItemIndex = firstItemIndex;
		
		for (int j = i+1;j < n;j++) {
			if (nums[j] > nums[firstItemIndex]) {
				// If the third item of the triplet is found, return true
				if (nums[j] > nums[secondItemIndex]) {
					return true;	
				// If a better second item is found(i.e. a second item lower than the current one), replace it	
				}else {
					secondItemIndex = j;
				}
			}else {
				// If a better first item is found(i.e. a first item lower than the current first), store it, but
				// do not replace for the moment(because to replace it, we need an item greater than it to be the
				// second item of the triplet)
				if (nums[j] <= nums[betterFirstItemIndex]){
					betterFirstItemIndex = j;
				// If a better second item can be obtained considering the better first item, replace the
				// first and second items of the triplet by the better first and second items
				}else if (nums[j] <= nums[secondItemIndex]){
					firstItemIndex = betterFirstItemIndex;
					secondItemIndex = j;
				}
			}
		}
		
		return false;
    }
	
}
