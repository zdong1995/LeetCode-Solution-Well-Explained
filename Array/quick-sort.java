class Solution {
    public void sortIntegers2(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        // base case
        if (start >= end) { // avoid IndexOutOfBoundsException
            return;
        }
        int pivot = partition(A, start, end);
        quickSort(A, start, pivot - 1);
        quickSort(A, pivot + 1, end);
    }
    
    private int partition(int[] A, int start, int end) {
        // pick one random pivot
        int pivot = start + (int) (Math.random() * (end - start + 1));
        int tmp = A[pivot];
        swap(A, pivot, end); // swap pivot to rightmost first
        // maintain two pointer to partition the array
        int left = start; // [start, left): < tmp (exclusive left)
        int right = end - 1; // (right, end]: >= tmp (exclusive right)
        while (left <= right) {
            if (A[left] < tmp) {
                left++;
            } else if (A[right] >= tmp) {
                right--;
            } else { // A[left] >= tmp && A[right] < tmp
                swap(A, left++, right--);
            }
        }
        // termination: left = right + 1
        swap(A, left, end); // swap pivot back to the middle
        return left; // now the left will be the pivot index
    }
    
    private void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}