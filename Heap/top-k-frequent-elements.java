class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // assumption: nums not empty, k is valid
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( 
            (i1, i2) -> counter.get(i1) - counter.get(i2));
        // find top K using minHeap to traverse all the keys
        for (int num : counter.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k -1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}