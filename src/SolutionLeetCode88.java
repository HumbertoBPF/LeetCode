
public class SolutionLeetCode88 {

	public static void main(String[] args) {
		int[] nums1 = {0};
		int[] nums2 = {1};
		merge(nums1,nums1.length-nums2.length,nums2,nums2.length);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Moving the items of nums1 to its end
		for (int i = n+m-1;i >= n;i--) {
        	nums1[i] = nums1[i-n];
        }
		int i = 0;	// Pointer of nums1
		int j = 0;	// Pointer of nums2
		while (i < m || j < n) {
			// If we reached the end of num1, fill nums1 with the remaining items of nums2
			if (i == m) {
				while (j < n) {
					nums1[i+j] = nums2[j];
					j++;
				}
				break;
			}
			// If we reached the end of nums2, fill nums1 with the remaining items of nums1
			if (j == n) {
				while (i < m) {
					nums1[i+j] = nums1[n+i];
					i++;
				}
				break;
			}
			// Put the lower item in the current position of nums1
			if (nums1[n+i] < nums2[j]) {
				nums1[i+j] = nums1[n+i];
				i++;
			}else {
				nums1[i+j] = nums2[j];
				j++;
			}
		}
		
		for (int num : nums1) {
			System.out.print(num+" ");
		}
    }
	
}
