class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        int odd = 0;
        for(int c : count){
            if(c % 2 != 0){
                odd++;
            }
        }
        return odd == 0 ? s.length() : s.length() - odd + 1;
    }
}