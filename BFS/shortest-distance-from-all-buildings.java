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
                    bfs(grid, i, j, cost);
                }
            }
        }
        // after updated cost for each land, find the shortest distance
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) { // check cost of each reachable land
                    shortest = Math.min(shortest, cost[i][j]);
                } else if (grid[i][j] == 3) {
                    grid[i][j] = 0; // recover to the original matrix
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    // using bfs to start from one building to find distance to each land
    private void bfs(int[][] matrix, int x, int y, int[][] cost) {
        // assumption: matrix and cost not null, i and j will not out of bound
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(x, y));
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Cell cur = queue.poll();
                for (int[] dir : DIRECTIONS) {
                    int i = cur.x + dir[0], j = cur.y + dir[1];
                    if (isValid(i, j, matrix, visited)) {
                        queue.offer(new Cell(i, j));
                        visited[i][j] = true;
                        cost[i][j] += minLen;
                    }
                }
            }
            minLen++;
        }
        // pruning to boil down the search range to speed up
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    // if there is lands that can not be reached
                    // we can exclude these cells out from candidates pool
                    matrix[i][j] = 3; // mark these cell as non-land (non-0)
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] matrix, boolean[][] visited) {
        return (x >= 0 && x < matrix.length)
                && (y >= 0 && y < matrix[0].length)
                && matrix[x][y] == 0 // need to be not buildings
                && !visited[x][y];
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