class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        // paths[i][j] represents how many paths to reach (i,j) grid
        paths[0][0] = 0; // base case 1
        
        for (int i = 0; i < m; i++) { // base case 2
            paths[i][0] = 1; // only one path from left
        }
        
        for (int j = 0; j < n; j++) { // base case 3
            paths[0][j] = 1; // only one path from up
        }
        
        // induction rule
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                // paths = paths from left + paths from up
            }
        }
        return paths[m - 1][n - 1];
    }
}