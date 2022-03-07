public class SolutionLeetCode21 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(4)));
		ListNode l2 = new ListNode(1,new ListNode(3, new ListNode(4)));
		System.out.println(mergeTwoLists(l1,l2));
	}
	
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// If one of the lists if null, return the other one
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		// Last node that was inserted into the merged list
        ListNode lastNodeMergedList = null;
        // Node to detach from one of the input lists and to add to the merged list
        ListNode nodeToDetach = null;
        // Head of the merged list(to be returned at the end)
        ListNode headMergedList = null;
        
        while (list1 != null && list2 != null) {
        	// We compare the current node of the input lists and we detach the lowest one
        	if (list1.val <= list2.val) {
        		nodeToDetach = list1;
        		// Go to the next node of the list with the lowest current node
        		list1 = list1.next;
        		// Detach the node
        		nodeToDetach.next = null;
        		// If the merged list has not been created yet, create it by adding the selected
        		// node. Besides we indicate that this node is the head of the merged list
        		if (lastNodeMergedList == null) {
        			lastNodeMergedList = nodeToDetach;
        			headMergedList = lastNodeMergedList;
        		// If the merged list has already been initialized, we add the selected node to it
        		// and we move the variable 'lastNodeMergedList' to the node that was just added
        		}else {
        			lastNodeMergedList.next = nodeToDetach;
        			lastNodeMergedList = lastNodeMergedList.next;
        		}
        	}else {
        		nodeToDetach = list2;
        		list2 = list2.next;
        		nodeToDetach.next = null;
        		if (lastNodeMergedList == null) {
        			lastNodeMergedList = nodeToDetach;
        			headMergedList = lastNodeMergedList;
        		}else {
        			lastNodeMergedList.next = nodeToDetach;
        			lastNodeMergedList = lastNodeMergedList.next;
        		}
        	}
        }
        // If, after comparing both LinkedList, there are remaining items in one of 
        // the lists, add them to the merged list
        if (list1 != null) {
        	lastNodeMergedList.next = list1;
        }
        
        if (list2 != null) {
        	lastNodeMergedList.next = list2;
        }
        
        return headMergedList;
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
