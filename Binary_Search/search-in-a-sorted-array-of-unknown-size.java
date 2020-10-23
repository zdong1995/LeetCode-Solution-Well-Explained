class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        // find the right bound of the array
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        // binary search to find target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = reader.get(mid);
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                left = mid + 1;
            } else { // out of bound or larger than target
                right = mid - 1;
            }
        }
        return -1;
    }
}