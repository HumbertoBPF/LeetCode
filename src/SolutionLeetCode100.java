import java.util.ArrayList;

public class SolutionLeetCode100 {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(1));
		TreeNode q = new TreeNode(1,new TreeNode(1),new TreeNode(2));
		System.out.println(isSameTree(p,q));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrderTraversal(p,new ArrayList<Integer>()).equals(preOrderTraversal(q,new ArrayList<Integer>()));
    }
	
	// A pre-order traversal is the better traversal to represent a tree since it can be used to 
	// rebuild the tree
	public static ArrayList<Integer> preOrderTraversal(TreeNode node, ArrayList<Integer> values){
		// Before exploring the side items of the tree, we insert the visited node
		// REMARK : we allow the insertion of null values inside the output list since it
		// is useful to distinguish when we have a child in the left and in the right
		if (node == null) {
			values.add(null);
		}else {
			values.add(node.val);
		}
		
		if (node != null) {
			preOrderTraversal(node.left,values);
		}
		
		if (node != null) {
			preOrderTraversal(node.right,values);
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
