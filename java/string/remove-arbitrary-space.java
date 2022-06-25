class Solution {
    /**
     * @param s: the original string
     * @return: the string without arbitrary spaces
     */
    public String removeExtra(String s) {
        if (s == null) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int slow = 0; // [0, slow) will be the result to return
        int fast = 0; // fast will traverse the whole string
        int count = 0; // determine whether it is the first word
        while(true) {
            // 1: fast position is space -> fast++
            while (fast < charArray.length && charArray[fast] == ' ') {
                fast++;
            }
            
            if (fast == charArray.length) {
                break;
            }
            // 2: add one heading space for non-first word
            if (count > 0) {
                charArray[slow++] = ' ';
            }
            // 3. fast position is not space -> copy to slow
            while (fast < charArray.length && charArray[fast] != ' ') {
                charArray[slow++] = charArray[fast++];
            }
            count++;
        }
        return new String(charArray, 0, slow);
    }
}