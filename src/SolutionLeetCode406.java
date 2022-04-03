import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SolutionLeetCode406 {

	public static void main(String[] args) {
		int[][] people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
		int[][] queue = reconstructQueue(people);
		for (int i = 0;i < queue.length;i++) {
        	System.out.println(queue[i][0]+" "+queue[i][1]);
        }
	}
	
	public static int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Person[] peopleSorted = new Person[n];
        // Positions of the output array(queue of people) that are available
        ArrayList<Integer> positionsAvailable = new ArrayList<>();
        // Create a person object for each item of the array people
        for (int i = 0;i < n;i++) {
        	peopleSorted[i] = new Person(people[i][0],people[i][1]);
        	positionsAvailable.add(i);
        }
        // Sort the array using the comparator created below
        Arrays.sort(peopleSorted,new HeightComparator());
        // We start to insert the items in the output array(the input array is going to be used to
        // return the output array) from the items with the lowest height
        for (int i = 0;i < n;i++) {
        	// We know that the items that will be inserted in the next iterations have their height 
        	// greater or equal to the current item due to the way in which the input array was sorted.
        	Person currentPerson = peopleSorted[i];
        	// Hence, let the number of people taller or with the same height as the current person be k,
        	// the current person will be inserted in the kth position available.
        	int insertionIndex = positionsAvailable.get(currentPerson.nbPeopleTallerOrSameHeight);
        	
        	people[insertionIndex][0] = currentPerson.height;
        	people[insertionIndex][1] = currentPerson.nbPeopleTallerOrSameHeight;
        	
        	positionsAvailable.remove(currentPerson.nbPeopleTallerOrSameHeight);
        }
        
        return people;
    }

	public static class Person {
		public int height;
		public int nbPeopleTallerOrSameHeight;
	
		public Person(int height, int nbPeopleTallerOrSameHeight) {
			this.height = height;
			this.nbPeopleTallerOrSameHeight = nbPeopleTallerOrSameHeight;
		}

		@Override
		public String toString() {
			return "People [height=" + height + ", nbPeopleTallerOrSameHeight=" + nbPeopleTallerOrSameHeight + "]";
		}
	}
	// Sort an array of people increasingly by height and then decreasingly by "nbPeopleTallerOrSameHeight"
	public static class HeightComparator implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			if (o1.height > o2.height) {
				return 1;
			}else if (o1.height < o2.height) {
				return -1;
			}
			
			if (o1.nbPeopleTallerOrSameHeight < o2.nbPeopleTallerOrSameHeight) {
				return 1;
			}else if (o1.nbPeopleTallerOrSameHeight > o2.nbPeopleTallerOrSameHeight) {
				return -1;
			}
			
			return 0;
		}
		
	}
}
