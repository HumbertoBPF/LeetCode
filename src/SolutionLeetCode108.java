
public class SolutionLeetCode108 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5};
		System.out.println(sortedArrayToBST(nums));
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		return insertNodesBelowNode(null,nums);
    }
	
	public static TreeNode insertNodesBelowNode(TreeNode node, int[] nums) {
		int n = nums.length;
		
		int middleValue = nums[n/2];
		
		TreeNode newNode;
		// If it is the first iteration, create the root of the tree
		if (node == null) {
			node = new TreeNode(middleValue);
			newNode = node;
		// If it is not the first iteration, place the value in the middle of the input
		// array in the correct place with respect to the current node
		}else {
			if (middleValue < node.val) {
				node.left = new TreeNode(middleValue);
				newNode = node.left;
			}else {
				node.right = new TreeNode(middleValue);
				newNode = node.right;
			}
		}
		// If the input array has only one item, we are done
		if (n == 1) {
			return node;	
		}
		// If the input array has more than one item, we split it into two arrays composed
		// of the elements on the left and on the right of the middleValue
		int[] leftNodes = new int[n/2];
		int[] rightNodes = new int[n-1-n/2];
		// Fill the arrays
		for (int i = n/2+1;i < n;i++) {
			leftNodes[i-(n/2+1)] = nums[i-(n/2+1)];
			rightNodes[i-(n/2+1)] = nums[i];
		}
		// If n is even, the left array will have one additional item compared to the right array
		if (n%2 == 0) {
			leftNodes[n/2-1] = nums[n/2-1]; 
		}
		// If the left array is not empty, call recursion
		if (leftNodes.length != 0) {
			insertNodesBelowNode(newNode,leftNodes);
		}
		// If the right array is not empty, call recursion
		if (rightNodes.length != 0) {
			insertNodesBelowNode(newNode,rightNodes);	
		}
		
		return node;
	}
	
	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
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
