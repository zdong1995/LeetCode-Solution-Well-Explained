class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        // use one monotonic ascending stack to record the increasing sequence
        Deque<Integer> stack = new ArrayDeque<>();
        // the area of rectangle with height = height of each bar
        // is determined by the left bound and right bound
        // left bound: the index of previous bar in the stack
        // right bound: the index of first bar that smaller than stack top
        // width of rectangle = right - (left + 1)
        
        for (int i = 0; i <= heights.length; i++) {
            // add a bar of height 0 at the end, i.e. index = heights.length
            // thus we can pop out all the element after traverse all heights
            int curHeight = i == heights.length ? 0 : heights[i];
            // keep popping when we met one falling down from increasing sequence
            while (!stack.isEmpty() && heights[stack.peekFirst()] >= curHeight) {
                int height = heights[stack.pollFirst()];
                // the index range will be (stack.peek(), i)
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                res = Math.max(res, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return res;
    }
}