import java.util.ArrayList;

public class SolutionLeetCode101 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(2));
		System.out.println(isSymmetric(tree));
	}

	public static boolean isSymmetric(TreeNode root) {
		// We check first if the children nodes of root are equal or not so as to avoid performing 
		// unnecessary computations (if they are different, no need to continue)
		if (root.left != null && root.right != null) {
			if (root.left.val == root.right.val) {
		        return preOrderTraversalLeftTree(root.left,new ArrayList<Integer>())
		        		.equals(preOrderTraversalRightTree(root.right,new ArrayList<Integer>()));
			}
			return false;
		}else if (root.left == null && root.right == null) {
			return true;
		}else {
			return false;
		}
    }
	
	// Performs a pre-order traversal going from top to bottom and from the left to right
	public static ArrayList<Integer> preOrderTraversalLeftTree(TreeNode tree, ArrayList<Integer> values){
		// Show child null nodes since we want to distinguish left and right children nodes
		if (tree == null) {
			values.add(null);
			return values;
		}
		
		values.add(tree.val);
		
		if (tree != null) {
			preOrderTraversalLeftTree(tree.left, values);
		}
		
		if (tree != null) {
			preOrderTraversalLeftTree(tree.right, values);
		}
		
		return values;
		
	}
	
	// Performs a pre-order traversal going from top to bottom and from the right to left
	public static ArrayList<Integer> preOrderTraversalRightTree(TreeNode tree, ArrayList<Integer> values){
		// Show child null nodes since we want to distinguish left and right children nodes
		if (tree == null) {
			values.add(null);
			return values;
		}
		
		values.add(tree.val);
		
		if (tree != null) {
			preOrderTraversalRightTree(tree.right, values);
		}
		
		if (tree != null) {
			preOrderTraversalRightTree(tree.left, values);
		}
		
		return values;
		
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
