class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 
            || matrix[0] == null || matrix[0].length == 0) {
            return new int[0][0];
        }
        
        int[][] res = new int[matrix.length][matrix[0].length]; // initially all 0s
        Queue<Cell> queue = new LinkedList<>();
        addAllZeros(matrix, queue);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Cell cur = queue.poll();
                for (int[] dir : DIRECTIONS) {
                    int i = cur.x + dir[0], j = cur.y + dir[1];
                    if (isValid(i, j, matrix, res)) {
                        res[i][j] = level;
                        queue.offer(new Cell(i, j));
                    }
                }
            }
            level++;
        }
        return res;
    }

    private boolean isValid(int i, int j, int[][] matrix, int[][] res) {
        return (i >= 0 && i < matrix.length) 
            && (j >= 0 && j < matrix[0].length)
            && matrix[i][j] == 1 && res[i][j] == 0; // not visited
    }

    private void addAllZeros(int[][] matrix, Queue<Cell> queue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Cell(i, j));
                }
            }
        }
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