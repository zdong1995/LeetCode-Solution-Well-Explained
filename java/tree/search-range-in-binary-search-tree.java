public class Solution {
    public List<Integer> getRange(TreeNode root, int k1, int k2) {
      List<Integer> res = new ArrayList<Integer>();
      if (root == null) {
        return res;
      }
      inOrder(root, k1, k2, res);
      return res;
    }
  
    public void inOrder(TreeNode root, int min, int max, List<Integer> list) {
      // in-Order traverse and check bound conditon to determine whether need to traverse left,
      // or traverse right, or add to result list
      if (root == null) {
        return;
      }
      if (root.key > min) {
        // traverse leftside only when there is candidate in [min, root.key)
        // if root.key < min, no need, because result will be in the right subtree
        inOrder(root.left, min, max, list);
      }
      if (min <= root.key && root.key <= max) {
        list.add(root.key);
      }
      if (root.key < max) {
        // traverse rightside only when there is candidate in (root.key, max]
        // if root.key > max, no need, because result will be in the left subtree
        inOrder(root.right, min, max, list);
      }
    }
  }