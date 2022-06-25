// Time: O(logN)
// Space: O(1)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
    
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid; // search left to find the smallest larger
            } else {
                left = mid;
            }
        }
        
        if (letters[left] > target) {
            return letters[left];
        }
        if (letters[right] > target) {
            return letters[right];
        }
        // not found, just return the first element
        return letters[0];
    }
}