public class SolutionLeetCode61 {

	public static void main(String[] args) {
		ListNode head = new ListNode(0,new ListNode(1,new ListNode(2)));
		System.out.println(rotateRight(head,4).toString());
	}

	public static ListNode rotateRight(ListNode head, int k) {
		// Linked list with 0 items
		if (head == null) {
			return head;
		}
		// Linked list with 1 item
		if (head.next == null) {
			return head;
		}
		
        int length = 1;
        ListNode lastNode = head;
        // Go until the last node to get the length of the list and the last node itself
        while (lastNode.next != null) {
        	lastNode = lastNode.next;
        	length++;
        }
        // Connect the last node to the head
        lastNode.next = head;
        
        ListNode currentNode = head;
        ListNode newHead = null;
        // Go the node with index (n-(n%k)-1) and disconnect it from the next node, which is the new head
        for (int i = 0;i < length;i++) {
        	if (i == length-(k%length)-1) {
        		newHead = currentNode.next;
        		currentNode.next = null;
        		break;
        	}
        	currentNode = currentNode.next;
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
