
public class SolutionLeetCode86 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1,new ListNode(5,new ListNode(3,new ListNode(5,new ListNode(6, new ListNode(2))))));
		//ListNode head = new ListNode(2);
		System.out.println(head);
		System.out.println(partition(head,4));
	}
	
	public static ListNode partition(ListNode head, int x) {
		// First node lower than x that is seen
		ListNode firstGreaterOrEqualX = null;
		// Last node lower than x that is seen
		ListNode lastLowerX = null;
		// Node that is currently being checked
		ListNode currentNode = head;
		// Node that is currently before currentNode
		ListNode lastNode = null;
		// New head of the LinkedList after partitioning
		ListNode newHead = head;
		// A node is going to be moved only when it is in the wrong partition. It happens only when
		// a value lower than x is seen after a value greater or equal to x.
		while (currentNode != null) {
			// If the node is lower than x and a node greater or equal to x has already been seen
			if (currentNode.val < x) {
				if (firstGreaterOrEqualX != null) {
					// Remove the current node from its position
					lastNode.next = currentNode.next;
					// If this is the first node lower than x that appeared, it will be the head
					if (lastLowerX == null) {
						newHead = currentNode;
					// If another node lower than x has already been seen, place the current node right after it
					}else {
						lastLowerX.next = currentNode;
					}
					// The first node greater or equal to x is put right after the current node
					currentNode.next = firstGreaterOrEqualX;
				}
				// The current node is now the last node lower than x seen so far
				lastLowerX = currentNode;
				if (firstGreaterOrEqualX != null) {
					// Trick done in order to go to the correct node since the current node was moved
					currentNode = lastNode;
				}
			// If the current node is greater or equal to x
			}else {
				// If this is the first node greater or equal to x, assign it to "firstGreaterOrEqualX"
				if (firstGreaterOrEqualX == null) {
					firstGreaterOrEqualX = currentNode;
				}
			}
			// Go to the next node
			lastNode = currentNode;
			currentNode = currentNode.next;
		}
		
		return newHead;
    }
	
	public static class ListNode{
		
		public int val;
		public ListNode next;
		
		public ListNode(int value) {
			this.val = value;
		}
		
		public ListNode(int value, ListNode next) {
			this.val = value;
			this.next = next;
		}
		
		public String toString() {
			String stringNode = "" + this.val;
			ListNode currentNode = this.next;
			while (currentNode != null) {
				stringNode += " -> "+currentNode.val;
				currentNode = currentNode.next;
			}
			return stringNode;
		}
		
	}

}
