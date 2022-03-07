
public class SolutionLeetCode57 {

	public static void main(String[] args) {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {11,12};
		
		/*int[][] intervals = {{2,3},{6,9}};
		int[] newInterval = {10,11};*/
		
		int[][] result = insert(intervals,newInterval);
		for (int[] interval : result) {
			System.out.println("["+interval[0]+","+interval[1]+"]");
		}
	}
	
	public static int[][] insert(int[][] intervals, int[] newInterval) {
        // Variable that holds the number of intervals to be removed. An interval
		// is removed when it is merged with newInterval because there is an overlap
		// between them.
		int nbIntervalsToRemove = 0;
        // Position where newInterval is going to be inserted.
		int insertionIndex = 0;
		// Variable that is true while the number of intervals to remove is being
		// counted, that is, while the current interval is inside newInterval or
		// overlapping it.
        boolean isCountingIntervalsToRemove = false;
        
		for (int i = 0;i<intervals.length;i++) {
			// When isCountingIntervalsToRemove is false, we should check if we should start counting
			// the intervals to be removed. It should happen when there is an overlap between the
			// current interval and newInterval.
        	if (!isCountingIntervalsToRemove) {
        		// There are two cases where there is an intersection between the current interval and
        		// the newInterval. They are:
        		//		- start_i <= start-new <= end_i
        		//		- start_new <= start_i <= end_new
        		// For such cases, we modify the newInterval lower bound such as to contain the 
        		// current interval(we do an union with the first current interval that has an 
        		// overlap with him.
        		if ((intervals[i][0] > newInterval[0] && intervals[i][0] <= newInterval[1]) || 
        				(intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1])){
        			insertionIndex = i;
        			isCountingIntervalsToRemove = true;
        			newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
        		// if there is no overlap and the current interval is before newInterval, the insertion
        		// position is incremented.
        		}else if (intervals[i][0] < newInterval[0] && intervals[i][1] < newInterval[0]) {
        			insertionIndex++;
        		}
        	}
        	// If the intervals to remove are currently being counted, we must check if it is necessary
        	// to stop the counting. It should happen when we do not have an overlap anymore, that is:
        	//		- start_i > end_new
        	// For the case where there is an overlap of current interval with respect to outside 
        	// newInterval, that is:
        	//		- start_i <= end_new <= end_i
        	// Then, we should modify the upper bound of newInterval such that the current interval is
        	// contained in newInterval.
        	if (isCountingIntervalsToRemove) {
        		if (intervals[i][0] > newInterval[1]) {
        			isCountingIntervalsToRemove = false;
        		}else {
        			nbIntervalsToRemove++;
        			if (intervals[i][0] <= newInterval[1] && newInterval[1] <= intervals[i][1]){
            			newInterval[1] = intervals[i][1];
            		}
        		}
        	}
        }
		// Array with the intervals after insertion
		int[][] intervalsAfterInsertion = new int[intervals.length-nbIntervalsToRemove+1][2];
		// We add the elements of intervals that must be added
		for (int i = 0;i<intervals.length;i++) {
			// Intervals after the newInterval
			if (i <insertionIndex) {
				intervalsAfterInsertion[i] = intervals[i];
			}
			// Intervals after the newInterval
			if (i >= (insertionIndex + nbIntervalsToRemove)) {
				intervalsAfterInsertion[i-(nbIntervalsToRemove-1)] = intervals[i];
			}
        }
		// We add the newInterval
		intervalsAfterInsertion[insertionIndex] = newInterval;
		
		return intervalsAfterInsertion;
		
    }

}
