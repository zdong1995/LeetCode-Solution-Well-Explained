class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res; 
        }
        // record all the last index of all characters
        int[] lastIdxs = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIdxs[S.charAt(i) - 'a'] = i;
        }
        int start = 0; // start index of current partition
        while (start < S.length()) {
            int last = lastIdxs[S.charAt(start) - 'a'];
            for (int cur = start; cur < last; cur++) {
                // if met new character, we need to extend current partition to
                // include the last index of new character
                if (lastIdxs[S.charAt(cur) - 'a'] > last) {
                    last = lastIdxs[S.charAt(cur) - 'a'];
                }
            }
            // cur == last
            // terminate current partition, add to result and reset start
            res.add(last - start + 1);
            start = last + 1;
        }
        return res;
    }
}