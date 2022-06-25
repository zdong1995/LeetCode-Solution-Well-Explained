class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // assumption: s.length() >= 1, words.length >= 1
        List<Integer> res = new ArrayList<>();
        
        Map<String, Integer> need = new HashMap<>();
        for (String word : words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length(); // lenth of word string
        int num = words.length; // number of word to concatenate
        // enumerate all possible start index i
        for (int i = 0; i < s.length() - len * num + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            // check whether can concatenate all words
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (need.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > need.get(word)) {
                        break;
                    }
                    j++;
                    
                } else {
                    break;
                }
            }
            // check al concatenations completed
            if (j == num) {
                res.add(i);
            }
        }
        return res;
    }
}