class Solution {
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        for (char curChar : chars) {
            count.put(curChar, count.getOrDefault(curChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (count.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}