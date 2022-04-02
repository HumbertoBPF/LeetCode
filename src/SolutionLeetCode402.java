import java.util.Stack;

public class SolutionLeetCode402 {

	public static void main(String[] args) {
		System.out.println(removeKdigits("1432219",3));
	}

	public static String removeKdigits(String num, int k) {
        int n = num.length();
		// If we can remove all the digits of the number, we do it and return zero
		if (k == n) {
        	return "0";
        }
		// Not decreasing monotonic stack to store the digits of the output String 
		Stack<Character> digitsStack = new Stack<>(); 
		
		for (int i = 0;i < n;i++) {
			char currentDigit = num.charAt(i);
			// If the digit on the top of the stack is greater than the current digit, we
			// pop the stack, because it means that we can reduce a decimal place of the
			// input digit when we delete the digit that is there(since the next digit, which 
			// will occupy this position, is lower)
			while (k != 0 && !digitsStack.isEmpty() && digitsStack.peek() > currentDigit) {
				digitsStack.pop();
				k--;
			}
			digitsStack.push(currentDigit);
		}
		
		// If we are still allowed to remove some digits(k != 0), we simply do not consider the
		// last k digits since, for this case, the stack is entirely monotonic
		int stackLength = digitsStack.size() - k;
		int i = 0;
		
		num = "";
		// Building the output string
		for (Character digit : digitsStack) {
			if (i >= stackLength) {	// Go until "stackLength" index
				break;
			}
			// Condition to avoid leading zeros
			if (!(digit == '0' && num.isEmpty())) {
				num += digit;
			}
			i++;
		}
		
		return num.isEmpty()?"0":num;
    }
	
}
