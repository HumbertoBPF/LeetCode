
public class SolutionLeetCode82 {

	public static void main(String[] args) {
		/*ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5)))))));*/
		ListNode head = new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3)))));
		System.out.println(head);
		System.out.println(deleteDuplicates(head));
		System.out.println(deleteDuplicates(new ListNode(1,new ListNode(1))));
	}

	public static ListNode deleteDuplicates(ListNode head) {
         ListNode node1 = null;			// Node to keep track of a non repeated node
         ListNode node2 = head;			// Current node of the iteration
         ListNode newHead = head;		// New head of the LinkedList without duplicates
         
         while (node2 != null && node2.next != null) {
        	 // If we find a repeated value(the successor of node2 has the same value)
        	 if (node2.val == node2.next.val) {
        		 // Find the last node containing this value and store in "node2"
        		 while (node2.val == node2.next.val) {
        			 node2 = node2.next;
        			 if (node2.next == null) {
        				 break;
        			 }
        		 }
        		 // If the node right before the sequence of duplicates is not null, we connect it
        		 // to the node right after this sequence
        		 if (node1 != null) {
        			 node1.next = node2.next;
        	     // If there is no node before the sequence of duplicates, the node right after 
        		 // this sequence is the newHead
        		 }else {
        			 newHead = node2.next;
        		 }
        		 // The last node of the sequence of duplicates is disconnected from the LinkedList
        		 node2.next = null;
        		 // The current node is set to the node right after the sequence of duplicates
        		 node2 = (node1 != null)?node1.next:newHead;
        	 // If the next value is not repeated, go to the next node keeping track of the current
        	 // one 
        	 }else {
        		 node1 = node2;			// Keep track of the current node
        		 node2 = node2.next;	// Go to the next node
        	 }
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
