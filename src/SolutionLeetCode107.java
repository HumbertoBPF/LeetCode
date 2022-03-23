import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLeetCode107 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		System.out.println(levelOrderBottom(tree));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> valuesPerLevelBottomUp = new LinkedList<>();
		// Empty tree, return an empty list
		if (root == null) {
			return valuesPerLevelBottomUp;
		}
		// Use a LinkedList to store the nodes per level, since we are going to insert the nodes of deeper levels
		// at the beginning(operation expensive for an ArrayList due to the shifting of the other elements)
		Queue<TreeNode> nodesToVisit = new LinkedList<>();
		nodesToVisit.add(root);
		
		while (!nodesToVisit.isEmpty()) {
			// Here, we use an ArrayList, because the values of the current level are progressively inserted at the end 
			List<Integer> valuesCurrentLevel = new ArrayList<>();
			// Get the number of nodes of the current level before starting adding the nodes of the next level
			int numberNodesCurrentLevel = nodesToVisit.size();
			// Iterate over all nodes of the current level
			for (int i = 0;i < numberNodesCurrentLevel;i++) {
				TreeNode currentNode = nodesToVisit.poll();
				valuesCurrentLevel.add(currentNode.val);
				
				if (currentNode.left != null) {
					nodesToVisit.add(currentNode.left);
				}
				
				if (currentNode.right != null) {
					nodesToVisit.add(currentNode.right);
				}
			}
			// Add the values of the nodes of the current level at the beginning of the LinkedList
			valuesPerLevelBottomUp.add(0,valuesCurrentLevel);
		}
		
		return valuesPerLevelBottomUp;
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
