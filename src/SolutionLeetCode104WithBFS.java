import java.util.LinkedList;
import java.util.Queue;

public class SolutionLeetCode104WithBFS {

	public static void main(String[] args) {
		TreeNode root = null;
		System.out.println(maxDepth(root));
	}

	public static int maxDepth(TreeNode root) {
		int maxDepth = 0;
		// Empty tree has 0 depth
		if (root == null) {
			return maxDepth; 
		}
		// Performs a BFS to compute the max depth(= last level verified)
		Queue<TreeNode> nodesToVisit = new LinkedList<>();
		nodesToVisit.add(root);
		// Each level verified means an increment of the max depth
		while (!nodesToVisit.isEmpty()) {
			int nbNodesCurrentLvl = nodesToVisit.size();
			// Checks if there are children for the nodes of the current level
			for (int i = 0;i < nbNodesCurrentLvl;i++) {
				TreeNode currentNode = nodesToVisit.poll();
				// If there is left child for a given node, add it to the list of nodes to visit
				if (currentNode.left != null) {
					nodesToVisit.add(currentNode.left);
				}
				// If there is right child for a given node, add it to the list of nodes to visit
				if (currentNode.right != null) {
					nodesToVisit.add(currentNode.right);
				}
			}
			
			maxDepth++;
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
