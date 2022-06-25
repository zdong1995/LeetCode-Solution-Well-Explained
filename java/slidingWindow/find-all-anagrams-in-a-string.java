class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // assumption: p is non-empty
        if (s == null || s.length() == 0) {
            return res;
        }
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, toMatch = need.size();
        
        while (right < s.length()) {
            // expand window
            char cur = s.charAt(right);
            if (need.containsKey(cur)) {
                need.put(cur, need.get(cur) - 1);
                if (need.get(cur) == 0) {
                    toMatch--;
                }
            }
            right++;
            
            while (toMatch == 0) {
                // update result
                if (right - left == p.length()) {
                    res.add(left);
                }
                // shrink window
                char toDel = s.charAt(left);
                if (need.containsKey(toDel)) {
                    need.put(toDel, need.get(toDel) + 1);
                    if (need.get(toDel) == 1) {
                        toMatch++;
                    }
                }
                left++;
            }
        }
        return res;
    }
}