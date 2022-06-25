class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        // build a mindHeap
        // int[]: 0: numerator idx, 1: denominator idx
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] f1, int[] f2) { // p1/q1 vs. p2/q2
                // p1 * q2 - q1 * p2
                return A[f1[0]] * A[f2[1]] - A[f1[1]] * A[f2[0]];
            }
        });
        for (int i = 0; i < A.length; i++) {
            minHeap.offer(new int[] {0, i});
        }
        
        // expand and generate (k-1) times
        for (int i = 0; i < K - 1; i++) {
            int[] cur = minHeap.poll();
            int pIdx = cur[0];
            int qIdx = cur[1];
            if (pIdx + 1 < qIdx) {
                minHeap.offer(new int[] {pIdx + 1, qIdx});
            }
        }
        int[] res = minHeap.peek();
        return new int[] {A[res[0]], A[res[1]]};
    }
}