
public class SolutionLeetCode134 {

	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas, cost));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
        // Variable to check if there is enough gas being sold to travel the circuit once
		int sum = 0;
        // Current amount of gas that is in the tank
        int amountGas = 0;
        // Position where we start counting the amount of gas
		int currentIndex = -1;
		int n = cost.length;
        
        for (int i = 0;i < n;i++) {
        	// We gain gas[i] by visiting this station, but we spend cost[i] to leave
        	int balance = gas[i] - cost[i];
        	sum += balance;
        	// Checks if the counting starts here
        	if (currentIndex == -1) {
    			currentIndex = i;
    		}
        	// Add the balance to the tank
        	amountGas+=balance;
        	// If we are negative, reset the counting 
        	if (amountGas < 0) {
        		amountGas = 0;
        		currentIndex = -1;
        	}
        }
        // If there is no need gas to visit all the stations, there is no solution for the problem
        if (sum < 0) {
        	return -1;
        }
        
        return currentIndex;
    }
	
}
