class Solution {
    // Time: O(3^4) -> O(1)
    // Space: O(12) -> O(1)
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        findAddresses(s, res, new StringBuilder(), 0, 0);
        return res;
    }

    private void findAddresses(String s, List<String> res, StringBuilder cur, int idx, int part) {
        // base case: finish separating all the parts
        if (part == 4) {
            if (idx == s.length()) { // successful find one valid IP address
                cur.deleteCharAt(cur.length() - 1); // remove the fourth dot
                res.add(cur.toString());
            }
            return; // don't forget
        }

        int len = cur.length(); // store the orgin len for restore
        int num = 0; // the num value of current part digits
        // seprating the degits for current part
        for (int i = idx; i < idx + 4; i++) {
            if (i >= s.length()) {
                break;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num >= 0 && num <= 255) {
                cur.append(num).append(".");
                findAddresses(s, res, cur, i + 1, part + 1);
                cur.setLength(len); // recover state
            }
            if (num == 0) { // handle the case that first number of current part is 0
                // pruning leading zero branch, to need to dive deep
                break;
            }
        }
    }
}