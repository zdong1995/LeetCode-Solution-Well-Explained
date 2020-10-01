class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> dict = buildDict();
        dfs(digits, res, 0, dict, new StringBuilder());
        return res;
    }
    
    private void dfs(String digits, List<String> res, int index, 
                     Map<Character, String> dict, StringBuilder sb) {
        // base case
        if (index == digits.length()) {
            res.add(new String(sb));
            return;
        }
        
        String letters = dict.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) { // N-nary Tree traverse
            sb.append(letters.charAt(i));
            dfs(digits, res, index + 1, dict, sb);
            sb.deleteCharAt(sb.length() - 1); // recover state
        }
    }
    
    private Map<Character, String> buildDict() {
        Map<Character, String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        return dict;
    }
}