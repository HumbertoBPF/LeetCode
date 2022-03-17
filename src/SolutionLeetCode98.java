import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class SolutionLeetCode98 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(2,new TreeNode(1),new TreeNode(3));
		System.out.println(iterativeIsValidBST(tree));
	}

    public static boolean isValidBST(TreeNode root) {
    	return inOrderTraversal(root,new ArrayList<Integer>());
    }
    
    // In-order DFS, which should return the items in ascending order for a BST
    public static boolean inOrderTraversal(TreeNode tree,ArrayList<Integer> values) {
    	if (tree.left != null) {
    		if (!inOrderTraversal(tree.left,values)) {
    			return false;
    		}
    	}
    	// Verifies if the items really are being inserted in the ascending order
    	if (values.size() > 0 && values.get(values.size()-1) >= tree.val) {
    		return false;
    	}
    	values.add(tree.val);
    	
    	if (tree.right != null) {
    		if (!inOrderTraversal(tree.right,values)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public static boolean iterativeIsValidBST(TreeNode root) {
    	Stack<TreeNode> toBacktrack = new Stack<>();
    	HashMap<TreeNode,Boolean> visitedNodes = new HashMap<>();
    	List<Integer> values = new ArrayList<>();
    	
    	toBacktrack.add(root);
    	visitedNodes.put(root, true);
    	
    	while (!toBacktrack.isEmpty()) {
    		TreeNode currentNode = toBacktrack.peek(); 
    		
    		while (currentNode.left != null && visitedNodes.get(currentNode.left) == null) {
    			toBacktrack.add(currentNode.left);
    			visitedNodes.put(currentNode.left, true);
    			currentNode = currentNode.left;
    		}
    		
    		if (!values.isEmpty() && values.get(values.size()-1) >= currentNode.val) {
    			return false;
    		}
    		values.add(currentNode.val);
    		toBacktrack.pop();
    		
    		if (currentNode.right != null) {
    			toBacktrack.add(currentNode.right);
    			visitedNodes.put(currentNode.right, true);
    		}
    	}
    	
    	return true;
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
