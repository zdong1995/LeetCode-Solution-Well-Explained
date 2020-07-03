public class Solution {
    public int lastPosition(int[] array, int target) {
     if (array == null || array.length == 0) {
       return -1;
     }
     int left = 0;
     int right = array.length - 1;
     while (left + 1 < right) { // terminate when left and right neighbours
       int mid = left + (right - left) / 2;
       if (array[mid] == target) {
         left = mid; // continue search rightside to find last one
       } else if (array[mid] > target) {
         right = mid;
       } else {
         left = mid;
       }
     }
     // post processing
     if (array[right] == target) {
       return right;
     }
     if (array[left] == target) {
       return left;
     }
     return -1;
    }
  }