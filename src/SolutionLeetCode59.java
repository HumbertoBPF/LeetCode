
public class SolutionLeetCode59 {

	public static void main(String[] args) {
		int[][] matrix = generateMatrix(4);
		for (int[] row : matrix) {
			for (int item : row) {
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int currentNumber = 1;
		int layer = 0;
		
		while (layer <= (n-1)/2) {
			// For odd values for n, there is a central matrix element. It is 
			// not necessary to complete a circle in order to fill its unique 
			// element layer.
			if ((n%2 != 0) && (layer == (n-1)/2)) {
				matrix[layer][layer] = currentNumber;
				break;	// For these kind of matrix, the filling ends here
			}
			// Filling the top edge of this layer
			for (int i = layer;i<=(n-1-layer);i++) {
				matrix[layer][i] = currentNumber;
				currentNumber++;
			}
			// Filling the right edge of this layer
			for (int i = layer+1;i<=(n-1-layer);i++) {
				matrix[i][n-1-layer] = currentNumber;
				currentNumber++;
			}
			// Filling the bottom edge of this layer
			for (int i = (n-2-layer);i>=layer;i--) {
				matrix[n-1-layer][i] = currentNumber;
				currentNumber++;
			}
			// Filling the left edge of this layer
			for (int i = (n-2-layer);i>=layer+1;i--) {
				matrix[i][layer] = currentNumber;
				currentNumber++;
			}
			
			layer++;	// Next layer
		}
		
		return matrix;
    }

}
