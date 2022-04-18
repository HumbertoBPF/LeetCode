import java.util.HashMap;

public class ContestQuestion2 {

	public static void main(String[] args) {
		int[] tasks = {2,2,2,3,3};
		System.out.println(minimumRounds(tasks));
	}

	public static int minimumRounds(int[] tasks) {
        
		int numberOfRounds = 0;
		// Map to store the number of tasks by level
		HashMap<Integer, Integer> tasksByLevel = new HashMap<>();
		// Filling the map
		for (int task : tasks) {
			Integer value = tasksByLevel.get(task);
			
			if (value == null) {
				tasksByLevel.put(task, 1);
			}else {
				tasksByLevel.put(task, value+1);
			}
		}
		// The strategy here is to try to solve the most of tasks that we can by using blocks of three tasks.
		for (int level : tasksByLevel.keySet()) {
			int numberOfTasks = tasksByLevel.get(level);
			int blocksOfThree = numberOfTasks/3;
			int remainingTasks = numberOfTasks%3;
			// If there is no task remaining, we are done
			if (remainingTasks == 0) {
				numberOfRounds += blocksOfThree;
			// If there are two tasks remaining, solve them as a block of two
			}else if (remainingTasks == 2) {
				numberOfRounds += blocksOfThree + 1;	// The additional one corresponds to the block of two
			}else {
				// If there is only one remaining task and we do not have a block of three to borrow one task, 
				// it is impossible to solve a task
				if (blocksOfThree == 0) {
					return -1;
				// If there is only one remaining task and we have at least one block of three, we borrow one task
				// from this block such that we will solve the tasks with (blocksOfThree - 1) block of three and 2
				// blocks of two
				}else {
					numberOfRounds += (blocksOfThree - 1) + 2;
				}
			}
		}
		
		return numberOfRounds;
		
    }
	
}
