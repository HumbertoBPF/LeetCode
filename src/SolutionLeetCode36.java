import java.util.HashMap;

public class SolutionLeetCode36 {

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'}
						,{'6','.','.','1','9','5','.','.','.'}
						,{'.','9','8','.','.','.','.','6','.'}
						,{'8','.','.','.','6','.','.','.','3'}
						,{'4','.','.','8','.','3','.','.','1'}
						,{'7','.','.','.','2','.','.','.','6'}
						,{'.','6','.','.','.','.','2','8','.'}
						,{'.','.','.','4','1','9','.','.','5'}
						,{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		// Key: let n be a numeric char from 1 to 9
		//		r+n: 		n is present in the current row
		//		c+n:	n is present in the current column
		//		s+n:	n is present in the current square
		// Value: it is always true
        HashMap<String,Boolean> presentNumbers = new HashMap<>();
        
        for (int i = 0;i<board.length;i++) {	// i: fixed variable
        	presentNumbers.clear();
        	for (int j = 0;j<board.length;j++) {
        		if (board[i][j] != '.') {
        			// Verifying if value is present in ith row
            		if (presentNumbers.get("r"+String.valueOf(board[i][j])) != null) {
            			return false;
            		}
            		// Inserting the value present in the ith row
            		presentNumbers.put("r"+String.valueOf(board[i][j]),true);
        		}
        		if (board[j][i] != '.') {
        			// Verifying if value is present in ith column
            		if (presentNumbers.get("c"+String.valueOf(board[j][i])) != null) {
            			return false;
            		}
            		// Inserting the value present in the ith column
            		presentNumbers.put("c"+String.valueOf(board[j][i]),true);
        		}
        		if (board[j/3+3*(i/3)][j%3+3*(i%3)] != '.') {
        			// Verifying if value is present in ith square
            		if (presentNumbers.get("s"+String.valueOf(board[j/3+3*(i/3)][j%3+3*(i%3)])) != null) {
            			return false;
            		}
            		// Inserting the value present in the ith square
            		presentNumbers.put("s"+String.valueOf(board[j/3+3*(i/3)][j%3+3*(i%3)]),true);
        		}
        	}
        }
        
        return true;
    }
	
}
