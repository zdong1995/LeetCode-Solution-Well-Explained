public static class GraphNode {
    public int key;
    public List<GraphNode> neighbors;

    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}

public static boolean isBipartite(List<GraphNode> graph) {
    HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
    for (GraphNode node : graph) {
        if (!BFS(node, visited)) //这行代码什么意思？
            return false; 
    }
    return true;
}

private static boolean BFS(GraphNode node, HashMap<GraphNode,Integer> visited){
    if(visited.containsKey(node)) return true;
    Queue<GraphNode> queue = new LinkedList<GraphNode>();
    queue.offer(node);
    visited.put(node,0);
    while(!queue.isEmpty()){
      GraphNode cur= queue.poll();
      int curGroup= visited.get(cur);
      int neiGroup= curGroup==0?1:0; 
      for(GraphNode neighbor: cur.neighbors){
        if(!visited.containsKey(neighbor)){	   
            visited.put(neighbor,neiGroup);
            queue.offer(neighbor);
        }else if(visited.get(neighbor)!= neiGroup){
            return false;
      }
    }
  }
  return true;
}