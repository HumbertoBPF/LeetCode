
public class SolutionLeetCode75 {

	public static void main(String[] args) {
		int[] nums = {2};
		sortColors(nums);
		for (int num : nums) {
			System.out.print(num+" ");
		}
	}
	
	public static void sortColors(int[] nums) {
        int n = nums.length;
        int nbOfZeros = 0;		// Number of zeros found so far
        int nbOfOnes = 0;		// Number of ones found so far
        int auxVar;
        
        for (int i = 0;i < n;i++) {
        	// If we find a zero at the ith position
        	if (nums[i] == 0) {
        		// We check the number that is in the position where the zero must go
        		auxVar = nums[nbOfZeros];
        		// If this number is an one, we put the zero found at the position where
        		// the next zero must go, we put the one that was at that position where
        		// the next one must go and finally we put the item that was at the 
        		// new position of the one at the ith position
        		if (auxVar == 1) {
        			nums[nbOfZeros] = nums[i];
        			nums[i] = nums[nbOfZeros+nbOfOnes];
        			nums[nbOfZeros+nbOfOnes] = auxVar;
        		// If the number is not an one, we swap the ith item with the item
        		// at the position where the zero must go
        		}else {
            		nums[nbOfZeros] = nums[i];
            		nums[i] = auxVar;
        		}
        		nbOfZeros++;
        	// If we find an one at the ith position
        	}else if (nums[i] == 1) {
        		// We swap the ith item with the item occupying the position where
        		// the one must go
        		auxVar = nums[nbOfZeros+nbOfOnes];
        		nums[nbOfZeros+nbOfOnes] = nums[i];
        		nums[i] = auxVar;
        		nbOfOnes++;
        	}
        }
    }

}
