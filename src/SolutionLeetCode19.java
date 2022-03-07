public class SolutionLeetCode19 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		System.out.println(removeNthFromEnd(l1,2).toString());
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode trackedNode = null;		// it will store the node right before the node to be removed
		ListNode currentNode = head;		// it will store the node to be removed
		int currentIndex = 0;				// stores the index of the currentNode in the LinkedList
		
		while (currentNode.next != null) {	// iterate until the end of the LinkedList
			currentNode = currentNode.next;	// go to the next node
			currentIndex++;
			
			if (currentIndex == n) {		// when we are far enough from the currentNode, we start tracking the node
											// right before the node to be removed
				trackedNode = head;
			}
			
			if (currentIndex > n) {
				trackedNode = trackedNode.next;
			}
		}
		
		// if there is a node right before the node to be removed(that is, when the node to be removed not the first one) 
		if (trackedNode != null) {
			currentNode = trackedNode.next;		// here, currentNode becomes the node to be removed
			trackedNode.next = currentNode.next;// the node to be removed is "skipped"
			currentNode.next = null;			// finishing to disconnect the node to be removed
		}else {
			currentNode = head;					// currentNode (node to be removed) is the head
			head = currentNode.next;			// we change the head to the next node
			currentNode.next = null;			// the old head is disconnected
		}
		
		return head;
	}
	
	public static class ListNode{
		
		public int value;
		public ListNode next;
		
		public ListNode(int value) {
			this.value = value;
		}
		
		public ListNode(int value, ListNode next) {
			this.value = value;
			this.next = next;
		}
		
		public String toString() {
			String stringNode = "" + this.value;
			ListNode currentNode = this.next;
			while (currentNode != null) {
				stringNode += " -> "+currentNode.value;
				currentNode = currentNode.next;
			}
			return stringNode;
		}
	}	

}
