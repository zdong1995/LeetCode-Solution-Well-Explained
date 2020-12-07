class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length, col = grid[0].length;
        int[][] cost = new int[row][col];
        // cost[i][j] represent the distance sum from all buildings to land[i][j]

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) { // run bfs on each building
                    if (!updateCost(grid, i, j, cost)) { // there is building not reachable, no solution
                        return -1;
                    }
                }
            }
        }
        // after updated cost for each land, find the shortest distance
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) { // check cost of each reachable land
                    shortest = Math.min(shortest, cost[i][j]);
                } else if (grid[i][j] == 3) { // lands that we excluded from possible solutions
                    grid[i][j] = 0; // recover these cell to the original value 0
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    // using bfs to start from one building to find distance to each land
    // return true if we successful reached all buildings
    private boolean updateCost(int[][] grid, int x, int y, int[][] cost) {
        // assumption: grid and cost not null, i and j will not out of bound
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(x, y));
        
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        int distance = 1; // initialize: first level of bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Cell cur = queue.poll();
                for (int[] dir : DIRECTIONS) {
                    int i = cur.x + dir[0], j = cur.y + dir[1];
                    if ((i >= 0 && i < row) && (j >= 0 && j < col) 
                        && !visited[i][j] && grid[i][j] != 2) { // not visited and not obstacles
                        visited[i][j] = true;
                        if (grid[i][j] == 1) { // we only mark the visited of building, not pass through
                            continue;
                        }
                        queue.offer(new Cell(i, j)); // add neighbor land to the queue
                        cost[i][j] += distance; // update cost
                    }
                }
            }
            distance++;
        }
        // boil down the search range to speed up and pruning unsolvable case to end earlier
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == 0) {
                        // if there is land that can not be reached, then it won't be the answer
                        // we can exclude these cells out from candidates pool
                        grid[i][j] = 3; // mark these cell as non-land (non-0)
                    } else if (grid[i][j] == 1) {
                        // if there exists one building not reachable by the path that
                        // we start from one building, that means there will be one building
                        // encircled by obstacles or blocked by other neighbor buildings
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}