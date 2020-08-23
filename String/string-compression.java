class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int slow = 0; // [0, slow) will be returned (exclusive)
        int fast = 0;
        while (fast < chars.length) {
            chars[slow++] = chars[fast];
            int count = 0;
            while (fast < chars.length && chars[fast] == chars[slow - 1]) { // same as last element
                fast++;
                count++;
            }
            if (count <= 1) { // no need to do anything for char only appeared once
                continue;
            }
            char[] countChar = Integer.toString(count).toCharArray();
            for (char num : countChar) {
                chars[slow++] = num;
            }
        }
        return slow;
    }
}