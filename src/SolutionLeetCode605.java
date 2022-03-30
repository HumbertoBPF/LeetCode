
public class SolutionLeetCode605 {

	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		System.out.println(canPlaceFlowers(flowerbed,1));
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int currentPosition = 0;
		int numberOfPlots = flowerbed.length;
		int nbFlowersPlanted = 0;
		// Iterate until arriving at the end of the flower bed or until planting all the flowers
		while (currentPosition < numberOfPlots && nbFlowersPlanted < n) {
			// If the position right after the current one has a flower, jump to two positions after it, 
			// i.e. jump 3 positions
			if (currentPosition + 1 < numberOfPlots && flowerbed[currentPosition + 1] == 1) {
				currentPosition+=3;
				continue;
			}
			// If the position right before the current one has a flower, jump to two positions after it, 
			// i.e. jump 1 positions
			if (currentPosition - 1 >= 0 && flowerbed[currentPosition - 1] == 1) {
				currentPosition++;
				continue;
			}
			// If neither the previous plot nor the next plot are occupied, check the current plot. If it 
			// is empty, plant a flower
			if (flowerbed[currentPosition] == 0) {
				nbFlowersPlanted++;
			}
			// Independent if a flower was planted or not, skip two positions(if the current plot was not
			// occupied, it is now such that is necessary to skip two positions from the current one anyway)
			currentPosition+=2;
		}
		
		return nbFlowersPlanted==n;
    }
	
}
