import java.util.Arrays;
import java.util.Comparator;

public class SolutionLeetCode452 {

	public static void main(String[] args) {
		int[][] points = {{1,6},{5,8},{7,10},{9,11}};
		System.out.println(findMinArrowShots(points));
	}
	
	public static int findMinArrowShots(int[][] points) {
        int n = points.length;
		// Sort the items of the array of balloons objects by xmin coordinate
		Arrays.sort(points,new BalloonComparator());
		
		int numberOfShots = 1;
		int currentXmin, currentXmax;
		// Point that is going to be shot
		int lastIntersecXmax = points[0][1];
		
		for (int i = 1;i < n;i++) {
			currentXmin = points[i][0];
			currentXmax = points[i][1];
			// If there is no intersection between this balloon and the previous ones, a new shot is required
			if (currentXmin > lastIntersecXmax) {
				numberOfShots++;
				lastIntersecXmax = currentXmax;
			// If the xmax of the current balloon is lower than the 'lastIntersecXmax', we update this variable
			}else if (currentXmax < lastIntersecXmax){
				lastIntersecXmax = currentXmax;
			}
		}
		
		return numberOfShots;
    }
	// Comparator allowing to sort the array representing the balloons by xmin
	public static class BalloonComparator implements Comparator<int[]>{

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] > o2[0]) {
				return 1;
			}else if (o1[0] < o2[0]) {
				return -1;
			}
			return 0;
		}
		
	}
	
}
