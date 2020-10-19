class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        // find first element that greater than target
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) { // search leftside
                right = mid;
            } else {
                left = mid;
            }
        }
        if (letters[left] > target) {
            return letters[left];
        }
        return letters[right];
    }
}