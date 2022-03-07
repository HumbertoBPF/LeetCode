
public class SolutionLeetCode26 {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(removeDuplicates(nums));	
	}
	
	public static int removeDuplicates(int[] nums) {
        int currentValue = -255;						// this variable holds a the last seen value 
        int nbRepeatedItems = 0;
        
        for (int i = 0;i<nums.length;i++) {
        	if (currentValue != nums[i]) {				// value not seen so far, so we put it in the next position available
        		currentValue = nums[i];
        		nums[i-nbRepeatedItems] = currentValue;	// i - nbRepeatedItems = next position available for a "not seen item"
        	}else {										// repeated value, so we increment the number of repeated items
        		nbRepeatedItems++;
        	}
        }
        // at the end, step is equal to the number of repeated items, so the output has to be the number of items minus step
        return nums.length - nbRepeatedItems;
    }
	
}
