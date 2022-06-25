class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        Set<String> paths = new HashSet<>(); // store all direction paths of islands
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, path, 'S'); // start
                    paths.add(path.toString());
                }
            }
        }
        return paths.size();
    }

    // dfs to find island starting from (x, y), and record the direction path into "path"
    private void dfs(int[][] grid, int x, int y, StringBuilder path, char dir) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0; // mark as visited
        path.append(dir);
        dfs(grid, x + 1, y, path, 'R'); // Right
        dfs(grid, x - 1, y, path, 'L'); // Left
        dfs(grid, x, y + 1, path, 'U'); // Up
        dfs(grid, x, y - 1, path, 'D'); // Down
        path.append("T"); // mark backtracking, T shape turn
    }
}