import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLeetCode103 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3));
		System.out.println(zigzagLevelOrder(new TreeNode(1)));
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> valuesZigZag = new ArrayList<>();
		// For an empty tree, we return an empty list
		if (root == null) {
        	return valuesZigZag;
        }
        
		Queue<TreeNode> nodesToVisit = new LinkedList<>();
		// Flag indicating the direction to be followed
		boolean isLeftToRightDirection = true;
		
		nodesToVisit.add(root);
		
		while (!nodesToVisit.isEmpty()) {
			// Number of nodes of the current level
			int currentNumberNodes = nodesToVisit.size();
			// Static array with the exact size of the number of nodes of the current level
			Integer[] valuesCurrentLevel = new Integer[currentNumberNodes];
			// Insert the nodes of the current level into the list of values and add the children to the queue
			// of nodes to be visited(they are the nodes of the next level)
			for (int i = 0;i < currentNumberNodes;i++) {
				TreeNode currentNode = nodesToVisit.poll();
				// The insertion position depends on the direction
				valuesCurrentLevel[isLeftToRightDirection?i:currentNumberNodes-1-i] = currentNode.val;
				
				if (currentNode.left != null) {
					nodesToVisit.add(currentNode.left);
				}
				
				if (currentNode.right != null) {
					nodesToVisit.add(currentNode.right);
				}
			}
			
			valuesZigZag.add(Arrays.asList(valuesCurrentLevel));
			// Invert direction for the next level
			isLeftToRightDirection = !isLeftToRightDirection;
		}
		
        return valuesZigZag;
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
