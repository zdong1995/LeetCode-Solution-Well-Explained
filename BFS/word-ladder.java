class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        return bfs(beginWord, endWord, dict);
    }

    private int bfs(String beginWord, String endWord, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // Set<String> visited = new HashSet<>();
        // visited.add(beginWord);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                List<String> nextWords = getNextWord(cur, dict);
                for (String nextWord : nextWords) {
                    if (nextWord.equals(endWord)) {
                        return level + 1; // nextWord is in the next level
                    }
                    dict.remove(nextWord); // use dict to check visited
                    queue.offer(nextWord);
                }
            }
            level++;
        }
        return 0; // can not find the transformation path
    }

    private List<String> getNextWord(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char origin = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String newWord = new String(chars);
                if (dict.contains(newWord)) {
                    nextWords.add(newWord);
                }
            }
            chars[i] = origin; // restore state
        }
        return nextWords;
    }
}