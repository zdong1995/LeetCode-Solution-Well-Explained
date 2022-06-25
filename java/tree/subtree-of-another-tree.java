class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // assumption: s and n are not null
        if (s == null) {
            return false; // base case 1
        } else if (isSameTree(s, t)) {
            return true;
        }
        // traverse next level
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true; // base case 1: both reach null
        } else if (s == null || t == null || s.val != t.val) {
            // base case 2: only one reach null or have different root
            // avoid null pointer exception
            return false;
        }
        // traverse next level with corresponding order
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}