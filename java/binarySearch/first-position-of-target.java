public class Solution {
    public int firstPosition(int[] array, int target) {
      if (array == null || array.length == 0) {
        return -1;
      }
      int left = 0;
      int right = array.length - 1;
      while (left + 1 < right) {
        int mid = left + (right - left) / 2;
        if (array[mid] < target) {
          left = mid; // continue search leftside to find first one
        } else if (array[mid] == target) {
          right = mid;
        } else { // array[mid] > target
          right = mid;
        }
      }
      // post-processing
      if (array[left] == target) {
        return left;
      }
      if (array[right] == target) {
        return right;
      }
      return -1;
    }
  }
  