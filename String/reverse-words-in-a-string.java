class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        char[] chars = s.toCharArray();
        int end = removeSpace(chars); // right boundary after removing space
        int slow = 0; // slow represent the first letter of current word
        for (int fast = 0; fast < end; fast++) {
            if (chars[fast] == ' ') {
                // swap current word
                reverse(chars, slow, fast - 1);
                // update slow to first letter of next word
                slow = fast + 1;
            }
        }
        // reverse the last one word
        reverse(chars, slow, end - 1);
        // after all the words reversed, reverse the sentence
        reverse(chars, 0, end - 1);
        return new String(chars, 0, end);
    }
    
    private void reverse(char[] chars, int left, int right) {
        // base case
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }
    
    private int removeSpace(char[] chars) {
        int slow = 0; // the left of slow will be returned (exclusive)
        int fast = 0;
        int count = 0;
        while (fast < chars.length) {
            // skip all the spaces in front of each word
            while (fast < chars.length && chars[fast] == ' ') {
                fast++;
            }
            if (fast == chars.length) { // done
                break;
            }
            // add one space before the next word (exclusive 1st word)
            if (count > 0) {
                chars[slow++] = ' ';
            }
            // copy letter of each word to slow
            while (fast < chars.length && chars[fast] != ' ') {
                chars[slow++] = chars[fast++];
            }
            count++;
        }
        return slow;
    }
}