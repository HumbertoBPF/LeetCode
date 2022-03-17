
public class SolutionLeetCode92 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		System.out.println(reverseBetween(node1,1,1));
	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode nodeBefore = null;				// Node right before the list to be reversed
        ListNode nodeAfter = null;				// Node right after the list to be reversed
        ListNode firstNode = null;				// First node of the list to be reversed
        ListNode lastNode = null;				// Last node of the list to be reversed
        // Nodes that define the iteration window(they are constantly updated)
        ListNode previousNode = null;
        ListNode currentNode = head;			// Since the length of the LinkedList is at least 1, head!=null
        ListNode nextNode = head.next;
        
        int currentIndex = 0;
        while (currentNode != null) {
        	if (currentIndex+1 == left - 1) {
        		nodeBefore = currentNode;
        	}
        	if (currentIndex+1 == left) {
        		firstNode = currentNode;
        	}
        	// Reversing the list
        	if (currentIndex+1 > left && currentIndex+1 <= right) {
        		currentNode.next = previousNode;
        	}
        	if (currentIndex+1 == right) {
        		lastNode = currentNode;
        	}
        	if (currentIndex+1 == right + 1) {
        		nodeAfter = currentNode;
        		break;							// No need to continue from here
        	}
        	// Next node(we update all the nodes of the sliding window)
        	previousNode = currentNode;
        	currentNode = nextNode;
        	if (nextNode != null) {
            	nextNode = nextNode.next;
        	}
        	currentIndex++;
        }
        // Make the first node of the original list(that now must be at the end of the reversed list)
        // to point to the node that is right after the reversed list
        firstNode.next = nodeAfter;
        // Make the last node of the original list(that now must be at the beginning of the reversed list)
        // to point to the node that is right before the reversed list. Obviously, we only do it if there is a
        // node before the reversed list
        if (nodeBefore != null) {
            nodeBefore.next = lastNode;
        // If there is no node before the reversed list, it means that the first node of the list is the head
        }else {
        	return lastNode;
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
