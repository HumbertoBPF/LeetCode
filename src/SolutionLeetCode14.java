
public class SolutionLeetCode14 {

	public static void main(String[] args) {
		String[] strs = {""};
		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1) {				// input array contains a unique element, so it is returned
			return strs[0];
		}
		
		String commonPrefix = strs[0];
		String currentStr;
		
		for (int i=1;i<strs.length;i++) {
			if (commonPrefix.isEmpty()) {	// if commonPrefix is empty, no need to continue
				return commonPrefix;
			}
			
			currentStr = strs[i];
			String commonPart = "";
			int j = 0;
			while (j<currentStr.length() && j<commonPrefix.length() &&	// comparing the current commonPrefix 
					currentStr.charAt(j)==commonPrefix.charAt(j)) {		// with the current String
				commonPart += commonPrefix.charAt(j);
				j++;
			}
			
			commonPrefix = commonPart;
		}
		
		return commonPrefix;
    }

}
