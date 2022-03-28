
public class SolutionLeetCode110 {

	public static void main(String[] args) {
		TreeNode tree = null;
		System.out.println(isBalanced(tree));
	}
	
	public static boolean isBalanced(TreeNode root) {
		return traversalDFS(root,0)!=-1;
    }
	/**
	 * @param node root node of the subtree that is being traversed.
	 * @param currentDepth depth of the root node.
	 * @return the height of the subtree if it is balanced or -1 if the subtree is unbalanced.
	 */
	public static int traversalDFS(TreeNode node, int currentDepth) {
		// Empty tree, return 0
		if (node == null) {
			return 0;
		}
		
		int leftHeight = currentDepth;
		// If we have not reached a left leaf yet, continue the DFS and ask for the height of the left subtree
		if (node.left != null) {
			leftHeight = traversalDFS(node.left,currentDepth+1);
		}
		// If some of the heights is -1, it means that we have already found a unbalanced subtree
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = currentDepth;
		// If we have not reached a left leaf yet, continue the DFS and ask for the height of the right subtree
		if (node.right != null) {
			rightHeight = traversalDFS(node.right,currentDepth+1);
		}
		// If some of the heights is -1, it means that we have already found a unbalanced subtree
		if (rightHeight == -1) {
			return -1;
		}
		// Compare the heights of the left and of the right subtree. If the difference is greater than 1, return
		// -1 indicating that we have found an unbalanced subtree. Otherwise, return the height of this tree
		return (Math.abs(leftHeight - rightHeight) > 1?-1:Math.max(leftHeight, rightHeight));
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
