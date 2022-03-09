import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionLeetCode56 {

	public static void main(String[] args) {
		int[][] intervals = {{2,3},{1,3}};
		for (int[] interval : merge(intervals)) {
			System.out.print("["+interval[0]+","+interval[1]+"] ");
		}
	}
	
	public static int[][] merge(int[][] intervals) {
        // ArrayList to store the merged intervals
		List<int[]> mergedIntervals = new ArrayList<>();
		// Array of all the bounds of the intervals to be merged
		int[][] bounds = new int[2*intervals.length][2];
		// Filling the list
		for (int i = 0;i < intervals.length;i++) {
			bounds[2*i][0] = intervals[i][0];
			bounds[2*i][1] = i;
			
			bounds[2*i+1][0] = intervals[i][1];
			bounds[2*i+1][1] = i;
		}
		// Sorting the list of bounds
		bounds = mergeSort(bounds);
		// Here we are going to determine the intervals that overlap
		HashMap<Integer,Boolean> map = new HashMap<>();
		
		int[] currentInterval = new int[2];
		boolean isBoundEqual = false;
		
		for (int i = 0;i < bounds.length;i++) {
			int[] bound = bounds[i];
			int idInterval = bound[1];
			if (map.isEmpty() && !isBoundEqual) {
				map.put(idInterval, true);
				currentInterval = new int[2];
				currentInterval[0] = bound[0];
			}else {
				if (map.get(idInterval) != null) {
					map.remove(idInterval);
					
					isBoundEqual = (i<bounds.length-1)?(bounds[i+1][1] != bound[1]) && (bounds[i+1][0] == bound[0]):false;
					
					if (map.isEmpty() && !isBoundEqual) {
						currentInterval[1] = bound[0];
						mergedIntervals.add(currentInterval);
					}
				}else {
					map.put(idInterval, true);
				}
			}
		}
		
		return mergedIntervals.stream().toArray(int[][]::new);
    }
	
	// Implementation of merge sort algorithm
	public static int[][] mergeSort(int[][] intervals) {
		int n = intervals.length;
		// Base case: when the input array has only one item, no need to split the 
		// array anymore
		if (n == 1) {
			return intervals;
		}
		// We split the input array into two sub-arrays 
		int[][] left = new int[n/2][2];
		int[][] right = new int[n-n/2][2];
		
		for (int i = 0;i < n/2;i++) {
			left[i] = intervals[i];
			right[i] = intervals[n/2+i];
		}
		// When the length is odd, we still have one item of the right array to fill
		if (n%2 != 0) {
			right[n-n/2-1] = intervals[n-1];
		}
		// After splitting all the sub-arrays into a single item sub-array, we start
		// merging them
		return mergeSubArrays(mergeSort(left), mergeSort(right));
	}
	
	public static int[][] mergeSubArrays(int[][] left,int[][] right) {
		int leftLength = left.length;
		int rightLength = right.length;
		
		int[][] mergedArray = new int[leftLength+rightLength][2];
		
		int i = 0;
		int j = 0;
		// We merge two sub-arrays and sort them simultaneously
		while (i<leftLength && j<rightLength) {
			if (left[i][0] < right[j][0]) {
				mergedArray[i+j] = left[i];
				i++;
			}else {
				mergedArray[i+j] = right[j];
				j++;
			}
		}
		// When we are done with respect to one array, we fill the merged array
		// with the items of the other one, which have already been sorted
		while (i < leftLength) {
			mergedArray[i+j] = left[i];
			i++;
		}
		while (j < rightLength) {
			mergedArray[i+j] = right[j];
			j++;
		}
		
		return mergedArray;
	}

}
