class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length]; // store the color of each node
        Arrays.fill(visited, -1); // initialize all as unvisited
        for (int node = 0; node < graph.length; node++) {
            // bfs traverse all the neighbors of un-visited nodes
            if (visited[node] == -1 && !BFS(graph, node, visited)) {
                return false;
            }
        }
        return true;
    }
        
    private boolean BFS(int[][] graph, int node, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = 0; // set current node to group 0
        while (!q.isEmpty()) {
            int cur = q.poll();
            // expand all the neighbors of current node
            for (int neighbor : graph[cur]) {
                if (visited[neighbor] == -1) {
                    // unvisited, color to another color
                    visited[neighbor] = visited[cur] == 0 ? 1 : 0;
                    q.offer(neighbor);
                } else if (visited[neighbor] == visited[cur]) {
                    // current and its neighbor have same color
                    return false;
                }
            }
        }
        return true;
    }
}