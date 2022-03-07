public class SolutionLeetCode25MemoryOptimized {
	public static void main(String[] args) {
		System.out.println(reverseKGroup(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),3));
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k==1) {		// no swap needs to be performed for this case
			return head;
		}
		
		// new head(to be returned) node right before a block + blocks of nodes that need to be swapped
        ListNode newHead = null;
        // node right before the current block of nodes to be swapped
        ListNode previousNodeToBlock = null;
        // first node of the block of nodes to be swapped
        ListNode firstNode = head;
        // nodes to be used in the swapping process
        ListNode secondNode, thirdNode;
        // last node of the block of nodes to be swapped
        ListNode endNode = firstNode;
        
        for (int i = 1;i < k;i++) {	// initialization of endNode
        	endNode = endNode.next;
        }
        
        while (endNode != null) {
        	secondNode = firstNode.next;	// updating secondNode
        	// making the node right before a block to point to the last node of the block
        	if (previousNodeToBlock != null) {
        		previousNodeToBlock.next = endNode;
        	}
        	// making the first node of the block to point to the node right right after the block
        	firstNode.next = endNode.next;
        	previousNodeToBlock = firstNode;	// updating previousNodeToBlock for the next iteration
        	// swapping the nodes inside a block
        	while (firstNode != endNode) {
        		thirdNode = secondNode.next;
        		secondNode.next = firstNode;
        		firstNode = secondNode;
        		secondNode = thirdNode;
        	}
        	if (newHead == null) {	// setting the newHead(for the first loop)
        		newHead = endNode;
        	}
        	// go to the next block
        	firstNode = previousNodeToBlock.next;
        	endNode = firstNode;
        	for (int i = 1;i < k;i++) {
        		if (endNode != null) {
        			endNode = endNode.next;
        		}else {
        			break;
        		}
        	}
        }
        
        return newHead;
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
