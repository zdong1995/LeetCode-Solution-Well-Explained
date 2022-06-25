class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int water = 0;
        int left = 0;
        int leftMax = height[left]; // left max height in range [0, left]
        int right = height.length - 1;
        int rightMax = height[right]; // right max height in range [right, n-1]
        
        while (left < right) {
            // update left and right max
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            // the water trapped at current index is determined by shorter side
            // water trapped = max water level - current height
            if (leftMax < rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}