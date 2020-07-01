public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        /*     n1 -> n2 -> n3 -> n4 -> null
         * if no cycle: fast reach end
         *     n1 -> n2 -> n3 -> n4 -> null
         *            ^-----------
         * if cycled: fast == slow
         */
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) { // fast not reach end
                fast = fast.next.next;
                slow = slow.next;
            } else { // reach end
                return false;
            }
        }
        // out of loop: head == fast
        return true;
    }
}