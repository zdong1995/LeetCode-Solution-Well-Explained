class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // use pair to store character and corresponding counter
        Map<Character, Integer> countMap = new HashMap<>();
        int slow = 0;
        int maxLength = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char cur = s.charAt(fast);
            countMap.put(cur, countMap.getOrDefault(cur, 0) + 1);
            while (countMap.get(cur) > 1) { // need to shrink window
                // move slow and decrease counter
                countMap.put(s.charAt(slow), 
                             countMap.get(s.charAt(slow)) - 1);
                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
        }
        return maxLength;
    }
}