class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() <= k) {
            return s;
        }
        char[] chars = s.toCharArray(); // maintain as stack
        int[] count = new int[chars.length];
        int slow = 0; // [0, slow) will be the result (exclusive)
        
        for (int fast = 0; fast < s.length(); fast++) {
            chars[slow] = chars[fast];
            if (slow > 0 && chars[slow - 1] == chars[fast]) {
                count[slow] = count[slow - 1] + 1;
            } else {
                count[slow] = 1;
            }
            if (count[slow] == k) {
                slow -= k;
            }
            slow++;
        }
        return new String(chars, 0, slow);
    }
}