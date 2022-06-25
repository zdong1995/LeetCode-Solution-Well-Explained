// Two pointers
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}

// Recursion
class Solution {
    public void reverseString(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }
    
    private void reverseHelper(char[] s, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        reverseHelper(s, left + 1, right - 1);
    }
}