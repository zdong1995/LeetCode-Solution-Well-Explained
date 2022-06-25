class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int toMatch = need.size(); // types of letters need to match
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        while (right < s.length()) {
            // expand window
            char cur = s.charAt(right);
            if (need.containsKey(cur)) {
                need.put(cur, need.get(cur) - 1);
                if (need.get(cur) == 0) { // window has needed number of cur letter
                    toMatch--;
                }
            }
            right++;
            
            while (toMatch == 0) {
                // update minLen and start index of result
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                // shrink window
                char toDel = s.charAt(left);
                if (need.containsKey(toDel)) {
                    need.put(toDel, need.get(toDel) + 1);
                    if (need.get(toDel) == 1) {
                        // window not have enought number of toDel letter to match
                        toMatch++;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}