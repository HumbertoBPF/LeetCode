
public class SolutionLeetCode27 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		System.out.println(removeElement(nums,2));
	}
	
	public static int removeElement(int[] nums, int val) {
        int numberOfOccurrences = 0;	// number of occurrences of val
        int auxVariable;				// auxiliar variable for swapping the items of nums
        
        for (int i = 0;i < nums.length;i++) {
        	if (nums[i] == val) {
        		numberOfOccurrences++;
        	}else {						// swapping when finding an item different from value to put such item at the beginning of the array
        		auxVariable = nums[i];
        		nums[i] = nums[i - numberOfOccurrences];
        		nums[i - numberOfOccurrences] = auxVariable;
        	}
        }
        
        return nums.length - numberOfOccurrences;
    }

}
