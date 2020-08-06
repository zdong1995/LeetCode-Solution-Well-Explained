class Solution {
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return;
        }
        
        int[] tmp = new int[A.length];
        mergeSort(A, 0, A.length - 1, tmp);
    }
    
    private void mergeSort(int[] A, int left, int right, int[] tmp) {
        // base case
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(A, left, mid, tmp);
        mergeSort(A, mid + 1, right, tmp);
        merge(A, left, right, tmp);
    }
    
    private void merge(int[] A, int left, int right, int[] tmp) {
        int mid = left + (right - left) / 2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = leftIndex;
        
        while (leftIndex <= mid && rightIndex <= right) {
            if (A[leftIndex] < A[rightIndex]) {
                tmp[index++] = A[leftIndex++];
            } else {
                tmp[index++] = A[rightIndex++];
            }
        }
        
        while (leftIndex <= mid) {
            tmp[index++] = A[leftIndex++];
        }
        
        while (rightIndex <= right) {
            tmp[index++] = A[rightIndex++];
        }
        
        for (int i = left; i <= right; i++) {
            A[i] = tmp[i];
        }
    }
}