import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class SolutionLeetCode94 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1,null, new TreeNode(2, new TreeNode(3), null));
		TreeNode tree2 = new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));
		System.out.println(inorderTraversal(tree2));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		return depthFirstSearch(root, new ArrayList<Integer>());
    }
	
	public static List<Integer> inorderTraversalIterative(TreeNode root) {
		//  In order sequence of values
		List<Integer> inOrderValues = new ArrayList<>();
		// Avoiding null pointer exception
		if (root == null) {
			return inOrderValues;
		}
		// Stack of nodes that were still not added to the list of values(i.e. we have not finished their visit)
		Stack<TreeNode> toBacktrack = new Stack<TreeNode>();
		// List of nodes that have already been added to the list of values(i.e. we have finished their visit)
		HashMap<TreeNode,Boolean> visitedNodes = new HashMap<>();
		// Start with the root node
		toBacktrack.add(root);
		visitedNodes.put(root,true);
		TreeNode currentNode;
		// We are done when the satck of nodes to visit is empty
		while (!toBacktrack.isEmpty()) {
			// Pick the node on the top of the Stack and go left as far as we can
			currentNode = toBacktrack.peek();
			while (currentNode.left != null && visitedNodes.get(currentNode.left) == null) {
				toBacktrack.add(currentNode.left);
				visitedNodes.put(currentNode.left,true);
				currentNode = currentNode.left;
			}
			// When we cannot go left anymore, we add the value of the current node and pop it from the stack
			inOrderValues.add(currentNode.val);
			toBacktrack.pop();
			// Check if it is possible to go right
			if (currentNode.right != null) {
				toBacktrack.add(currentNode.right);
				visitedNodes.put(currentNode.right,true);
			}
		}
		
		return inOrderValues;
    }
	
	public static List<Integer> depthFirstSearch(TreeNode node, List<Integer> inOrderValues) {
		
		if (node.left != null) {
			depthFirstSearch(node.left,inOrderValues);
		}
		//  When the node is a left node, it will be added to the list of values only when coming back
		// to the previous node. This make that values that are more on the left than others to be added firstly.
		//  When the node is a right node, it will be added to the list of values as soon as this function
		// is called. This make that values that are more on the right than others to be added lastly.
		inOrderValues.add(node.val);
		
		if (node.right != null) {
			depthFirstSearch(node.right,inOrderValues);
		}
		
		return inOrderValues;
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
