class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[1];
        // enumerate all possible center of palindrome
        for (int i = 0; i < s.length(); i++) {
            countPalindrome(s, i, i, count); // i-th element as center
            countPalindrome(s, i, i + 1, count); // i-th gap as center
        }
        return count[0];
    }
    
    private void countPalindrome(String s, int left, int right, int[] count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count[0]++;
            left--;
            right++;
        }
    }
}