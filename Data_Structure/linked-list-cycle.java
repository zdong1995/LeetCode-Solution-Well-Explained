public class Solution {
    public boolean hasCycle(ListNode head) {
        /*     n1 -> n2 -> n3 -> n4 -> null
         * if no cycle: fast reach end
         *     n1 -> n2 -> n3 -> n4 -> null
         *            ^-----------
         * if cycled: fast == slow
         */
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // not reach end
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) { 
                return true;
        }
        return false;
        }
}