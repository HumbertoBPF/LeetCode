import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionLeetCode101BFS {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		System.out.println(isSymmetric(tree));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		// We check first if the children nodes of root are equal or not so as to avoid performing 
		// unnecessary computations (if they are different, no need to continue)
		if (root.left != null && root.right != null) {
			if (root.left.val == root.right.val) {
				return traversalBFS(root);
			}
			return false;
		}else if (root.left == null && root.right == null) {
			return true;
		}else {
			return false;
		}
    }
	
	public static boolean traversalBFS(TreeNode root) {
		// Map to store the visited nodes (key = position and value = value contained in the node)
		HashMap<Integer,Integer> map = new HashMap<>();
		// Parent nodes of the next nodes to be visited
		Queue<LevelNode> parentNodes = new LinkedList<>();
		// Initialize with the nodes of the second layer (layer of index 1)
		parentNodes.add(new LevelNode(root.left,1,1));
		map.put(1, root.left.val);
		parentNodes.add(new LevelNode(root.right,2,1));
		map.put(2, root.right.val);
		// Breadth first search
		while (!parentNodes.isEmpty()) {
			LevelNode currentNode = parentNodes.poll();
			// Get level of the node and its position in order to find the symmetric node
			int level = currentNode.level;
			int position = currentNode.position;
			int symmetricPosition = 3*((int) Math.pow(2,level))-3-position;
			// If the symmetric node is empty or if its value is not equal to the value of the current node,
			// return false
			if (map.get(symmetricPosition) == null) {
				return false;
			}
			if (map.get(symmetricPosition) != currentNode.treeNode.val) {
				return false;
			}
			// Add children of the current node to the map and to the list of parent nodes
			TreeNode leftChild = currentNode.treeNode.left;
			if (leftChild != null) {
				parentNodes.add(new LevelNode(leftChild,position*2+1,level+1));
				map.put(position*2+1, leftChild.val);
			}
			TreeNode rightChild = currentNode.treeNode.right;
			if (rightChild != null) {
				parentNodes.add(new LevelNode(rightChild,position*2+2,level+1));
				map.put(position*2+2, rightChild.val);
			}
		}
		
		return true;
	}

	public static class LevelNode {
		public TreeNode treeNode;
		public int position;
		public int level;
		public LevelNode(TreeNode treeNode, int position, int level) {
			this.treeNode = treeNode;
			this.position = position;
			this.level = level;
		}
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
