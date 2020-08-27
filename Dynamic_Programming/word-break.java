class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] canBreak = new boolean[s.length() + 1];
        // canBreak[i] represent whether the substring [0, i) can be break
        for (int i = 1; i <= s.length(); i++) {
            String curWord = s.substring(0, i);
            // case 1: curWord in the dict
            if (dict.contains(curWord)) {
                canBreak[i] = true;
                continue;
            }
            // case 2: curWord need to be splitted
            for (int j = 1; j < i; j++) {
                // enumerate all possible cuts to split the curWord
                if (canBreak[j] && dict.contains(curWord.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}