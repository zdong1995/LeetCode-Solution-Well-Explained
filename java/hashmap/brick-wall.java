class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        // counter of bricks at edges in different length
        // key = length at the edge, value = count of bricks
        Map<Integer, Integer> counter = new HashMap<>();
        // record the max number of bricks that have no cross at one length
        int maxCount = Integer.MIN_VALUE;
        
        for (List<Integer> line : wall) {
            // calculate prefix sum as length of each edge
            int edge = 0;
            // skip the last brick to avoid edge at end
            for (int i = 0; i < line.size() - 1; i++) {
                edge += line.get(i);
                counter.put(edge, counter.getOrDefault(edge, 0) + 1);
                maxCount = Math.max(maxCount, counter.get(edge));
            }
        }
        // avoid the case that only one brick in each line
        // otherwise the minCross = rowNum - maxCount
        return maxCount == Integer.MIN_VALUE ? wall.size() : wall.size() - maxCount;
    }
}