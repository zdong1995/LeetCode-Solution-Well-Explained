class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length, col = matrix[0].length;
        // boolean[i][j]: whether cell[i][j] is reachable starting from each occean
        boolean[][] pacific = new boolean[row][col]; 
        boolean[][] atlantic = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();
        // bfs to find the reachable points of pacific ocean
        addPacificEdge(matrix, queue, pacific);
        bfs(matrix, queue, pacific, atlantic, res);
        // bfs to find the reachable points of atlantic ocean and find overlap
        addAtlanticEdge(matrix, queue, atlantic);
        bfs(matrix, queue, atlantic, pacific, res);

        return res;
    }

    private void bfs(int[][] matrix, Queue<Integer> queue,
                            boolean[][] self, // ocean to be updated reachalbe
                            boolean[][] another, // ocean to be used to calculate overlap
                            List<List<Integer>> res) {
        int row = matrix.length, col = matrix[0].length;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / col, j = cur % col;
            if (another[i][j]) { // both this ocean and another ocean can read current cell
                res.add(Arrays.asList(i, j));
            }
            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0], jj = j + dir[1];
                // check whether reversed water flow and not been flowed before
                if ((ii >= 0 && ii < row) && (jj >= 0 && jj < col)
                        && matrix[ii][jj] >= matrix[i][j] && !self[ii][jj]) {
                    queue.offer(ii * col + jj);
                    self[ii][jj] = true;
                }
            }
        }
    }

    private void addPacificEdge(int[][] matrix, Queue<Integer> queue, boolean[][] pacific) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) { // add left col
            pacific[i][0] = true;
            queue.offer(i * col);
        }
        // avoid corner to be added twice
        for (int j = 1; j < col; j++) { // add top row
            pacific[0][j] = true;
            queue.offer(j);
        }
    }
    
    private void addAtlanticEdge(int[][] matrix, Queue<Integer> queue, boolean[][] atlantic) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) { // add right col
            atlantic[i][col - 1] = true;
            queue.offer(i * col + col - 1);
        }
        // avoid corner to be added twice
        for (int j = 0; j < col - 1; j++) { // add bottom row
            atlantic[row - 1][j] = true;
            queue.offer((row - 1) * col + j);
        }
    }
}