class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node node1 = p, node2 = q;
        // traver upside to find the intersection
        // when node1 reach end, set node1 to start point of node2, i.e. q
        // thus node1 and node2 will traverse same length (height_p + height_q)
        while (node1 != node2) {
            node1 = node1.parent == null ? q : node1.parent;
            node2 = node2.parent == null ? p : node2.parent;
        }
        return node1;
    }
}