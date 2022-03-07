
public class SolutionLeetCode7 {

	public static void main(String[] args) {
		System.out.println(reverse(2147483647));
	}
	
	public static int reverse(int x) {
		String xString = String.valueOf(Math.abs(x));	// represent the number as a String without considering its sign
		char[] xCharArray = xString.toCharArray();
		int arrayLength = xCharArray.length;
		
		for (int i=0;i<arrayLength/2;i++) {				// reversing the array
			char auxVar = xCharArray[i];
			xCharArray[i] = xCharArray[arrayLength-1-i];
			xCharArray[arrayLength-1-i] = auxVar;
		}
		
		String outputString = String.valueOf(xCharArray);
		try {
			int output = Integer.parseInt(outputString);
			
			if (x < 0) {								// getting back the sign
				output *= -1;
			}
			
	        return output;
		}catch (NumberFormatException e) {
			return 0;
		}
    }

}
