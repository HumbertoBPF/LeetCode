import java.util.ArrayList;
import java.util.List;

public class SolutionLeetCode54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(spiralOrder(matrix).toString());
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        // defining bounds
        int jmax = matrix.length - 1;
        int imax = matrix[0].length - 1;
        int jmin = 0;
        int imin = 0;
        
        while ((jmax-jmin)>=0 && (imax-imin)>=0) {
        	for (int i=imin;i<=imax;i++) {			// going from the left top to the right top
        		spiral.add(matrix[jmin][i]);
        	}
        	for (int j=jmin+1;j<=jmax;j++) {		// going from the right top to the right bottom
        		spiral.add(matrix[j][imax]);
        	}
        	if (jmin != jmax) {						// avoid to "return through the same path" when jmin = jmax
        		for (int i=imax-1;i>=imin;i--) {	// going from the right bottom to the left bottom
            		spiral.add(matrix[jmax][i]);
            	}	
        	}
        	if (imin != imax) {						// avoid to "return through the same path" when imin = imax
        		for (int j=jmax-1;j>jmin;j--) {		// going from the left bottom to the left top
            		spiral.add(matrix[j][imin]);
            	}
        	}
        	// update bounds in order to move to the next layers
        	jmax--;
        	imax--;
        	jmin++;
        	imin++;
        }
        
        return spiral;
    }
	
}
