class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // assumpiton: paragraph not null and length > 0
        Map<String, Integer> counter = new HashMap<>();
        Set<String> bannedWords = new HashSet(Arrays.asList(banned));
        char[] charArray = paragraph.toCharArray();
        StringBuilder curWord = new StringBuilder();
        String result = "";
        int maxCount = 0;
        
        for (int i = 0; i < charArray.length; i++) {
            Character cur = charArray[i];
            // case 1: is letter -> expand curWord
            if (Character.isLetter(cur)) {
                curWord.append(Character.toLowerCase(cur));

                if (i != charArray.length - 1) {
                    continue;
                }
            }
            // case 2: is not letter -> end of curWord
            if (curWord.length() > 0) {
                String word = new String(curWord);
                if (bannedWords.contains(word)) {
                    curWord = new StringBuilder();
                    continue;
                }
                counter.putIfAbsent(word, 0);
                counter.put(word, counter.get(word) + 1);
                if (counter.get(word) > maxCount) {
                    maxCount = counter.get(word);
                    result = word;
                }
                // reset stringbuilder
                curWord = new StringBuilder();
            }
        }
        return result;
    }
}