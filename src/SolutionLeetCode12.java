import java.util.HashMap;

public class SolutionLeetCode12 {

	public static void main(String[] args) {
		System.out.println(intToRoman(1994));
	}
	
	public static String intToRoman(int num) {
        HashMap<Integer,String> dictionary = new HashMap<>();	// build HashMap (key: Arabic numbers/value: Roman numbers)
        dictionary.put(1, "I");
        dictionary.put(4, "IV");
        dictionary.put(5, "V");
        dictionary.put(9, "IX");
        dictionary.put(10, "X");
        dictionary.put(40, "XL");
        dictionary.put(50, "L");
        dictionary.put(90, "XC");
        dictionary.put(100, "C");
        dictionary.put(400, "CD");
        dictionary.put(500, "D");
        dictionary.put(900, "CM");
        dictionary.put(1000, "M");
        
        int[] keys = {1000,900,500,400,100,90,50,40,10,9,5,4,1};	// keys of the HashMap in the decreasing order
        
        String romanNum = "";
        int remainder = num;
        int quotient;
        for (int key : keys) {									// verifying how many times each Roman number appears
        	quotient = remainder/key;
        	remainder = remainder%key;
        	for (int i=0;i<quotient;i++) {						// repeating the current value of the HashMap(current Roman
        														// number) the necessary number of times
        		romanNum += dictionary.get(key);
        	}
        	if (remainder == 0) {								// when the remainder is 0, go outside the loop(avoiding 
																// unnecessary iterations)
        		break;
			}
        }
        
        return romanNum;
    }

}
