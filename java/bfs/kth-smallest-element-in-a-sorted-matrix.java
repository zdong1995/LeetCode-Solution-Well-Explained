class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        PriorityQueue<Element> heap = new PriorityQueue<>();
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        // 1. initial state
        heap.offer(new Element(0, 0, matrix[0][0]));
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            // 2. expand node
            Element cur = heap.poll();
            int row = cur.row;
            int col = cur.col;
            // 3. generate neighbors
            // ensure not out of bound and not add to heap duplicated
            if (row + 1 < rowNum && !visited[row + 1][col]) {
                heap.offer(new Element(row + 1, col, matrix[row + 1][col]));
                visited[row + 1][col] = true;
            }
            if (col + 1 < colNum && !visited[row][col + 1]) {
                heap.offer(new Element(row, col + 1, matrix[row][col + 1]));
                visited[row][col + 1] = true;
            }
        }
        return heap.peek().val;
    }
}

class Element implements Comparable<Element> {
    int val;
    int row;
    int col;

    Element(int x, int y, int val) {
        this.row = x;
        this.col = y;
        this.val = val;
    }

    @Override
    public int compareTo(Element that) {
        return this.val - that.val;
    }
}