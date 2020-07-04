public class Solution {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true; // base case 1
        } else if (one == null || two == null) {
            return false; // base case 2
        } else if (one.key != two.key) {
            return false; // base case 3
        }
        /*
         * one two one.left one.right two.left two.right check next layer whether same
         * tree OR symmetric tree
         */
        return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
                || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
    }
}