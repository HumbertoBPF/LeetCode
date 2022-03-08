import java.util.ArrayList;
import java.util.List;

public class SolutionLeetCode23 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1,new ListNode(4, new ListNode(5)));
		ListNode l2 = new ListNode(1,new ListNode(3, new ListNode(4)));
		ListNode l3 = new ListNode(2,new ListNode(6));
		ListNode[] lists = {null,l1,l2,l3};
		System.out.println(mergeKLists(lists));
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		// If the list of LinkedLists has no items, return a null LinkedList
		if (lists.length == 0) {
			return null;
		}
		// If the list of LinkedLists has a unique item, return it
		if (lists.length == 1) {
			return lists[0];
		}
		// Variable with all the LinkedLists to be merged
		List<ListNode> listsToMerge = new ArrayList<>();
		// Add all the LinkedLists of the input array
		for (ListNode node : lists) {
			listsToMerge.add(node);
		}
		// Merge the LinkedLists two by two
		while (listsToMerge.size() != 1) {
			// List to store the result of a merging(intermediary results)
			List<ListNode> remainingLists = new ArrayList<>();
			// Here the LinkedLists are effectively merged two by two
			for (int i = 0;i < listsToMerge.size()/2;i++) {
				remainingLists.add(mergeTwoLists(listsToMerge.get(2*i),listsToMerge.get(2*i+1)));
			}
			// When we have an odd number of LinkedLists, we do not merge the last one,
			// which has to be added to 'remainingLists' separately
			if (listsToMerge.size()%2 != 0) {
				remainingLists.add(listsToMerge.get(listsToMerge.size()-1));
			}
			// Store the new LinkedLists to merge after the two by two merging
			listsToMerge = remainingLists;
		}
		// After merging all the LinkedLists, hopefully we have a unique LinkedList. So we return it
		return listsToMerge.get(0);
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
        System.out.println(headMergedList);
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
