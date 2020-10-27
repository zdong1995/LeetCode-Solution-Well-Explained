class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        // counter to store the group of each anagram
        Map<String, List<String>> counter = new HashMap<>();
        for (String str : strs) {
            // count frequency of char appeared in the string
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!counter.containsKey(key)) {
                counter.put(key, new ArrayList<>());
            }
            // add current string to corresponding group
            counter.get(key).add(str);
        }
        return new ArrayList<>(counter.values());
    }
}