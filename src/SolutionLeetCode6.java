
public class SolutionLeetCode6 {

	public static void main(String[] args) {
		System.out.println(convert("ABC",3));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		
        char[] charArray = s.toCharArray();
        String[] lines = new String[numRows];
        // initialization each position of lines
        for (int i=0;i<lines.length;i++) {
        	lines[i] = "";
        }
        
        int i = 0;	// row where the char is going to be inserted
        int j = 0;	// column where the char is going to be inserted
        
        while (i+2*j<charArray.length) {
        	int r = j%(numRows-1);
        	if (r==0) {				// columns that need to be fully filled
        		while ((i<numRows) && (i+2*j<charArray.length)) {
        			lines[i] += charArray[i+2*j];
        			i++;
        		}
        	}else {					// diagonal elements
        		i = numRows-1-r;
        		if (i+2*j>=charArray.length) {
        			break;
        		}
        		lines[i] += charArray[i+2*j];
        	}
        	i = 0;
        	j++;
        }
        
        String output = "";
        for (String line : lines) {
        	output += line;
        }
        
        return output;
    }
	
}
