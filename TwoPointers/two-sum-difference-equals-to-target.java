public class Solution {
    public int[] twoSumDifference(int[] array, int target) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        target = Math.abs(target); // min - max = -1 * (max - min)
        int left = 0;
        int right = 1;

        while (left < right && right < array.length) {
            int diff = array[right] - array[left];
            if (diff == target) {
                return new int[] { array[left], array[right] };
            } else if (diff < target) { // right is not big enough
                right++;
            } else { // left is a little small
                left++;
                if (left == right) { // left and right can't be the same
                    right++;
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
