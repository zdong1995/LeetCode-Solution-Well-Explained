class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) { // sanity check
            return s;
        }
        
        int[] res = new int[2]; // [maxLen, startIndex]
        // enumerate all possible center of palindrome
        for (int i = 0; i < s.length(); i++) {
            findLongest(s, i, i, res); // i-th element as center -> maxLen is odd
            findLongest(s, i, i + 1, res); // i-th gap as center -> maxLen is even
        }
        return s.substring(res[1], res[0] + res[1]);
    }
    
    private void findLongest(String s, int left, int right, int[] res) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > res[0]) {
            res[0] = right - left - 1; // update maxLen
            res[1] = left + 1; // update startIndex
        }
    }
}