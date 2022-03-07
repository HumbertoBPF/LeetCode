
public class SolutionLeetCode11 {

	public static void main(String[] args) {
		int[] height = {1,1};
		System.out.println(maxArea(height));
	}
	
	public static int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int currentMax = 0;
        int currentArea;
        
        while (leftPointer != rightPointer) {
        	currentArea = (rightPointer - leftPointer)*Math.min(height[leftPointer], height[rightPointer]);
        	if (currentMax < currentArea) {
        		currentMax = currentArea;
        	}
        	if (height[rightPointer] < height[leftPointer]) {
        		rightPointer--;
        	}else {
        		leftPointer++;
        	}
        }
        
        return currentMax;
    }

}
