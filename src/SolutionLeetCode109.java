
public class SolutionLeetCode109 {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		System.out.println(sortedListToBST(head));
	}

	public static TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode currentNode = head;
        // Compute the length of the LinkedList
        while (currentNode != null) {
        	length++;
        	currentNode = currentNode.next;
        }
        
        return insertNodeToBST(null,head,length);
    }
	
	public static TreeNode insertNodeToBST(TreeNode node, ListNode head, int length) {
		// If the length of the LinkedList is 0, we have nothing to do
		if (length == 0) {
			return node;
		}
		// We consider only the sub-LinkedList composed of the "length" first items of "head"
		int middleIndex = length/2;
		int currentIndex = 0;
		ListNode middleNode = head;
		ListNode headRightList = head.next;
		// Select the node in the middle and the node right after it
		while (currentIndex != middleIndex) {
			middleNode = middleNode.next;
			if (headRightList != null) {
				headRightList = headRightList.next;
			}
			
			currentIndex++;
		}
		// Create a node for the tree with the value of the node in the middle
		TreeNode newNode = new TreeNode(middleNode.val);
		// If the tree has already been initialized(it already has at least one node), we insert
		// the node that was just created on the right or on the left child depending on its value
		if (node != null) {
			if (middleNode.val < node.val) {
				node.left = new TreeNode(middleNode.val);
				newNode = node.left;
			}else {
				node.right = new TreeNode(middleNode.val);
				newNode = node.right;
			}		
		}
		// If the length of the sub-LinkedList to be considered is one, no need to keep dividing it
		if (length == 1) {
			return newNode;
		}
		// Call recursion to divide the sub-LinkedList into two other LinkedLists(list of the items 
		// before the middle item and of the items after the middle item)
		insertNodeToBST(newNode,head,middleIndex);
		insertNodeToBST(newNode,headRightList,length - middleIndex - 1);
		
		return newNode;
	}
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
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
