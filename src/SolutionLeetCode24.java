public class SolutionLeetCode24 {

	public static void main(String[] args) {
		System.out.println(swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))))));
		System.out.println(swapPairs(null));
		System.out.println(swapPairs(new ListNode(1)));
	}
	
	public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {	// if the LinkedList has zero or only one node, return the head
        	return head;
        }
        
        ListNode newHead = null;
        ListNode lastNode = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        
        while (currentNode != null && nextNode != null) {
        	// swapping the nodes
        	currentNode.next = nextNode.next;
        	if (lastNode != null) {	// there is no lastNode for the first node(head)
        		lastNode.next = nextNode;
        	}
        	nextNode.next = currentNode;
        	// update the head(to be returned at the end) at the first iteration
        	if (lastNode == null) {
        		newHead = nextNode;
        	}
        	// moving for the next node to be swapped
        	lastNode = currentNode;
        	currentNode = currentNode.next;
        	if (currentNode != null) {	// verifying if the updated currentNode is null before defining nextNode
        		nextNode = currentNode.next;
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
