
public class SolutionLeetCode83 {

	public static void main(String[] args) {
		ListNode head = null;
		System.out.println(head);
		System.out.println(deleteDuplicates(head));
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode node1 = head;	// Current node when iterating over the LinkedList
        ListNode node2;			// This object will hold the last node of a sequence of duplicates
        
        while (node1 != null && node1.next != null) {
        	// If node1 is the first node of a sequence of duplicates
        	if (node1.val == node1.next.val) {
        		node2 = node1.next;
        		// Look for the last node of the sequence node of duplicates
        		while (node2.next != null && node1.val == node2.next.val) {
        			node2 = node2.next;
        		}
        		// Bind the first node of the list of duplicates to the node right after the duplicates
        		node1.next = node2.next;
        		// Disconnect all the items of the list of duplicates except the first from the LinkedList
        		node2.next = null;
        	}
        	// Go to the next node of the LinkedList
        	node1 = node1.next;
        }
        
        return head;
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
