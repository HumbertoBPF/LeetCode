import java.util.Arrays;

public class SolutionLeetCode561 {

	public static void main(String[] args) {
		int[] nums = {6,2,6,5,1,2};
		System.out.println(arrayPairSum(nums));
	}
	
	public static int arrayPairSum(int[] nums) {
		// The logic behind the following code is to pick the two greatest items to form a pair once, for this choice,
        // the minimum is the greatest possible among all the pairs. Then, we pick progressively the following two 
        // greatest items that has not been used yet
		Arrays.sort(nums);
        
        int maxSum = 0;
        int n = nums.length;
        // Since we are going to pick the items of the sorted array two by two and because the problem assures that
        // the number of items is pair, the minimums to be summed are the even indexed elements of the array
        for (int i = 0;i < n;i+=2) {
        	maxSum+=nums[i];
        }
        
        return maxSum;
    }

}
