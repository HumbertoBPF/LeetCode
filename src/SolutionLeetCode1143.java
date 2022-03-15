import java.util.HashMap;

public class SolutionLeetCode1143 {

	public static int counter;
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequenceBottomUp("ABCBDAB","BDCABA"));
	}
	
	public static int longestCommonSubsequence(String text1, String text2) {
		counter = 0;
		return longestCommonSubsequenceDP(text1,text2,text1.length(),text2.length(),new HashMap<String,Integer>());
    }
	
	public static int longestCommonSubsequenceBottomUp(String text1, String text2) {		
		int n = text1.length();
		int m = text2.length();
		// Matrix to store the solutions for the subproblems
		int[][] LCSMatrix = new int[n+1][m+1];
		
		for (int i = 1;i <= n;i++) {
			for (int j = 1;j <= m;j++) {
				// If the current chars are equal, we increment of one unit the maximum length
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					LCSMatrix[i][j] = LCSMatrix[i-1][j-1] + 1;
				// If the current chars are different, we compare the values of maximum length 
				// ignoring the current char of text1 and ignoring the current char of text2. Then we
				// pick the greatest
				}else {
					LCSMatrix[i][j] = Math.max(LCSMatrix[i][j-1],LCSMatrix[i-1][j]);
				}
			}
		}
		
		return LCSMatrix[n][m];
    }
	
	public static int longestCommonSubsequenceDP(String text1, String text2, int n, int m, 
			HashMap<String,Integer> map) {
		// Base case: one of the Strings is empty
		if (n == 0 || m == 0) {
			return 0;
		}
		
		String key = "";
		key += n;
		key += "|";
		key += m;
		
		// Check if the value has already been computed previously
		if (map.get(key) == null) {
			// If the last char is the same for both Strings, there is a common char and we shorten both Strings of one char
			if (text1.charAt(n-1) == text2.charAt(m-1)) {
				map.put(key, longestCommonSubsequenceDP(text1,text2,n-1,m-1,map) + 1);
			}else {
				// If the last char is different, we shorten one String of one char and keep the other the same.
				// Because we want the longest common subsequence, we have to take the maximum
				map.put(key, Math.max(longestCommonSubsequenceDP(text1,text2,n-1,m,map),
						longestCommonSubsequenceDP(text1,text2,n,m-1,map)));
			}
		}
		
		return map.get(key);
    }

}
