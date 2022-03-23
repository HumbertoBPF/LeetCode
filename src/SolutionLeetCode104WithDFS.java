
public class SolutionLeetCode104WithDFS {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		System.out.println(maxDepth(root));
	}

	public static int maxDepth(TreeNode root) {
		// Empty tree has 0 depth
		if (root == null) {
			return 0;
		}
		return maxDepthDFS(root, 1, 0);
	}
	
	// Obtaining the deepest level by using DFS, i.e. we go the deepest that we can by following a 
	// branch until reaching a leaf.
	public static int maxDepthDFS(TreeNode node, int currentDepth, int maxDepth) {
		if (node.left != null) {
			maxDepth = maxDepthDFS(node.left, currentDepth+1, maxDepth);
		}
		
		if (node.right != null) {
			maxDepth = maxDepthDFS(node.right, currentDepth+1, maxDepth);
		}
		// When the leaf is reached, we verify if the current level is the deepest so far
		if (maxDepth < currentDepth) {
			maxDepth = currentDepth;
		}
		
		return maxDepth;
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
	}
	
}
