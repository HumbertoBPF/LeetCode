import java.util.Arrays;

public class SolutionLeetCode455 {

	public static void main(String[] args) {
		int[] g = {2,1};
		int[] s = {3,1,2};
		System.out.println(findContentChildren(g,s));
	}

	public static int findContentChildren(int[] g, int[] s) {
		int numberChildren = g.length;
		int numberCookies = s.length;
		// If there is no cookie, it is not possible to satisfy any child
		if (numberCookies == 0) {
			return 0;
		}
		// Because a cookie can only satisfy a children whose greedy is lower or equal than it, we are interested in
		// having the greedy factors and the sizes sorted
        Arrays.sort(g);
        Arrays.sort(s);
        
        int indexCookie = 0;
        int indexChildren = 0;
        int numberSatisfiedChildren = 0;
        // For each cookie, verify if it can satisfy the least greedy child that has not been satisfied yet.
        while (indexChildren < numberChildren && indexCookie < numberCookies) {
        	// If not, go to the next cookie since the current cookie certainly is not going to be able to satisfy 
        	// the next children
        	while (indexCookie < numberCookies && s[indexCookie] < g[indexChildren]) {
        		indexCookie++;
        	}
        	// If we are not out of cookies, the current cookie can satisfy the current child
        	if (indexCookie < numberCookies) {
            	numberSatisfiedChildren++;
        	}
        	
        	indexChildren++;
        	indexCookie++;
        }
        
        return numberSatisfiedChildren;
    }
	
}
