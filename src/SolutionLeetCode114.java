
public class SolutionLeetCode114 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1,
				new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(5,null,new TreeNode(6)));
		TreeNode tree2 = new TreeNode(1, new TreeNode(2),new TreeNode(3));
		TreeNode tree3 = new TreeNode(1, null, new TreeNode(3));
		TreeNode tree4 = new TreeNode(1);
		flatten(tree4);
		System.out.println(tree4);
	}
	
	public static void flatten(TreeNode root) {
		// If the tree is empty, we have nothing to do
		if (root != null) {
			// Otherwise we get the LinkedList corresponding to the tree.
			TreeNode linkedList = traversalDFS(root, null);
			// The left subtree is set to null
			root.left = null;
			// The right subtree is set to be the subLinkedList starting from the second node since 
			// the first node of the LinkedList has the same value as the root node of the tree
			root.right = linkedList.right;
		}
	}
	
	public static TreeNode traversalDFS(TreeNode node, TreeNode linkedListLastNode) {
		// Keep track on the head in order to return that at the end
		TreeNode head = null;
		// If the LinkedList has already been initialized, append the LinkedList with the 
		// value of the current node and make its last node to point to the appended node
		if (linkedListLastNode != null) { 
			linkedListLastNode.right = new TreeNode(node.val);
			linkedListLastNode = linkedListLastNode.right;
		// Initialize the LinkedList for the first call of this function and update the head
		}else {
			linkedListLastNode = new TreeNode(node.val);
			head = linkedListLastNode;
		}
		// Append the LinkedList with the value of the left child node of the tree if it exists
		if (node.left != null) {
			linkedListLastNode = traversalDFS(node.left, linkedListLastNode);
		}
		// Append the LinkedList with the value of the right child node of the tree if it exists
		if (node.right != null) {
			linkedListLastNode = traversalDFS(node.right, linkedListLastNode);
		}
		// If we are in the first call of the function, returns the head of the LinkedList. 
		// Otherwise, return the last node of the LinkedList
		return (head == null)?linkedListLastNode:head;
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
	 
}
