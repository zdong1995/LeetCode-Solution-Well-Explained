class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return; // throw new IllegalArgumentException();
        }

        int row = rooms.length, col = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        addAllZeroes(rooms, queue); // start from all the GATE

        int minLen = 1; // the first distance we can set to the neighbor of GATE is 1
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col; // convert to 2D pair
                int j = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    // check bound and use current position == INF to check visited
                    if ((jj >= 0 && jj < col) && (ii >= 0 && ii < row) && rooms[ii][jj] == Integer.MAX_VALUE) {
                        queue.offer(ii * col + jj);
                        rooms[ii][jj] = minLen; // update current distance
                    }
                }
            }
            minLen++; // expand bfs to next circle
        }
    }

    private void addAllZeroes(int[][] rooms, Queue<Integer> queue) {
        int col = rooms[0].length;
        // add all the GATEs into queue as beginning of bfs
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) { // current cell is GATE
                    queue.offer(i * col + j); // convert 2D coordinate to 1D
                }
            }
        }
    }
}