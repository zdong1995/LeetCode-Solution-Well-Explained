class Solution {
    public String removeDuplicates(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }
        char[] chars = S.toCharArray(); // maintain as stack
        int slow = 0; // slow is the last element to be returned
        // [0, slow] will be the result after removing (inclusive)
        
        for (int fast = 1; fast < S.length(); fast++) {
            if (slow >= 0 && chars[slow] == chars[fast]) { // stack has data
                slow--; // stack.pop()
            } else {
                chars[++slow] = chars[fast]; // stack.offer()
            }
        }
        return new String(chars, 0, slow + 1);
    }
}