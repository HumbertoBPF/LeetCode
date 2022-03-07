public class SolutionLeetCode25 {

	public static void main(String[] args) {
		System.out.println(reverseKGroup(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),1));
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k==1) {		// no swap needs to be performed for this case
			return head;
		}
		
		// new head(to be returned) node right before a block + blocks of nodes that need to be swapped
        ListNode newHead = null;
        ListNode[] nodesToSwap = new ListNode[k+1];
        
        nodesToSwap[1] = head;						// initialization
        for (int i = 2;i < k+1;i++) {
        	nodesToSwap[i] = nodesToSwap[i-1].next;
        }
        
        while (nodesToSwap[k] != null) {
        	// making the node right before a block to point to the last node of the block
        	if (nodesToSwap[0] != null) {
        		nodesToSwap[0].next = nodesToSwap[k];
        	}
        	// making the first node of the block to point to the node right right after the block
        	nodesToSwap[1].next = nodesToSwap[k].next;
        	// swapping the nodes inside a block
        	for (int i = k;i > 1;i--) {
        		nodesToSwap[i].next = nodesToSwap[i-1];
        	}
        	if (newHead == null) {	// setting the newHead(for the first loop)
        		newHead = nodesToSwap[k];
        	}
        	// go to the next block
        	nodesToSwap[0] = nodesToSwap[1];
        	for (int i = 1;i < k+1;i++) {
        		if (nodesToSwap[i-1] != null) {
        			nodesToSwap[i] = nodesToSwap[i-1].next;
        		}else {
        			nodesToSwap[k] = null;
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
