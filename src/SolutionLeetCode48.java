
public class SolutionLeetCode48 {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
	}

	public static void rotate(int[][] matrix) {
		// Dimension of the matrix
		int n = matrix.length;
		// Number of rotations that are going to be performed. A rotation is the action of rotating 4 items
		// of the matrix by 90 degrees such that we complete a cycle and come back to the initial position.
		int nbOfRotations = n-1;
		// Row where the rotation is going to be performed. This number can also be interpreted as the depth
		// of the rotation, i.e. which layer of the square will suffer the rotation. 
		int row = 0;
		// Value to be inserted in a certain position, value to be removed from that position, variable to
		// help to change the value of the indexes of the matrix.
		int valueToInsert, valueToRemove, auxIndex;
		// Indexes of the matrix(i-row,j-column)
		int i,j;
		while (nbOfRotations > 0) {
			for (int column = row;column < row+nbOfRotations;column++) {
				// Initial value of the variables for the current rotation
				i = row;
				j = column;
				valueToInsert = matrix[(n-1)-j][i];
				// Each iteration correspond to a 90 degrees rotation
				while (true) {
					// Do a backup of the value that is at this position
					valueToRemove = matrix[i][j];
					// Insert the new value
					matrix[i][j] = valueToInsert;
					// Give the removed value to the variable holding the insert value since it will be 
					// used for the next iteration
					valueToInsert = valueToRemove;
					// Update indexes
					auxIndex = j;
					j = (n-1)-i;
					i = auxIndex;
					// Verify if we have already returned to the start position
					if (i == row && j == column) {
						break;
					}
				}
			}
			// Go to the next layer
			row++;
			// For the next row/layer, we always decrement the number of rotations by 2
			nbOfRotations-=2;
		}
    }
	
}
