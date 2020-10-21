class Solution {
    private double maxAvg = (double) Integer.MIN_VALUE;
    
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0.0;
        }
        dfs(root);
        return maxAvg;
    }
    
    private int[] dfs(TreeNode root) {
        // base case
        if (root == null) {
            return new int[] {0, 0};
        }
        
        // pair: [subtreeSum, nodeNum]
        // get pair from left child and right child
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int subtreeSum = left[0] + right[0] + root.val;
        int nodeNum = left[1] + right[1] + 1;
        // update global max
        maxAvg = Math.max(maxAvg, (double) subtreeSum / nodeNum);
        
        return new int[] {subtreeSum, nodeNum};
    }
}