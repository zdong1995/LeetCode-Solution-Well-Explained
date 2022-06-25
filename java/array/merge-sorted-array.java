class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // null and empty check
        if (nums1 == null && nums2 == null || m == 0 && n == 0) {
            return;
        }
        
        // two pointers start from right to left
        int idx1 = m - 1;
        int idx2 = n - 1;
        int idxSol = m + n - 1;
        
        // when idx1 and idx2 both not out of bound, iteratively copy bigger number to end of nums1
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] >= nums2[idx2]) {
                nums1[idxSol--] = nums1[idx1--];
            } else {
                nums1[idxSol--] = nums2[idx2--];
            }
        }
        
        // post-processing
        while (idx2 >= 0) { // idx1 = -1, out of bound, copy all remaining nums2 to nums1
            nums1[idxSol--] = nums2[idx2--];
        }
        while (idx1 >= 0) { // idx1 = -2, out of bound, copy all remaining nums1 to nums1
            nums1[idxSol--] = nums1[idx1--];
        }      
    }
}