// DFS
class Solution {
    final static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // delta_x, delta_y

    public int numIslands(char[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        // traverse whole matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') { // unexplored land
                    count++;
                    // find all neighbors of current land
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y, int rows, int cols) {
        // base case
        if (x < 0 || x >= rows || y < 0 || y >= cols) { // Case 1: IndexOutOfBound
            return;
        }
        if (grid[x][y] == '0') { // Case 2: water OR already visited land (marked to '0')
            return;
        }
        // recursion rule
        grid[x][y] = '0'; // mark as visited
        for (int[] dir : dirs) { // traverse
            int neiX = dir[0] + x;
            int neiY = dir[1] + y;
            dfs(grid, neiX, neiY, rows, cols);
        }
    }
}

// BFS
class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, new Point(i, j));
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, Point start) {
        Queue<Point> queue = new LinkedList<>();
        int[] dirX = new int[] { 1, 0, -1, 0 };
        int[] dirY = new int[] { 0, 1, 0, -1 };

        queue.offer(start);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            grid[curr.row][curr.col] = '0'; // belong to island, mark as visted
            for (int i = 0; i < dirX.length; i++) {
                int newRow = curr.row + dirX[i];
                int newCol = curr.col + dirY[i];
                if (inBound(newRow, newCol, grid) && grid[newRow][newCol] == '1') {
                    queue.offer(new Point(newRow, newCol));
                }
            }
        }
    }

    private boolean inBound(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}