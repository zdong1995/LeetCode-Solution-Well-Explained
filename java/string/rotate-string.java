class Solution {
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        reverse(str, 0, str.length - 1 - offset);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length -1);
    }
    
    private void reverse(char[] str, int start, int end) {
        // base case
        if (start >= end) {
            return;
        }
        
        // recursion rule
        char tmp = str[start];
        str[start] = str[end];
        str[end] = tmp;
        reverse(str, start + 1, end - 1);
    }
}