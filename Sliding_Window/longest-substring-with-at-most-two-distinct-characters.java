class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> counter = new HashMap<>();
        int left = 0; // left bound of sliding window
        int right = 0; // right bound
        int charTypes = 0; // type of unique letters in sliding window
        int maxLen = Integer.MIN_VALUE;
        
        while (right < s.length()) {
            // expand window
            char cur = s.charAt(right);
            counter.put(cur, counter.getOrDefault(cur, 0) + 1);
            if (counter.get(cur) == 1) { // newly added element
                charTypes++;
            }
            right++;
            
            while (charTypes > 2) {
                // shrink window
                char toDel = s.charAt(left);
                counter.put(toDel, counter.get(toDel) - 1);
                if (counter.get(toDel) == 0) {
                    charTypes--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}