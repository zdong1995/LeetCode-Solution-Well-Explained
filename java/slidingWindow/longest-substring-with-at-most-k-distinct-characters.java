class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        
        Map<Character, Integer> counter = new HashMap<>();
        int left = 0, right = 0, typeChars = 0;
        int maxLen = Integer.MIN_VALUE;
        
        while (right < s.length()) {
            // expand window
            char cur = s.charAt(right);
            counter.put(cur, counter.getOrDefault(cur, 0) + 1);
            if (counter.get(cur) == 1) { // newly added new unique char
                typeChars++;
            }
            right++;
            
            while (typeChars > k) {
                // shrink window
                char toDel = s.charAt(left);
                counter.put(toDel, counter.get(toDel) - 1);
                if (counter.get(toDel) == 0) {
                    typeChars--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}