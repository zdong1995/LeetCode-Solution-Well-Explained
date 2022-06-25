class KthLargest {
    final private PriorityQueue<Integer> minHeap;
    final private int K;
    
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        K = k;
        // add initial number to minHeap
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < K) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}