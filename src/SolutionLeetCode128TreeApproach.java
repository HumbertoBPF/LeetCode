import java.util.ArrayList;

public class SolutionLeetCode128TreeApproach {

	public static void main(String[] args) {
		int[] nums = {1,2,0,1};
		System.out.println(longestConsecutive(nums));
	}
	
	public static int longestConsecutive(int[] nums) {
		// We are going to use a BST to store the items of the array and then we get 
		// them ordered by performing an in-order traversal and then it becomes easy
		// to get the max length
		int numsLength = nums.length;
		int maxLength = 0;
		TreeNode tree = null;
		// Create the tree if the input array is not empty
		if (numsLength > 0) {
			tree = new TreeNode(nums[0]);
		// If the input array is empty, return 0
		}else {
			return 0;
		}
		// Insert all the items of the input array in the tree (O(n*long n))
		for (int i = 1;i<numsLength;i++) {
			tree.insert(nums[i]);
		}
		// Get all the values ordered by perform an in-order traversal(O(n))
		ArrayList<Integer> valuesInOrder = tree.inOrderTraversal();
		int currentLength = 1;
		// Getting the max length(O(n))
		for (int i = 1;i < valuesInOrder.size();i++) {
			if (valuesInOrder.get(i) == valuesInOrder.get(i-1)+1) {
				currentLength++;
			}else {
				if (currentLength > maxLength) {
					maxLength = currentLength;
				}
				currentLength = 1;
			}
		}
		
		if (currentLength > maxLength) {
			maxLength = currentLength;
		}
		
		return maxLength;
    }
	
	public static class TreeNode {	
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
		
		// The insertion in a BST is O(log n)
		public void insert(int valToInsert) {
			TreeNode currentNode = this;
			
			while (currentNode != null) {
				if (currentNode.val > valToInsert) {
					if (currentNode.left == null) {
						currentNode.left = new TreeNode(valToInsert);
						break;
					}
					currentNode = currentNode.left;
				}else if (currentNode.val < valToInsert) {
					if (currentNode.right == null) {
						currentNode.right = new TreeNode(valToInsert);
						break;
					}
					currentNode = currentNode.right;
				}else {					// Do not store repeated values
					break;
				}
			}
		}
		
		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

		// The traversal of a BST is O(n)
		public ArrayList<Integer> inOrderTraversal(){
			return inOrderTraversalRecursion(this,new ArrayList<Integer>());
		}
		
		public ArrayList<Integer> inOrderTraversalRecursion(TreeNode node, ArrayList<Integer> values){
			if (node.left != null) {
				inOrderTraversalRecursion(node.left, values);
			}
			
			values.add(node.val);
			
			if (node.right != null) {
				inOrderTraversalRecursion(node.right, values);
			}
			
			return values;
		}
	}

}
