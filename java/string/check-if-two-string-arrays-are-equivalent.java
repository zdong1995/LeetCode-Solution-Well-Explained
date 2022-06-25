class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int chIdx1 = 0, chIdx2 = 0;
        int strIdx1 = 0, strIdx2 = 0;
        
        while (strIdx1 < word1.length && strIdx2 < word2.length) {
            String str1 = word1[strIdx1], str2 = word2[strIdx2];
            if (str1.charAt(chIdx1++) != str2.charAt(chIdx2++)) {
                return false;
            }
            if (chIdx1 == str1.length()) { // move to next string, reset charIdx
                strIdx1++;
                chIdx1 = 0;
            }
            if (chIdx2 == str2.length()) { // move to next string, reset charIdx
                strIdx2++;
                chIdx2 = 0;
            }
        }
        return strIdx1 == word1.length && strIdx2 == word2.length;
    }
}