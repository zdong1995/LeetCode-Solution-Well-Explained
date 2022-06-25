class Solution {
    private static final int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    
    // find the area of island starting from (i, j)
    private int dfs(int[][] grid, int i, int j) {
        // base case
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 ||
            grid[i][j] == 0) { // invalid case
            return 0;
        }
        // valid, continue search
        grid[i][j] = 0; // mark as visited
        int area = 1; // count current land
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            area += dfs(grid, x, y);
        }
        return area;
    }
}