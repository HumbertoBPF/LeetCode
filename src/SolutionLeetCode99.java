import java.util.ArrayList;
import java.util.List;

public class SolutionLeetCode99 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1,new TreeNode(3, null, new TreeNode(2)),null);
		TreeNode tree2 = new TreeNode(3,new TreeNode(1),new TreeNode(4,new TreeNode(2),null));
		recoverTree(tree);
	}
	
	public static void recoverTree(TreeNode root) {
		inOrderDFS(root,new ArrayList<TreeNode>(),new ArrayList<TreeNode>(),true);
    }
	
	/**
	 * Performs an in-order DFS to find the nodes that are swapped and swaps them at the end of the
	 * DFS
	 * @param node node that is currently being visited.
	 * @param values list with the nodes of the tree in order.
	 * @param nodesToSwap nodes that have to be swap at the end.
	 * @param isFirstCall flag indicating if the current call of this function is the first one. It 
	 * is useful to know at which call we should swap the nodes.
	 */
	public static void inOrderDFS(TreeNode node, ArrayList<TreeNode> values, 
			ArrayList<TreeNode> nodesToSwap, boolean isFirstCall) {
		if (node.left != null) {
			inOrderDFS(node.left,values,nodesToSwap,false);
		}
		// When we find two nodes that are not in the expected order(ascending order), we will always
		// insert the current one at the first position of the list of nodes to swap. The last one is
		// added only for the first time that we find two items out of order.
		if (!values.isEmpty()) {
			TreeNode lastNode = values.get(values.size()-1);
			if (lastNode.val >= node.val) {
				if (nodesToSwap.isEmpty()) {
					nodesToSwap.add(lastNode);
					nodesToSwap.add(node);
				}else {
					nodesToSwap.set(1,node);
				}
			}
		}
		values.add(node);
		
		if (node.right != null) {
			inOrderDFS(node.right,values,nodesToSwap,false);
		}
		// At the end of the first call, we swap the nodes
		if (isFirstCall) {
			int auxVar = nodesToSwap.get(0).val;
			nodesToSwap.get(0).val = nodesToSwap.get(1).val;
			nodesToSwap.get(1).val = auxVar;
		}
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		return depthFirstSearch(root, new ArrayList<Integer>());
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
