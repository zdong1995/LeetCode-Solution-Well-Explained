class Solution {
    public void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                countZero++;
        }
        int fast = arr.length - 1; // fast point to element in original array
        int slow = arr.length + countZero - 1; // slow point to simulated new array
        while (fast < slow) {
            if (arr[fast] != 0) {
                if (slow < arr.length) {
                    arr[slow] = arr[fast];
                }
            } else { // duplicate zeroes
                if (slow < arr.length) {
                    arr[slow] = 0;
                }
                slow--;
                if (slow < arr.length) {
                    arr[slow] = 0; // copy zero twice
                }
            }
            fast--;
            slow--; 
        }
    }
}