class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // assumption: post.length = in.length >= 1
        Map<Integer, Integer> nodeIndex = new HashMap<>();
        // record the TreeNode and index pair to avoid duplicate search in recursion
        for (int i = 0; i < inorder.length; i++) {
            nodeIndex.put(inorder[i], i);
        }
        return construct(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, nodeIndex);
    }

    private TreeNode construct(int[] post, int postLeft, int postRight, int[] in, int inLeft, int inRight,
            Map<Integer, Integer> nodeIndex) {
        // base case
        if (postLeft > postRight) {
            return null;
        }
        // find the root node of current level to divide to left and right part
        TreeNode root = new TreeNode(post[postRight]);
        // find the index of root in in-order sequence
        int rootIdx = nodeIndex.get(root.val);
        int leftSize = rootIdx - inLeft; // record the size of left subtree
        // construct left and right recursively
        root.left = construct(post, postLeft, postLeft + leftSize - 1, in, inLeft, rootIdx, nodeIndex);
        root.right = construct(post, postLeft + leftSize, postRight - 1, in, rootIdx + 1, inRight, nodeIndex);
        return root;
    }
}