class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    // construct maximum binary tree using input from nums[left] to nums[right]
    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) { // base case
            return null;
        }
        // find max to build root
        int max = nums[left]; // maximum value to be the root
        int rootIdx = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                rootIdx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        // build left and right
        root.left = construct(nums, left, rootIdx - 1);
        root.right = construct(nums, rootIdx + 1, right);
        
        return root;
    }
}