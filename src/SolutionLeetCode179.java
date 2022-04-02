import java.util.Arrays;
import java.util.Comparator;

public class SolutionLeetCode179 {

	public static void main(String[] args) {
		int[] numbers = {3,30,34,5,9};
		
		System.out.println(largestNumber(numbers));
	}
	
	public static String largestNumber(int[] nums) {
		int n = nums.length;
		// Array composed of the numbers of the input array converted into Strings
		String[] numsString = new String[n];
		// Fill the array numsString
		for (int i = 0;i < n;i++) {
			numsString[i] = String.valueOf(nums[i]);
		}
		// Sort the items of numsString according to the comparator specified
		Arrays.sort(numsString,new NumsStringComparator());
		
		String largestNumber = "";
		// Pick firstly the numbers evaluated as the greatest ones according to the criteria
		// described below(in the comparator class)
		for (int i = 0;i < n;i++) {
			String currentNumber = numsString[n-1-i];
			// Avoiding leading zeros
			if (!(largestNumber.isEmpty() && currentNumber.equals("0"))) {
				largestNumber += currentNumber;
			}
		}
		
		return largestNumber.isEmpty()?"0":largestNumber;
    }
	// Comparator sorting two numerical strings o1 and o2 according to if o1o2 or o2o1
	// is the greatest lexicographically string. We want to give priority to the greatest
	// String when choosing which number must be inserted first in the output String.
	public static class NumsStringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			long i1 = Long.parseLong(o1+o2);
			long i2 = Long.parseLong(o2+o1);
			if (i1 > i2) {
				return 1;
			}else if (i1 < i2) {
				return -1;
			}
			return 0;
		}
		
	}

}
