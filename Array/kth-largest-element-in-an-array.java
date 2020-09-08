class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue(k);
        // keep the element in minHeap is top k largest elements
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.offer(nums[i]);
            } else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}