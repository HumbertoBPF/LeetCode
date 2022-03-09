import java.util.HashMap;

public class SolutionLeetCode73 {

	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
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
		// Map to indicate the rows that must be set to zero
		HashMap<Integer,Boolean> zeroRows = new HashMap<>();
		// Map to indicate the columns that must be set to zero
		HashMap<Integer,Boolean> zeroColumns = new HashMap<>();
		// Iterating over the rows
		for (int i = 0;i < n;i++) {
			// Iterating over the columns
			for (int j = 0;j < m;j++) {
				if (matrix[i][j] == 0) {
					// Add row index to the map if it has not been added so far
					if (zeroRows.get(i) == null) {
						zeroRows.put(i, true);
					}
					// Add column index to the map if it has not been added so far
					if (zeroColumns.get(j) == null) {
						zeroColumns.put(j, true);
					}
				}
			}
		}
		// Set the rows of the map to zero
		for (int row : zeroRows.keySet()) {
			for (int i = 0;i < m;i++) {
				matrix[row][i] = 0;
			}
		}
		// Set the columns of the map to zero
		for (int column : zeroColumns.keySet()) {
			for (int i = 0;i < n;i++) {
				matrix[i][column] = 0;
			}
		}
    }
	
}
