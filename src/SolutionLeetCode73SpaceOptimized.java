public class SolutionLeetCode73SpaceOptimized {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
		setZeroes(matrix);
		
		for (int i = 0;i < matrix.length;i++) {
			for (int j = 0;j < matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void setZeroes(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		// We are going to use the first row items as flags to indicate if a given column
		// must be set as 0. When it is the case, the first item of this column is set to 
		// 0 to indicate that all the items of the concerned column must be set to 0.
		
		// Besides, we are going to use the first column items as flags for the rows by
		// applying a similar reasoning.
		
		// Because we cannot use the same item as flag for the first row and the first 
		// column, an additional variable will be used as flag.
		boolean isFirstColSetToZero = false;
		for (int i = 0;i < n;i++) {
			if (matrix[i][0] == 0) {
				isFirstColSetToZero = true;
				break;
			}
		}
		// Iterating over the rows
		for (int i = 0;i < n;i++) {
			// Iterating over the columns (we do not verify the first column since it has
			// already been done above)
			for (int j = 1;j < m;j++) {
				if (matrix[i][j] == 0) {
					// Set the first item of the row to indicate that the items of this
					// row must be set to 0
					matrix[i][0] = 0;
					// Set the first item of the column to indicate that the items of 
					// this column must be set to 0
					matrix[0][j] = 0;
				}
			}
		}
		// Checking if the rows and columns(except for the 0 indexed) must be set to zero
		for (int i = 1;i < n;i++) {
			for (int j = 1;j < m;j++) {
				if ((matrix[i][0] == 0) || (matrix[0][j] == 0)) {
					matrix[i][j] = 0;
				}
			}
		}
		// Checking if the first row needs to have its items set to 0
		if (matrix[0][0] == 0) {
			for (int j = 0;j < m;j++) {
				matrix[0][j] = 0;
			}
		}
		// Checking if the first column needs to have its items set to 0
		if (isFirstColSetToZero) {
			for (int i = 0;i < n;i++) {
				matrix[i][0] = 0;
			}
		}
    }

}
