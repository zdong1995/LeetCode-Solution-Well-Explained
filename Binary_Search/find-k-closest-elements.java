class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        int left = largestSmallerEqual(arr, x);
        int right = left + 1;
        // when to move left: left is closer / right reached bound
        for (int i = 0; i < k; i++) {
            if (right >= arr.length || left >= 0 &&
                x - arr[left] <= arr[right] - x) {
                res.add(arr[left--]);
            } else {
                res.add(arr[right++]);
            }
        }
        Collections.sort(res);
        return res;
    }
    
    private int largestSmallerEqual(int[] array, int target) {
        // find the largest smaller or equal element's index in the array
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // left = right - 1
        if (array[right] <= target) {
            return right;
        }
        if (array[left] <= target) {
            return left;
        }
        // can not find target
        return -1;
    }
}