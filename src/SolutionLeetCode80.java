
public class SolutionLeetCode80 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));
		for (int num : nums) {
			System.out.print(num+" ");
		}
	}
	
	public static int removeDuplicates(int[] nums) {
		// Duplicates = number of times that an item appeared - 2(i.e. number
		// of apparitions that should not happen)
		int nbDuplicates = 0;
		// The newest item seen so far, i.e. that had not been seen previously
		// (greatest number seen so far)
        int newestItem = nums[0];
        // Item correspondent to the current iteration and the number of times
        // that it has been seen
        int currentItem;
        int nbTimesCurrentItem = 1;
            
        for (int i = 1;i<nums.length;i++) {
        	currentItem = nums[i];
        	// If the current item had already been seen
        	if (currentItem == newestItem) {
        		nbTimesCurrentItem++;		// Increment its number of apparitions
        	}else {
        		newestItem = currentItem;	// Update 'newestItem'
        		nbTimesCurrentItem = 1;		// It is the first time that 'newestItem' is seen
        	}
        	// If the current item is seen after the second time, it is a duplicate
        	if (nbTimesCurrentItem > 2) {
        		nbDuplicates++;
        	// If the item is not a duplicate, it must be shifted to its correct position
        	// (the non duplicated items should appear in order such that the duplicates are skipped)
        	}else {
        		nums[i - nbDuplicates] = currentItem;
        	}
        }
        // Return the number of non duplicated items
        return nums.length - nbDuplicates;
    }

}
