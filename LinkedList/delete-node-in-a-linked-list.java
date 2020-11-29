class Solution {
    public void deleteNode(ListNode node) {
        // assumption: node is not tail
        // replace current node to next node
        node.val = node.next.val;
        // delete next node, in order to mimic deleting current node
        node.next = node.next.next; // node is not tail, thus will not NPE
    }
}