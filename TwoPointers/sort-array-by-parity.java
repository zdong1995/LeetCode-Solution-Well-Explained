class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length  == 0) {
            return new int[0];
        }
        int left = 0; // [0, left) will be even numbers
        int right = A.length - 1; // (right, n-1] will be odd numbers
        while (left < right) {
            if (A[left] % 2 == 0) {
                left++;
            } else if (A[right] % 2 == 1) {
                right--;
            } else { // left is odd and right is even -> swap
                int temp = A[left];
                A[left++] = A[right];
                A[right--] = temp;
            }
        }
        return A;
    }
}