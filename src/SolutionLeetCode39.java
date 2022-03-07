import java.util.HashMap;

public class SolutionLeetCode39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int firstMissingPositive(int[] nums) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("min", nums[0]);
        map.put("max", nums[0]);
        map.put("firstMissing", nums[0]==1?2:1);
        int currentItem;
        
        for (int i=1;i<nums.length;i++) {
        	currentItem = nums[i];
        	
        	if (currentItem>0) {
        		if (currentItem==map.get("min")-1) {
        			map.put("min", currentItem);
        		}
        		if (currentItem==map.get("max")+1) {
        			map.put("max", currentItem);
        		}
        		if (currentItem==map.get("firstMissing")) {
        			if ((currentItem+1>map.get("min")) && (currentItem+1>map.get("max"))) {
        				map.put("firstMissing", map.get("max")+1);
        			}else {
        				map.put("firstMissing", currentItem+1);
        			}
        		}
        	}
        }
        
        return map.get("firstMissing");
    }

}
