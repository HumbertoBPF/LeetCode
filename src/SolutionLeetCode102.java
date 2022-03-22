import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLeetCode102 {

	public static void main(String[] args) {
		TreeNode root = null;
		System.out.println(levelOrder(root));
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> valuesPerLevel = new ArrayList<>();
		// For an empty tree, return an empty list
		if (root == null) {
			return valuesPerLevel;
		}	
		
		Queue<TreeNode> nodesToVisit = new LinkedList<>();
		nodesToVisit.add(root);
		// Stop if there is no node to be visited
		while (!nodesToVisit.isEmpty()) {								// O(number of layers)
			// Adds a null node to the end of the list in order to indicate the end of a level
			nodesToVisit.add(null);
			List<Integer> valuesCurrentLevel = new ArrayList<>();
			// Iterate until reaching the null item that was just appended (i.e. iterate over the current level)
			while (nodesToVisit.peek() != null) {						// O(number of items per layer)
				TreeNode currentNode = nodesToVisit.poll();
				valuesCurrentLevel.add(currentNode.val);
				// Add the children nodes to the end of the list
				if (currentNode.left != null) {
					nodesToVisit.add(currentNode.left);
				}
				if (currentNode.right != null) {
					nodesToVisit.add(currentNode.right);
				}
			}
			// Remove the null node that was appended to the list before the while loop
			nodesToVisit.poll();
			valuesPerLevel.add(valuesCurrentLevel);
		}
		
		return valuesPerLevel;
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
