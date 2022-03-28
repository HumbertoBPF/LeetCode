import java.util.ArrayList;
import java.util.List;

public class SolutionLeetCode113 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5,
				new TreeNode(4,new TreeNode(11, new TreeNode(7),new TreeNode(2)),null),
				new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
		TreeNode tree2 = new TreeNode(1, new TreeNode(2),new TreeNode(3));
		System.out.println(pathSum(tree2,3));
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		// Empty tree, return an empty list
        if (root == null) {
        	return new ArrayList<>();
        }
        // ArrayList representing the current path 
        ArrayList<Integer> currentPath = new ArrayList<>();
        currentPath.add(root.val);
        return getPathsWithSum(root,targetSum,root.val,currentPath,new ArrayList<>());
    }
	
	@SuppressWarnings("unchecked")
	public static List<List<Integer>> getPathsWithSum(TreeNode node, int targetSum, int currentSum, 
			ArrayList<Integer> currentPath, List<List<Integer>> pathsWithSum){
		// If we reached a leaf, check if this path has the target sum. If it has, add it to the list of paths
		if (node.left == null && node.right == null) {
			if (currentSum == targetSum) {
				pathsWithSum.add((List<Integer>) currentPath.clone());
			}
		// If the current node is not a leaf, keep going deeper
		}else {
			// If there is a left child node, follow this path
			if (node.left != null) {
				// We add this child node to the list of nodes to indicate that we are following this path
				currentPath.add(node.left.val);
				getPathsWithSum(node.left, targetSum, currentSum + node.left.val, currentPath, pathsWithSum);
				// After investigating this path, remove it
				currentPath.remove(currentPath.size()-1);
			}
			// If there is a right child node, follow this path
			if (node.right != null) {
				// We add this child node to the list of nodes to indicate that we are following this path
				currentPath.add(node.right.val);
				getPathsWithSum(node.right, targetSum, currentSum + node.right.val, currentPath, pathsWithSum);
				// After investigating this path, remove it
				currentPath.remove(currentPath.size()-1);
			}
		}
		
		return pathsWithSum;
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
