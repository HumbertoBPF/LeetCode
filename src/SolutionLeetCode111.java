import java.util.LinkedList;
import java.util.Queue;

public class SolutionLeetCode111 {

	public static void main(String[] args) {
		TreeNode tree = null;
		System.out.println(minDepth(tree));
	}
	
	public static int minDepth(TreeNode root) {
		// If the tree is empty, the minimum depth is 0
		if (root == null) {
			return 0;
		}
		
		Queue<TreeNode> nodesToVisit = new LinkedList<>();
		nodesToVisit.add(root);
		int level = 1;
		// Perform BFS to find the minimal depth
		while (!nodesToVisit.isEmpty()) {
			int numberOfNodes = nodesToVisit.size();
			
			for (int i = 0;i < numberOfNodes;i++) {
				TreeNode currentNode = nodesToVisit.poll();
				// Return the level when finding the first leaf
				if (currentNode.left == null && currentNode.right == null) {
					return level;
				// If the current node is not a leaf, get its children
				}else {
					if (currentNode.left != null) {
						nodesToVisit.add(currentNode.left);
					}
					
					if (currentNode.right != null) {
						nodesToVisit.add(currentNode.right);
					}
				}
			}
			
			level++;
		}
		
		return level;
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
