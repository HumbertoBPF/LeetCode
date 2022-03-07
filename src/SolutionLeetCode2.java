
public class SolutionLeetCode2 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4)));
		
		/*ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);*/
		
		/*ListNode l1 = new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9))));
		ListNode l2 = new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));*/
		
		System.out.println(addTwoNumbers(l1,l2).toString());
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// the only case where a leading zero must be returned is when the result of the calculation is zero
		if (l1.value == 0 && l2.value == 0 && l1.next == null && l2.next == null) {	
			return new ListNode(0);
		}
		
		return sumDecimalPlace(l1,l2,0);
    }
	
	public static ListNode sumDecimalPlace(ListNode l1, ListNode l2, int extra) {
		
		int val1 = 0;
		int val2 = 0;
		ListNode nextNode1 = null;
		ListNode nextNode2 = null;
		
		if (l1 != null) {
			val1 = l1.value;
			nextNode1 = l1.next;
		}
		if (l2 != null) {
			val2 = l2.value;
			nextNode2 = l2.next;
		}
		
		if (l1 == null && l2 == null && extra == 0) {	// recursion stops
			return null;
		}
		
		int r = (val1 + val2 + extra)%10; 
		int q = (val1 + val2 + extra - r)/10;
		
		ListNode node = new ListNode(r);
		node.next = sumDecimalPlace(nextNode1,nextNode2,q);
		
		return node;
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
