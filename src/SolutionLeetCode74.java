
public class SolutionLeetCode74 {

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		for (int i = 0;i<matrix.length;i++) {
			for (int j = 0;j<matrix[0].length;j++) {
				System.out.println(searchMatrix(matrix,matrix[i][j]));
			}
		}
		System.out.println(searchMatrix(matrix,13));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;		// Number of rows
        int m = matrix[0].length;	// Number of columns
        // Since the matrix presents some kind of sort, we are going to perform 
        // a "binary search"
		int left = 0;
        int right = n*m - 1;
        int middle;
        int middleItem;
        
        if (matrix[0][0] == target || matrix[n-1][m-1] == target) {
        	return true;
        }
        
        while (right-left > 1) {
        	middle = (right+left)/2;
        	middleItem = matrix[middle/m][middle%m];
        	if (middleItem == target) {
        		return true;
        	}else if (middleItem > target) {
        		right = middle;
        	}else {
        		left = middle;
        	}
        }
        
        return false;
    }

}
