class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int slow = 0; // slow represent the first letter of current word
        for (int fast = 0; fast < s.length; fast++) {
            // move right to space position
            if (s[fast] == ' ') {
                // swap current word
                reverse(s, slow, fast - 1);
                // update slow to first letter of next word
                slow = fast + 1;
            }
        }
        // reverse the last one word
        reverse(s, slow, s.length - 1);
        // after all the words reversed, reverse the sentence
        reverse(s, 0, s.length - 1);
    }
    
    private void reverse(char[] chars, int left, int right) {
        // base case
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    } 
}