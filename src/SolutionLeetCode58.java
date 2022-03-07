
public class SolutionLeetCode58 {

	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(lengthOfLastWord(s));
	}

	public static int lengthOfLastWord(String s) {
        String sTrimmed = s.trim();
        int numberOfLettersLastWord = 0;
        
        for (int i = sTrimmed.length()-1;i>=0;i--) {
        	if (sTrimmed.charAt(i) != ' ') {
        		numberOfLettersLastWord++;
        	}else {
        		break;
        	}
        }
        
        return numberOfLettersLastWord;
    }
	
}
