// Time: O(N)
// Space: O(height)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) { // base case 1
            return true;
        } else if (p == null || q == null) { // base case 2
            return false;
        } else if (p.val != q.val) { // base case 3
            return false;
        }

        // if current node is the same, continue to compare the next level
        // check next layer and compare each position
        //         one                    two
        //  one.left  one.right   two.left   two.right

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}