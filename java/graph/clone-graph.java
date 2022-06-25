class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> copied = new HashMap<>();
        return dfs(node, copied);
    }
    
    // this method will reture the copy node of original node
    private Node dfs(Node node, Map<Node, Node> copied) {
        // base case
        if (node == null) { // case 1
            return null;
        }
        if (copied.containsKey(node)) { // case 2: copied
            return copied.get(node);
        }
        Node copyNode = new Node(node.val);
        copied.put(node, copyNode);
        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(dfs(neighbor, copied));
        }
        return copyNode;
    }                                 
}