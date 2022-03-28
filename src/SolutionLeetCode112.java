
public class SolutionLeetCode112 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5,
				new TreeNode(4,new TreeNode(11, new TreeNode(7),new TreeNode(2)),null),
				new TreeNode(8,new TreeNode(13),new TreeNode(4,null,new TreeNode(1))));
		TreeNode tree2 = new TreeNode(1, new TreeNode(2),new TreeNode(3));
		System.out.println(hasPathSum(null,0));
	}
	
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		// If the tree is empty, there are no root-leaf paths and then false is returned
		if (root == null) {
			return false;
		}
        return isPathSumDFS(root, targetSum, root.val);
    }
	
	public static boolean isPathSumDFS(TreeNode node, int targetSum, int currentSum) {
		boolean isPathSum = false;
		// If a leaf is reached, we check if the target sum was reached
		if (node.left == null && node.right == null) {
			return currentSum == targetSum;
		// If the current node is still not a leaf, keep searching
		}else {
			if (node.left != null) {
				// If by following this path we find the target sum, return true
				isPathSum = isPathSumDFS(node.left, targetSum, currentSum + node.left.val);
				if (isPathSum) {
					return true;
				}
			}
			
			if (node.right != null) {
				// If by following this path we find the target sum, return true
				isPathSum = isPathSumDFS(node.right, targetSum, currentSum + node.right.val);
				if (isPathSum) {
					return true;
				}
			}
		}
		
		return false;
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
